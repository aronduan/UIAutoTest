package com.xbwq.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class ReturnGoodsReportPage extends BasePage{
	
	private AndroidDriver driver;
	
	@FindBy(name="����˻�") WebElement addReturnGoodsButton;
	@FindBy(name="�˻�ԭ��") WebElement returnGoodsReason;
	@FindBy(name="��ע") WebElement note;
	
	
	public ReturnGoodsReportPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addReturnGoods(){
		click(addReturnGoodsButton, "�������˻���ť");
	}
	
	public void setReturnGoodsReason(String reason){
		sendKeys(returnGoodsReason, "��д�˻�ԭ��", reason);
	}

	public void setNote(String note){
		sendKeys(this.note, "��д�˻��ϱ���ע", note);
	}
}
