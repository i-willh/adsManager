package com.android.ads.manage.model;

import java.util.HashMap;
import java.util.Map;

public class AdvertType {
	public static Map<Integer, String> advertTypeMap = new HashMap<>();
	
	static {
		advertTypeMap.put(1, "插页式广告");
		advertTypeMap.put(2, "横幅广告");
		advertTypeMap.put(3, "视频广告");
	}
}
