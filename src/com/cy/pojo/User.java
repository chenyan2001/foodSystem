package com.cy.pojo;

public class User {

	private int uID;//用户ID
	private String uNumber;//用户账号
	private String uPassword;//用户密码
	private String uName;//用户名
	public int getuID() {
		return uID;
	}
	public void setuID(int uID) {
		this.uID = uID;
	}
	public String getuNumber() {
		return uNumber;
	}
	public void setuNumber(String uNumber) {
		this.uNumber = uNumber;
	}
	public String getuPassword() {
		return uPassword;
	}
	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	@Override
	public String toString() {
		return "User [uID=" + uID + ", uNumber=" + uNumber + ", uPassword=" + uPassword + ", uName=" + uName + "]";
	}
	
	
}
