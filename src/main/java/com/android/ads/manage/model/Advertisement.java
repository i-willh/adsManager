package com.android.ads.manage.model;

import java.util.Date;

public class Advertisement {

	private int id;
	private String appPackage;
	private String advertiser;
	private String advertKey;
	private int advertType;
	private String advertTypeName;
	private int advertStatus;
	private Date createTime;
	private int createUser;
	private Date updateTime;
	private int updateUser;
	private String description;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAppPackage() {
		return appPackage;
	}
	public void setAppPackage(String appPackage) {
		this.appPackage = appPackage;
	}
	public String getAdvertiser() {
		return advertiser;
	}
	public void setAdvertiser(String advertiser) {
		this.advertiser = advertiser;
	}
	public String getAdvertKey() {
		return advertKey;
	}
	public void setAdvertKey(String advertKey) {
		this.advertKey = advertKey;
	}
	public int getAdvertType() {
		return advertType;
	}
	public void setAdvertType(int advertType) {
		this.advertType = advertType;
	}
	public int getAdvertStatus() {
		return advertStatus;
	}
	public void setAdvertStatus(int advertStatus) {
		this.advertStatus = advertStatus;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getCreateUser() {
		return createUser;
	}
	public void setCreateUser(int createUser) {
		this.createUser = createUser;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public int getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(int updateUser) {
		this.updateUser = updateUser;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getAdvertTypeName() {
		return advertTypeName;
	}
	public void setAdvertTypeName(String advertTypeName) {
		this.advertTypeName = advertTypeName;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Advertisement [id=");
		builder.append(id);
		builder.append(", appPackage=");
		builder.append(appPackage);
		builder.append(", advertiser=");
		builder.append(advertiser);
		builder.append(", advertKey=");
		builder.append(advertKey);
		builder.append(", advertType=");
		builder.append(advertType);
		builder.append(", advertTypeName=");
		builder.append(advertTypeName);
		builder.append(", advertStatus=");
		builder.append(advertStatus);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append(", createUser=");
		builder.append(createUser);
		builder.append(", updateTime=");
		builder.append(updateTime);
		builder.append(", updateUser=");
		builder.append(updateUser);
		builder.append(", description=");
		builder.append(description);
		builder.append("]");
		return builder.toString();
	}
}
