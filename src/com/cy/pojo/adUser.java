package com.cy.pojo;

public class adUser {

	private int adID;
	private String adNumber;
	private String adPassword;
	private String adName;
	public int getAdID() {
		return adID;
	}
	public void setAdID(int adID) {
		this.adID = adID;
	}
	public String getAdNumber() {
		return adNumber;
	}
	public void setAdNumber(String adNumber) {
		this.adNumber = adNumber;
	}
	public String getAdPassword() {
		return adPassword;
	}
	public void setAdPassword(String adPassword) {
		this.adPassword = adPassword;
	}
	public String getAdName() {
		return adName;
	}
	public void setAdName(String adName) {
		this.adName = adName;
	}
	@Override
	public String toString() {
		return "adUser [adID=" + adID + ", adNumber=" + adNumber + ", adPassword=" + adPassword + ", adName=" + adName
				+ "]";
	}
	
	
}
