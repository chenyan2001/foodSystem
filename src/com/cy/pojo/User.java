package com.cy.pojo;

public class User {

	private int uID;//�û�ID
	private String uNumber;//�û��˺�
	private String uPassword;//�û�����
	private String uName;//�û���
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
