package com.xbwq.Pages;

import io.appium.java_client.android.AndroidDriver;

public class CompetingGoodsReportPage extends BasePage{

	private AndroidDriver driver;

	public CompetingGoodsReportPage(AndroidDriver driver) throws Exception {
		super(driver,"��Ʒ�ϱ�ҳ��");
		this.driver = driver;
	}
	
	public void addCompetingGoods(){
		click("��Ӿ�Ʒ��ť");
	}
	
	public void setCompetingBrand(String brandName){
		sendKeys("��ƷƷ�������", brandName);
	}
	
	public void setNote(String noteStr){
		sendKeys("��ע�����", noteStr);
	}

	public void setPhoto() {
		click("�����Ƭ");
		takeCMPhoto();
	}
}
