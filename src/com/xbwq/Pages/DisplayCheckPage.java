package com.xbwq.Pages;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.xbwq.Config.MyLogger;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class DisplayCheckPage extends BasePage{
	
	private AndroidDriver driver;
	private Logger log = MyLogger.log;
	
	
	@FindBy(name="添加陈列") WebElement addDisplay;
	@FindBy(name="陈列费用") WebElement displayCost;
	@FindBy(name="陈列面积") WebElement displayArea;
	@FindBy(name="备注") WebElement note;
	@FindBy(id="com.xbcx.waiqing:id/ivPic") WebElement photoButton;
	
	
	public DisplayCheckPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addDisplay(){
		click(addDisplay, "点击添加陈列按钮");
	}
	
	public void setDisplayCost(String cost){
		sendKeys(displayCost, "填写陈列费用", cost);
	}
	
	public void setDisplayArea(String area){
		sendKeys(displayArea, "填写陈列面积", area);
	}
	
	public void setNote(String strNote){
		sendKeys(note, "填写备注", strNote);
	}
	
	public void setPhoto(){
		log.info("拍一张普通照片");
		photoButton.click();
		takeCMPhoto();
		
		
//		log.info("拍一张编码照片");
//		driver.findElementByXPath("//android.widget.ScrollView/android.widget.LinearLayout[1]"
//				+ "/android.widget.FrameLayout[7]/android.widget.LinearLayout[1]"
//				+ "/android.widget.LinearLayout[1]/android.widget.FrameLayout[3]").click();
//		driver.findElementByClassName("android.widget.EditText").sendKeys("11111");
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
//		TouchAction action = new TouchAction(driver).press(538, 1823);
//		driver.performTouchAction(action);
//		driver.tap(3, 538, 1823, 5);
//		log.info("点击坐标");
//		clickClickableElement(By.id("com.xbcx.waiqing:id/tvName"), 10, 1000, "点击确定并拍照按钮");
//		takeCMPhoto();
	}
}
