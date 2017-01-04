package com.xbwq.Pages;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class AdventGoodsPage extends BasePage{
	
	private AndroidDriver driver;
	
	public AdventGoodsPage(AndroidDriver driver) throws Exception {
		super(driver,"��������Ʒҳ��");
		this.driver = driver;
	}
	
	public void addAdvent(){
		click("������ڰ�ť");
	}
	
	public void setProductionDate(){
		click("��������");
		driver.findElement(By.name("ȷ��")).click();
	}
	
	public void setNote(String noteStr){
		sendKeys("��ע�����", noteStr);
	}
}
