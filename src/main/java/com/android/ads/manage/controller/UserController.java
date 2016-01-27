package com.android.ads.manage.controller;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.android.ads.manage.model.User;
import com.android.ads.manage.service.IUserService;
import com.android.ads.manage.utils.BaseResponse;
import com.android.ads.manage.utils.JacksonUtil;
import com.android.ads.manage.utils.ReturnCode;

@Controller
@RequestMapping(value="user",produces="text/plain;charset=UTF-8")
public class UserController {
	
	@Resource
	private IUserService userService;
	
	@ResponseBody
	@RequestMapping("singup")
	public String singup(HttpServletResponse response, User user) {
		String returnCode = ReturnCode.HTTP_REQUEST_SUCCESS;
		try {
			User pUser = userService.getUserByEmail(user.getEmail());
			if(pUser != null) {
				returnCode = ReturnCode.HTTP_REQUEST_USER_EMAIL_EXISTS_ERROR;
			} else {
				user.setUserStatus(1);
				user.setUserType(1);
				userService.saveUser(user);
				String cookieName = user.getEmail() + ":" + user.getPassword() + ":" + user.getId();
				Cookie cookie = new Cookie("user", cookieName);
				cookie.setPath("/");
				response.addCookie(cookie);
			}
		} catch (Exception e) {
			returnCode = ReturnCode.HTTP_REQUEST_ERROR;
			e.printStackTrace();
		}
		BaseResponse baseResponse = new BaseResponse(returnCode);
		return JacksonUtil.beanToJson(baseResponse);
	}
	
	@ResponseBody
	@RequestMapping("singin")
	public String singin(HttpServletResponse response, String email, String password, String remember) {
		String returnCode = ReturnCode.HTTP_REQUEST_SUCCESS;
		try {
			User user = userService.getUserByEmail(email);
			if(user != null && user.getPassword().equals(password)) {
				String cookieName = user.getEmail() + ":" + user.getPassword() + ":" + user.getId();
				Cookie cookie = new Cookie("user", cookieName);
				cookie.setPath("/");
				if("on".equals(remember)) {
					cookie.setMaxAge(60 * 60 * 24 * 365 * 2);
					response.addCookie(cookie);
				}
				response.addCookie(cookie);
			} else {
				returnCode = ReturnCode.HTTP_REQUEST_ERROR;
			}
		} catch (Exception e) {
			returnCode = ReturnCode.HTTP_REQUEST_ERROR;
			e.printStackTrace();
		}
		BaseResponse baseResponse = new BaseResponse(returnCode);
		return JacksonUtil.beanToJson(baseResponse);
	}
	
	@RequestMapping("signout")
	public String signout(HttpServletResponse response) {
		Cookie cookie = new Cookie("user", null);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
		return "redirect:../signin.html";
	}
	
	@RequestMapping("user-info")
	public String toUserInfo() {
		return "user-info";
	}
	
}
