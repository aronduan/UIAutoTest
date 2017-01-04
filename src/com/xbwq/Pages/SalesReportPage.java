package com.xbwq.Pages;

import io.appium.java_client.android.AndroidDriver;

public class SalesReportPage extends BasePage{
	
	private AndroidDriver driver;

	public SalesReportPage(AndroidDriver driver) throws Exception {
		super(driver,"�����ϱ�ҳ��");
		this.driver = driver;
	}
	
	public void addSales(){
		click("���������ť");
	}
	
	public void setNote(String note){
		sendKeys("��ע�����", note);
	}
}
