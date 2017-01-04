package com.xbwq.Pages;

import java.util.List;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;


//��ҳ��Ԫ��Ǩ��������⣬��page.xml�������
public class AddPhotoReportPage extends BasePage{
	
	private AndroidDriver driver;

	public AddPhotoReportPage(AndroidDriver driver) throws Exception {
		super(driver,"�����ϴ�ҳ��");
		this.driver = driver;
	}
	

	public void setType(String typeName){
		click("����");
		driver.findElementByName(typeName).click();
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
