package com.xbwq.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class InventoryReportPage extends BasePage{
	
	private AndroidDriver driver;

	
	@FindBy(name="��ӿ��") WebElement addInventoryButton;
	@FindBy(name="��ע") WebElement noteButton;
	
	public InventoryReportPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addInventory(){
		click(addInventoryButton, "�����ӿ�水ť");
	}
	
	public void setNote(String note){
		sendKeys(noteButton, "��д����ϱ���ע", note);
	}
}
