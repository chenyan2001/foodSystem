package com.cy.pojo;

public class Collect {

	private int coID;//�ղ�ID
	private int uID;//�û�ID
	private int fID;//��ʳID
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
