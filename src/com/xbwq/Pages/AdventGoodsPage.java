package com.xbwq.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class AdventGoodsPage extends BasePage{
	
	private AndroidDriver driver;
	
	@FindBy(name="添加临期") WebElement addAdventButton;
	@FindBy(name="生产日期") WebElement productionDate;
	@FindBy(name="备注") WebElement note;
	
	public AdventGoodsPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addAdvent(){
		click(addAdventButton, "点击添加临期");
	}
	
	public void setProductionDate(){
		click(productionDate, "点击生产日期");
		driver.findElement(By.name("确定")).click();
	}
	
	public void setNote(String noteStr){
		sendKeys(note, "填写临时商品备注", noteStr);
	}
}
