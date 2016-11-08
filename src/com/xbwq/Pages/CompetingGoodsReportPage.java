package com.xbwq.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class CompetingGoodsReportPage extends BasePage{

	private AndroidDriver driver;
	
	@FindBy(name="��Ӿ�Ʒ") WebElement addCompetingGoodsButton;
	@FindBy(name="��ƷƷ��") WebElement competingBrand;
	@FindBy(name="��ע") WebElement note;
	@FindBy(id="com.xbcx.waiqing:id/ivPic") WebElement takePhoto;
	
	public CompetingGoodsReportPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addCompetingGoods(){
		click(addCompetingGoodsButton, "�����Ӿ�Ʒ��ť");
	}
	
	public void setCompetingBrand(String brandName){
		sendKeys(competingBrand, "��д��ƷƷ��", brandName);
	}
	
	public void setNote(String noteStr){
		sendKeys(note, "��д��Ʒ�ϱ���ע", noteStr);
	}

	public void setPhoto() {
		click(takePhoto, "���1�ž�Ʒ�ϱ���Ƭ");
		takeCMPhoto();
	}
}
