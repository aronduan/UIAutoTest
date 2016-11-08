package com.xbwq.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class ReturnGoodsReportPage extends BasePage{
	
	private AndroidDriver driver;
	
	@FindBy(name="添加退货") WebElement addReturnGoodsButton;
	@FindBy(name="退货原因") WebElement returnGoodsReason;
	@FindBy(name="备注") WebElement note;
	
	
	public ReturnGoodsReportPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addReturnGoods(){
		click(addReturnGoodsButton, "点击添加退货按钮");
	}
	
	public void setReturnGoodsReason(String reason){
		sendKeys(returnGoodsReason, "填写退货原因", reason);
	}

	public void setNote(String note){
		sendKeys(this.note, "填写退货上报备注", note);
	}
}
