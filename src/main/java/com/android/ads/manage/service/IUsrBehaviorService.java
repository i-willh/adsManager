package com.android.ads.manage.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.android.ads.manage.model.UsrBehavior;


public interface IUsrBehaviorService {

	public List<UsrBehavior> queryUsrBehavior(UsrBehavior usrBehavior);
	
}
