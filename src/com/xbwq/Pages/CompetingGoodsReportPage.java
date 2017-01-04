package com.xbwq.Pages;

import io.appium.java_client.android.AndroidDriver;

public class CompetingGoodsReportPage extends BasePage{

	private AndroidDriver driver;

	public CompetingGoodsReportPage(AndroidDriver driver) throws Exception {
		super(driver,"竞品上报页面");
		this.driver = driver;
	}
	
	public void addCompetingGoods(){
		click("添加竞品按钮");
	}
	
	public void setCompetingBrand(String brandName){
		sendKeys("竞品品牌输入框", brandName);
	}
	
	public void setNote(String noteStr){
		sendKeys("备注输入框", noteStr);
	}

	public void setPhoto() {
		click("添加照片");
		takeCMPhoto();
	}
}
