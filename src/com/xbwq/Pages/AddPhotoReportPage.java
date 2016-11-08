package com.xbwq.Pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPhotoReportPage extends BasePage{
	
	private AndroidDriver driver;
	
//	By type = By.name("����");
	By addButton = By.name("�������");
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
	
	public void clickAddPhoto(){
		driver.findElement(addButton).click();
	}
	
	public void setType(String typeName){
		click(type, "��������");
		driver.findElementByName(typeName).click();
	}
		
	public void setShuoMing(String string){
		sendKeys(shuoming, "��д˵��", string);
	}
	
	public void setPhoto(int num){
		log.info("[����"+num+"����Ƭ]");
		for(int i=0; i<num; i++){
			List<WebElement> elements = driver.findElementsById("com.xbcx.waiqing:id/ivPic");
			elements.get(i).click();
			takeCMPhoto();
		}
	}
	
}
