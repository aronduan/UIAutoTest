package com.xbwq.Pages;

import java.util.List;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;


//将页面元素迁移至对象库，用page.xml管理对象
public class AddPhotoReportPage extends BasePage{
	
	private AndroidDriver driver;

	public AddPhotoReportPage(AndroidDriver driver) throws Exception {
		super(driver,"拍照上传页面");
		this.driver = driver;
	}
	

	public void setType(String typeName){
		click("类型");
		driver.findElementByName(typeName).click();
	}
		

	public void setPhoto(int num){
		log.info("[拍摄"+num+"张照片]");
		for(int i=0; i<num; i++){
			List<WebElement> elements = driver.findElementsById("com.xbcx.waiqing:id/ivPic");
			elements.get(i).click();
			takeCMPhoto();
		}
	}
	
}
