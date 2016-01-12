package com.android.ads.manage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.android.ads.manage.dao.IUsrBehaviorDao;
import com.android.ads.manage.model.UsrBehavior;
import com.android.ads.manage.service.IUsrBehaviorService;

@Service
public class UsrBehaviorServiceImpl implements IUsrBehaviorService {
	@Resource
	private IUsrBehaviorDao usrBehaviorDao;

	@Override
	public List<UsrBehavior> queryUsrBehavior(UsrBehavior usrBehavior) {
		return usrBehaviorDao.queryUsrBehavior(usrBehavior);
	}
}
