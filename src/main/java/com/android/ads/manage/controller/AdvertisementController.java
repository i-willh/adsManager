package com.android.ads.manage.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.android.ads.manage.interceptor.SecurityInterceptor;
import com.android.ads.manage.model.AdvertType;
import com.android.ads.manage.model.Advertisement;
import com.android.ads.manage.service.IAdvertisementService;
import com.android.ads.manage.utils.BaseResponse;
import com.android.ads.manage.utils.JacksonUtil;
import com.android.ads.manage.utils.Pager;
import com.android.ads.manage.utils.ReturnCode;

@Controller
@RequestMapping(value="ads",produces="text/plain;charset=UTF-8")
public class AdvertisementController {
	
	private static final int PAGE_SIZE = 10;
	
	@Resource
	private IAdvertisementService advertisementService;
	
	@RequestMapping("new-ads")
	public String toTest() {
		return "new-ads";
	}
	
	@ResponseBody
	@RequestMapping("saveAds")
	public String saveAdvertisement(HttpServletRequest request, Advertisement advertisement) {
		String returnCode = ReturnCode.HTTP_REQUEST_SUCCESS;
		try {
			advertisement.setCreateUser(getUserIdFromCookies(request));
			advertisement.setUpdateUser(getUserIdFromCookies(request));
			advertisementService.saveAdvertisement(advertisement);
		} catch (Exception e) {
			returnCode = ReturnCode.HTTP_REQUEST_ERROR;
			e.printStackTrace();
		}
		BaseResponse baseResponse = new BaseResponse(returnCode);
		return JacksonUtil.beanToJson(baseResponse);
	}
	
	@RequestMapping("ads-list")
	public String toAdsList() {
		return "ads-list";
	}
	
	@ResponseBody
	@RequestMapping("countAds")
	public String countAdvertisement(HttpServletRequest request, Advertisement advertisement) {
		String returnCode = ReturnCode.HTTP_REQUEST_SUCCESS;
		Pager<Advertisement> pager = null;
		try {
			long count = advertisementService.countAdvertisement(advertisement.getAppPackage(), advertisement.getAdvertiser(), advertisement.getAdvertType(), getUserIdFromCookies(request));
			pager = new Pager<>(count, PAGE_SIZE);
		} catch (Exception e) {
			returnCode = ReturnCode.HTTP_REQUEST_ERROR;
			e.printStackTrace();
		}
		BaseResponse baseResponse = new BaseResponse(returnCode, pager);
		return JacksonUtil.beanToJson(baseResponse);
	}
	
	@ResponseBody
	@RequestMapping("queryAds")
	public String queryAdvertisement(HttpServletRequest request, Advertisement advertisement, int page) {
		String returnCode = ReturnCode.HTTP_REQUEST_SUCCESS;
		Pager<Advertisement> pager = null;
		try {
			List<Advertisement> list = advertisementService.pageAdvertisement(advertisement.getAppPackage(), advertisement.getAdvertiser(), advertisement.getAdvertType(), getUserIdFromCookies(request), page * PAGE_SIZE, PAGE_SIZE);
			list.forEach(ad -> {
				ad.setAdvertTypeName(AdvertType.advertTypeMap.get(ad.getAdvertType()));
			});
			pager = new Pager<>(list, PAGE_SIZE);
		} catch (Exception e) {
			returnCode = ReturnCode.HTTP_REQUEST_ERROR;
			e.printStackTrace();
		}
		BaseResponse baseResponse = new BaseResponse(returnCode, pager);
		return JacksonUtil.beanToJson(baseResponse);
	}
	
	private int getUserIdFromCookies(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		String cookieValue = null;
		for(int i = 0; i < cookies.length; i++) {
			if(SecurityInterceptor.COOKIEDOMAINNAME.equals(cookies[i].getName())) {
				cookieValue = cookies[i].getValue();
				break;
			}
		}
		return Integer.parseInt(cookieValue.split(":")[2]);
	}
}
