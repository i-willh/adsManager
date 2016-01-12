package com.android.ads.manage.model;

import java.io.Serializable;
import java.util.Date;

public class UsrBehavior implements Serializable{

	private static final long serialVersionUID = 1548274151376294451L;
	
    //USR_BEHAVIOR_TYPE 5：用户行为	
    public static String USER_BEHAVIOR_TYPE_5="5";
    //USR_BEHAVIOR_SUBTYPE 200：邮箱有效性验证的验证码(24小时有效)
    public static String USER_BEHAVIOR_SUBTYPE_200="200";
    //入库初始状态
    public static long CHECK_EMAIL_FLAG_STATUS_0=0;
    public static long CHECK_EMAIL_FLAG_STATUS_1=1;

    
	private Long seqId;
	
	private Long usrOnlyid;
	
	private String behaviorType;
	
	private String behaviorSubType;
	
	private String behavior1;
	
	private String behavior2;
	
	private String behavior3;
	
	private Long flag;
	
	private Date createTime;
	
	private Date updateTime;

	public Long getSeqId() {
		return seqId;
	}

	public void setSeqId(Long seqId) {
		this.seqId = seqId;
	}

	public Long getUsrOnlyid() {
		return usrOnlyid;
	}

	public void setUsrOnlyid(Long usrOnlyid) {
		this.usrOnlyid = usrOnlyid;
	}

	public String getBehaviorType() {
		return behaviorType;
	}

	public void setBehaviorType(String behaviorType) {
		this.behaviorType = behaviorType;
	}

	public String getBehaviorSubType() {
		return behaviorSubType;
	}

	public void setBehaviorSubType(String behaviorSubType) {
		this.behaviorSubType = behaviorSubType;
	}

	public String getBehavior1() {
		return behavior1;
	}

	public void setBehavior1(String behavior1) {
		this.behavior1 = behavior1;
	}

	public String getBehavior2() {
		return behavior2;
	}

	public void setBehavior2(String behavior2) {
		this.behavior2 = behavior2;
	}

	public String getBehavior3() {
		return behavior3;
	}

	public void setBehavior3(String behavior3) {
		this.behavior3 = behavior3;
	}

	public Long getFlag() {
		return flag;
	}

	public void setFlag(Long flag) {
		this.flag = flag;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UsrBehavior [seqId=");
		builder.append(seqId);
		builder.append(", usrOnlyid=");
		builder.append(usrOnlyid);
		builder.append(", behaviorType=");
		builder.append(behaviorType);
		builder.append(", behaviorSubType=");
		builder.append(behaviorSubType);
		builder.append(", behavior1=");
		builder.append(behavior1);
		builder.append(", behavior2=");
		builder.append(behavior2);
		builder.append(", behavior3=");
		builder.append(behavior3);
		builder.append(", flag=");
		builder.append(flag);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append(", updateTime=");
		builder.append(updateTime);
		builder.append("]");
		return builder.toString();
	}
}
