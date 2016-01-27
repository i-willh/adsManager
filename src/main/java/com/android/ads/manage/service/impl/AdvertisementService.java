package com.android.ads.manage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.android.ads.manage.dao.IAdvertisementDao;
import com.android.ads.manage.model.Advertisement;
import com.android.ads.manage.service.IAdvertisementService;

@Service
public class AdvertisementService implements IAdvertisementService {
	
	@Resource
	private IAdvertisementDao advertisementDao;

	@Override
	public int saveAdvertisement(Advertisement advertisement) throws Exception {
		return advertisementDao.saveAdvertisement(advertisement);
	}

	@Override
	public List<Advertisement> pageAdvertisement(String appPackage,
			String advertiser, int advertType, int userId, int offset, int pageSize)
			throws Exception {
		return advertisementDao.pageAdvertisement(appPackage, advertiser, advertType, userId, offset, pageSize);
	}

	@Override
	public long countAdvertisement(String appPackage, String advertiser,
			int advertType, int userId) throws Exception {
		return advertisementDao.countAdvertisement(appPackage, advertiser, advertType, userId);
	}

}
