package com.xbwq.Pages;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.seleniumhq.jetty7.util.log.Log;

import com.xbwq.Config.MyLogger;

import io.appium.java_client.android.AndroidDriver;

public class OrderReportPage extends BasePage{
	
	private AndroidDriver driver;
	private Logger log = MyLogger.log;
	
	
	@FindBy(name="��Ӷ���") WebElement addOrderButton;
	@FindBy(id="com.xbcx.waiqing:id/tvRight") WebElement orderRecordButton;
	@FindBy(name="��Ʒ") WebElement bangping;
	@FindBy(name="������ע") WebElement dingdanbeizhu;
	@FindBy(name="ɾ����Ʒ") WebElement deleteGoodsButton;

	public OrderReportPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickAddOrder(){
		click(addOrderButton, "�����Ӷ�����ť");
	}
	
	public void clickOrderRecord(){
		click(orderRecordButton, "�ӽ�����¼�µ�");
	}
	
	public void setBangPing(){
		sendKeys(bangping, "��д��Ʒ", "���ǰ�Ʒ");
	}
	
	public void setRemakes(){
		sendKeys(dingdanbeizhu, "��д��ע", "���Ƕ�����ע");
	}
	
	public void deleteGoods(){
		click(deleteGoodsButton, "ɾ����Ʒ");
		driver.findElementById("com.xbcx.waiqing:id/ivDelete").click();
		driver.findElementByName("��").click();
	}
}
