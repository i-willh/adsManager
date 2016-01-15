package com.android.ads.manage.dao;

import org.springframework.stereotype.Repository;

import com.android.ads.manage.model.User;

@Repository
public interface IUserDao {

	public int saveUser(User user) throws Exception;
}
