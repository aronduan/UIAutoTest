package com.xbwq.Pages;

import io.appium.java_client.android.AndroidDriver;

public class SalesReportPage extends BasePage{
	
	private AndroidDriver driver;

	public SalesReportPage(AndroidDriver driver) throws Exception {
		super(driver,"销量上报页面");
		this.driver = driver;
	}
	
	public void addSales(){
		click("添加销量按钮");
	}
	
	public void setNote(String note){
		sendKeys("备注输入框", note);
	}
}
