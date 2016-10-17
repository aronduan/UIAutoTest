package com.xbwq.Pages;

import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPhotoReportPage extends BasePage{
	
	private AndroidDriver driver;
	BasePage basePage = new BasePage(driver);
	
//	By type = By.name("����");
	By takePhoto = By.id("com.xbcx.waiqing:id/ivPic");
//	By shuoming = By.name("˵��");
//	By shaixuan = By.name("ɸѡ");
//	
	
	@FindBy(name="����") WebElement type;
	@FindBy(name="˵��") WebElement shuoming;
	
	public AddPhotoReportPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setType(String typeName){
		basePage.click(type, "��������");
		driver.findElementByName(typeName).click();
	}
		
	public void setShuoMing(String string){
		basePage.sendKeys(shuoming, "��д˵��", string);
	}
	
	public void setPhoto(){
		log.info("�ϴ�1����Ƭ");
		driver.findElement(takePhoto).click();
		driver.findElementById("com.meizu.media.camera:id/shutter_btn").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("com.meizu.media.camera:id/btn_done").click();

	}
	
}
