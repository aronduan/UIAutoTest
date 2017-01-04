package com.xbwq.Pages;

import io.appium.java_client.android.AndroidDriver;

public class ReturnGoodsReportPage extends BasePage{
	
	private AndroidDriver driver;

	public ReturnGoodsReportPage(AndroidDriver driver) throws Exception {
		super(driver,"�˻��ϱ�ҳ��");
		this.driver = driver;
	}
	
	public void addReturnGoods(){
		click("����˻���ť");
	}
	
	public void setReturnGoodsReason(String reason){
		sendKeys("�˻�ԭ�������", reason);
	}

	public void setNote(String note){
		sendKeys("��ע�����", note);
	}
}
