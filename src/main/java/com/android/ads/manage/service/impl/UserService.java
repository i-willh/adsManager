package com.android.ads.manage.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.android.ads.manage.dao.IUserDao;
import com.android.ads.manage.model.User;
import com.android.ads.manage.service.IUserService;

@Service
public class UserService implements IUserService {
	
	@Resource
	private IUserDao userDao;

	@Override
	public int saveUser(User user) throws Exception {
		return userDao.saveUser(user);
	}
	
	public User getUserByEmail(String email) throws Exception {
		return userDao.getUserByEmail(email);
	}

}
