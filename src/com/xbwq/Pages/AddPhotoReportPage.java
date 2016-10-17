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
	
//	By type = By.name("类型");
	By takePhoto = By.id("com.xbcx.waiqing:id/ivPic");
//	By shuoming = By.name("说明");
//	By shaixuan = By.name("筛选");
//	
	
	@FindBy(name="类型") WebElement type;
	@FindBy(name="说明") WebElement shuoming;
	
	public AddPhotoReportPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setType(String typeName){
		basePage.click(type, "设置类型");
		driver.findElementByName(typeName).click();
	}
		
	public void setShuoMing(String string){
		basePage.sendKeys(shuoming, "填写说明", string);
	}
	
	public void setPhoto(){
		log.info("上传1张照片");
		driver.findElement(takePhoto).click();
		driver.findElementById("com.meizu.media.camera:id/shutter_btn").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("com.meizu.media.camera:id/btn_done").click();

	}
	
}
