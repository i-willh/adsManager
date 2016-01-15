package com.android.ads.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.android.ads.manage.model.Advertisement;

@Repository
public interface IAdvertisementDao {
	
	public int saveAdvertisement(Advertisement advertisement) throws Exception;

	public List<Advertisement> pageAdvertisement(@Param("appPackage") String appPackage, @Param("advertiser") String advertiser, @Param("advertType") int advertType, @Param("offset") int offset, @Param("pageSize") int pageSize) throws Exception;
	
	public long countAdvertisement(@Param("appPackage") String appPackage, @Param("advertiser") String advertiser, @Param("advertType") int advertType) throws Exception;
}
