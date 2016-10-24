package com.xbwq.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;

public class SalesReportPage extends BasePage{
	
	private AndroidDriver driver;
	
	
	@FindBy(name="�������") WebElement addSalesButton;
	@FindBy(name="��ע") WebElement noteButton;
	
	public SalesReportPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addSales(){
		click(addSalesButton, "������������ť");
	}
	
	public void setNote(String note){
		sendKeys(noteButton, "��д�����ϱ���ע", note);
	}
}
