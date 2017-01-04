package com.xbwq.Pages;

import io.appium.java_client.android.AndroidDriver;

public class ReturnGoodsReportPage extends BasePage{
	
	private AndroidDriver driver;

	public ReturnGoodsReportPage(AndroidDriver driver) throws Exception {
		super(driver,"退货上报页面");
		this.driver = driver;
	}
	
	public void addReturnGoods(){
		click("添加退货按钮");
	}
	
	public void setReturnGoodsReason(String reason){
		sendKeys("退货原因输入框", reason);
	}

	public void setNote(String note){
		sendKeys("备注输入框", note);
	}
}
