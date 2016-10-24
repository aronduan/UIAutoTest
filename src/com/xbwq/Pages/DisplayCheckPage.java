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
	
	
	@FindBy(name="��ӳ���") WebElement addDisplay;
	@FindBy(name="���з���") WebElement displayCost;
	@FindBy(name="�������") WebElement displayArea;
	@FindBy(name="��ע") WebElement note;
	@FindBy(id="com.xbcx.waiqing:id/ivPic") WebElement photoButton;
	
	
	public DisplayCheckPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addDisplay(){
		click(addDisplay, "�����ӳ��а�ť");
	}
	
	public void setDisplayCost(String cost){
		sendKeys(displayCost, "��д���з���", cost);
	}
	
	public void setDisplayArea(String area){
		sendKeys(displayArea, "��д�������", area);
	}
	
	public void setNote(String strNote){
		sendKeys(note, "��д��ע", strNote);
	}
	
	public void setPhoto(){
		log.info("��һ����ͨ��Ƭ");
		photoButton.click();
		takeCMPhoto();
		
		
//		log.info("��һ�ű�����Ƭ");
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
//		log.info("�������");
//		clickClickableElement(By.id("com.xbcx.waiqing:id/tvName"), 10, 1000, "���ȷ�������հ�ť");
//		takeCMPhoto();
	}
}
