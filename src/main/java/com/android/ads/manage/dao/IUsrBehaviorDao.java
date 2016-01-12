package com.android.ads.manage.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.android.ads.manage.model.UsrBehavior;

@Repository
public interface IUsrBehaviorDao {

	public List<UsrBehavior> queryUsrBehavior(UsrBehavior usrBehavior);
}
