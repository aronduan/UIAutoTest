package com.xbwq.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class AdventGoodsPage extends BasePage{
	
	private AndroidDriver driver;
	
	@FindBy(name="�������") WebElement addAdventButton;
	@FindBy(name="��������") WebElement productionDate;
	@FindBy(name="��ע") WebElement note;
	
	public AdventGoodsPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addAdvent(){
		click(addAdventButton, "����������");
	}
	
	public void setProductionDate(){
		click(productionDate, "�����������");
		driver.findElement(By.name("ȷ��")).click();
	}
	
	public void setNote(String noteStr){
		sendKeys(note, "��д��ʱ��Ʒ��ע", noteStr);
	}
}
