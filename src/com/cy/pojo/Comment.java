package com.cy.pojo;

import java.util.Date;
import java.util.List;

public class Comment {

	private int cmID;
	private int uID;
	private int fID;
	private String cmContent;
	private Date cmTime;
	
	public int getCmID() {
		return cmID;
	}
	public void setCmID(int cmID) {
		this.cmID = cmID;
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
	public String getCmContent() {
		return cmContent;
	}
	public void setCmContent(String cmContent) {
		this.cmContent = cmContent;
	}
	public Date getCmTime() {
		return cmTime;
	}
	public void setCmTime(Date cmTime) {
		this.cmTime = cmTime;
	}
	@Override
	public String toString() {
		return "Comment [cmID=" + cmID + ", uID=" + uID + ", fID=" + fID + ", cmContent=" + cmContent + ", cmTime="
				+ cmTime + "]";
	}
	
	
}
