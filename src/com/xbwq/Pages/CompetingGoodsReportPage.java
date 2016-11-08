package com.xbwq.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class CompetingGoodsReportPage extends BasePage{

	private AndroidDriver driver;
	
	@FindBy(name="添加竞品") WebElement addCompetingGoodsButton;
	@FindBy(name="竞品品牌") WebElement competingBrand;
	@FindBy(name="备注") WebElement note;
	@FindBy(id="com.xbcx.waiqing:id/ivPic") WebElement takePhoto;
	
	public CompetingGoodsReportPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addCompetingGoods(){
		click(addCompetingGoodsButton, "点击添加竞品按钮");
	}
	
	public void setCompetingBrand(String brandName){
		sendKeys(competingBrand, "填写竞品品牌", brandName);
	}
	
	public void setNote(String noteStr){
		sendKeys(note, "填写竞品上报备注", noteStr);
	}

	public void setPhoto() {
		click(takePhoto, "添加1张竞品上报照片");
		takeCMPhoto();
	}
}
