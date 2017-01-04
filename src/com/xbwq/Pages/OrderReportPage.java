package com.xbwq.Pages;


import org.apache.log4j.Logger;
import com.xbwq.Config.MyLogger;
import io.appium.java_client.android.AndroidDriver;

public class OrderReportPage extends BasePage{
	
	private AndroidDriver driver;
	private Logger log = MyLogger.log;

	public OrderReportPage(AndroidDriver driver) throws Exception {
		super(driver,"订单上报页面");
		this.driver = driver;
	}
	
	public void clickAddOrder(){
		click("添加订单按钮");
	}
	
	public void clickOrderRecord(){
		click("从进货记录下单按钮");
	}
	
	public void setBangPing(){
		sendKeys("绑品输入框","这是绑品");
	}
	
	public void setRemakes(){
		sendKeys("订单备注输入框", "这是订单备注");
	}
	
	public void deleteGoods(){
		click("删除商品按钮");
		driver.findElementByName("是").click();
	}
}
