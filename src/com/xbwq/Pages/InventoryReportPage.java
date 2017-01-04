package com.xbwq.Pages;

import io.appium.java_client.android.AndroidDriver;

public class InventoryReportPage extends BasePage{
	
	private AndroidDriver driver;

	public InventoryReportPage(AndroidDriver driver) throws Exception {
		super(driver,"����ϱ�ҳ��");
		this.driver = driver;
	}

	public void addInventory(){
		click("��ӿ�水ť");
	}
	
	public void setNote(String note){
		sendKeys("��ע�����", note);
	}
}
