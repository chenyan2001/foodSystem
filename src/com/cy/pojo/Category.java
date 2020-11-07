package com.cy.pojo;

public class Category {

	private int cID;//类别ID
	private String cName;//类别名称
	public int getcID() {
		return cID;
	}
	public void setcID(int cID) {
		this.cID = cID;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	@Override
	public String toString() {
		return "Category [cID=" + cID + ", cName=" + cName + "]";
	}
	
}
