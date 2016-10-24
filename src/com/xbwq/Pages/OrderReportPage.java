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
	
	
	@FindBy(name="添加订单") WebElement addOrderButton;
	@FindBy(id="com.xbcx.waiqing:id/tvRight") WebElement orderRecordButton;
	@FindBy(name="绑品") WebElement bangping;
	@FindBy(name="订单备注") WebElement dingdanbeizhu;
	@FindBy(name="删除商品") WebElement deleteGoodsButton;

	public OrderReportPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickAddOrder(){
		click(addOrderButton, "点击添加订单按钮");
	}
	
	public void clickOrderRecord(){
		click(orderRecordButton, "从进货记录下单");
	}
	
	public void setBangPing(){
		sendKeys(bangping, "填写绑品", "这是绑品");
	}
	
	public void setRemakes(){
		sendKeys(dingdanbeizhu, "填写备注", "这是订单备注");
	}
	
	public void deleteGoods(){
		click(deleteGoodsButton, "删除商品");
		driver.findElementById("com.xbcx.waiqing:id/ivDelete").click();
		driver.findElementByName("是").click();
	}
}
