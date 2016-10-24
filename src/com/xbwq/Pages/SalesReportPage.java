package com.xbwq.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;

public class SalesReportPage extends BasePage{
	
	private AndroidDriver driver;
	
	
	@FindBy(name="添加销量") WebElement addSalesButton;
	@FindBy(name="备注") WebElement noteButton;
	
	public SalesReportPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addSales(){
		click(addSalesButton, "点击添加销量按钮");
	}
	
	public void setNote(String note){
		sendKeys(noteButton, "填写销量上报备注", note);
	}
}
