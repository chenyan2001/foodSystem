package com.cy.pojo;

public class Collect {

	private int coID;//收藏ID
	private int uID;//用户ID
	private int fID;//美食ID
	public int getCoID() {
		return coID;
	}
	public void setCoID(int coID) {
		this.coID = coID;
	}
	public int getuID() {
		return uID;
	}
	public void setuID(int uID) {
		this.uID = uID;
	}
	public int getfID() {
		return fID;
	}
	public void setfID(int fID) {
		this.fID = fID;
	}
	@Override
	public String toString() {
		return "Collect [coID=" + coID + ", uID=" + uID + ", fID=" + fID + "]";
	}
	
}
