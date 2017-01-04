package com.xbwq.Pages;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class AdventGoodsPage extends BasePage{
	
	private AndroidDriver driver;
	
	public AdventGoodsPage(AndroidDriver driver) throws Exception {
		super(driver,"大日期商品页面");
		this.driver = driver;
	}
	
	public void addAdvent(){
		click("添加临期按钮");
	}
	
	public void setProductionDate(){
		click("生产日期");
		driver.findElement(By.name("确定")).click();
	}
	
	public void setNote(String noteStr){
		sendKeys("备注输入框", noteStr);
	}
}
