package com.android.ads.manage.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.android.ads.manage.model.User;

@Repository
public interface IUserDao {

	public int saveUser(User user) throws Exception;
	
	public User getUserByEmail(@Param("email") String email) throws Exception;
}
