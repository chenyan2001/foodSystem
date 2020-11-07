package com.cy.pojo;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Food {

	private int fID;//��ʳID
	private String fName;//��ʳ����
	private String fIntroduction;//��ʳ���
	private String fMainIngredient;//��ʳ����
	private String fBurdening;//��ʳ����
	private String fStep;//��ʳ��Ҫ����
	private String fImage;//��ʳͼƬ
	private String fCategory;//��ʳ����
	private List<Category> fCategories;//��ʳ��
	private Date fTime;//�ϴ�ʱ��
	private String fCreateName;//��ʳ������
	private String fSign;//���
	private int fOnclick;//�������
	public int getfID() {
		return fID;
	}
	public void setfID(int fID) {
		this.fID = fID;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getfIntroduction() {
		return fIntroduction;
	}
	public void setfIntroduction(String fIntroduction) {
		this.fIntroduction = fIntroduction;
	}
	public String getfMainIngredient() {
		return fMainIngredient;
	}
	public void setfMainIngredient(String fMainIngredient) {
		this.fMainIngredient = fMainIngredient;
	}
	public String getfBurdening() {
		return fBurdening;
	}
	public void setfBurdening(String fBurdening) {
		this.fBurdening = fBurdening;
	}
	public String getfStep() {
		return fStep;
	}
	public void setfStep(String fStep) {
		this.fStep = fStep;
	}
	public String getfImage() {
		return fImage;
	}
	public void setfImage(String fImage) {
		this.fImage = fImage;
	}
	
	
	public String getfCategory() {
		return fCategory;
	}
	public void setfCategory(String fCategory) {
		this.fCategory = fCategory;
	}
	public List<Category> getfCategories() {
		return fCategories;
	}
	public void setfCategories(List<Category> fCategories) {
		this.fCategories = fCategories;
	}
	public Date getfTime() {
		return fTime;
	}
	public void setfTime(Date fTime) {
		this.fTime = fTime;
	}
	public String getfCreateName() {
		return fCreateName;
	}
	public void setfCreateName(String fCreateName) {
		this.fCreateName = fCreateName;
	}
	public String getfSign() {
		return fSign;
	}
	public void setfSign(String fSign) {
		this.fSign = fSign;
	}
	public int getfOnclick() {
		return fOnclick;
	}
	public void setfOnclick(int fOnclick) {
		this.fOnclick = fOnclick;
	}
	@Override
	public String toString() {
		return "Food [fID=" + fID + ", fName=" + fName + ", fIntroduction=" + fIntroduction + ", fMainIngredient="
				+ fMainIngredient + ", fBurdening=" + fBurdening + ", fStep=" + fStep + ", fImage=" + fImage
				+ ", fCategory=" + fCategory + ", fCategories=" + fCategories + ", fTime=" + fTime + ", fCreateName="
				+ fCreateName + ", fSign=" + fSign + ", fOnclick=" + fOnclick + "]";
	}
	
	
}
