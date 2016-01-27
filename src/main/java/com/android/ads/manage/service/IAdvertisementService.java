package com.android.ads.manage.service;

import java.util.List;

import com.android.ads.manage.model.Advertisement;

public interface IAdvertisementService {

	public int saveAdvertisement(Advertisement advertisement) throws Exception;
	
	public List<Advertisement> pageAdvertisement(String appPackage, String advertiser, int advertType, int userId, int offset, int pageSize) throws Exception;
	
	public long countAdvertisement(String appPackage, String advertiser, int advertType, int userId) throws Exception;
	
}
