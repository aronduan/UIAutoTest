package com.xbwq.TestCase;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.xbwq.Config.Driver;
import com.xbwq.Config.MyLogger;
import com.xbwq.Pages.InventoryReportPage;

public class InventoryReport extends BaseTest{
	
	private InventoryReportPage page = null;
	Logger log = MyLogger.log;
	
	@BeforeClass
	public void beforeClass() throws Exception {
		driver = Driver.getDriver();
		page = new InventoryReportPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//�������app���ͽ��л���������Ҫ�����߳�4��
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public void afterClass(){
		driver.quit();
		Driver.driver = null;
	}
	
	@Test
	public void addInventoryReport(){
		log.info("testcase: ��ӿ���ϱ�");
		page.swipeToLeft(500);
		page.clickModule("����ϱ�");
		page.addInventory();
		page.setCustomer();
		
		page.addGoods("���ζ�", 2);
		log.info("ɾ������ϱ���Ʒ");
		page.deleteGoods();
		
		page.addGoods("���ζ�", 2);
		page.setNote("���Ǳ�ע");
		page.submit();
		page.waitForText(10, "�ϰ�");//��ʱ���룬�����ж��ύ��ص��б����
		page.takeScreenShot("��������ϱ�");
		page.backToHomePage2();
	}
}
