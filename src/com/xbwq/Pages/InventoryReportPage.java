package com.xbwq.Pages;

import io.appium.java_client.android.AndroidDriver;

public class InventoryReportPage extends BasePage{
	
	private AndroidDriver driver;

	public InventoryReportPage(AndroidDriver driver) throws Exception {
		super(driver,"库存上报页面");
		this.driver = driver;
	}

	public void addInventory(){
		click("添加库存按钮");
	}
	
	public void setNote(String note){
		sendKeys("备注输入框", note);
	}
}
