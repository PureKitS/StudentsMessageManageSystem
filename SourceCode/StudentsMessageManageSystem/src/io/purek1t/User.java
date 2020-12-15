package io.purek1t;

import java.util.Date;

public class User {
	private int adminID;    		//管理员ID序号
	private String adminName;		//管理员姓名
	private String adminEmail;		//管理员邮箱
	private Date adminCreateDate;   //管理员创建时间
	private boolean adminAcvtive;   //管理员在籍状态
	private String userName;		//管理员登录用户名

	
	
	
	public int getAdminID() {
		return adminID;
	}
	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public Date getAdminCreateDate() {
		return adminCreateDate;
	}
	public void setAdminCreateDate(Date adminCreateDate) {
		this.adminCreateDate = adminCreateDate;
	}
	
	public boolean isAdminActive() {
		return adminAcvtive;
	}
	public void setAdminActive(boolean active) {
		this.adminAcvtive = active;
	}
	public void setAdminActive(int active) {
		this.adminAcvtive = active==1;
	}


}
