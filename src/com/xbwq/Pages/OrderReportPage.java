package com.xbwq.Pages;


import org.apache.log4j.Logger;
import com.xbwq.Config.MyLogger;
import io.appium.java_client.android.AndroidDriver;

public class OrderReportPage extends BasePage{
	
	private AndroidDriver driver;
	private Logger log = MyLogger.log;

	public OrderReportPage(AndroidDriver driver) throws Exception {
		super(driver,"�����ϱ�ҳ��");
		this.driver = driver;
	}
	
	public void clickAddOrder(){
		click("��Ӷ�����ť");
	}
	
	public void clickOrderRecord(){
		click("�ӽ�����¼�µ���ť");
	}
	
	public void setBangPing(){
		sendKeys("��Ʒ�����","���ǰ�Ʒ");
	}
	
	public void setRemakes(){
		sendKeys("������ע�����", "���Ƕ�����ע");
	}
	
	public void deleteGoods(){
		click("ɾ����Ʒ��ť");
		driver.findElementByName("��").click();
	}
}
