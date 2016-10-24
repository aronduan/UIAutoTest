package com.xbwq.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class InventoryReportPage extends BasePage{
	
	private AndroidDriver driver;

	
	@FindBy(name="添加库存") WebElement addInventoryButton;
	@FindBy(name="备注") WebElement noteButton;
	
	public InventoryReportPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addInventory(){
		click(addInventoryButton, "点击添加库存按钮");
	}
	
	public void setNote(String note){
		sendKeys(noteButton, "填写库存上报备注", note);
	}
}
