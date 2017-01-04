package com.xbwq.TestCase;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.xbwq.Config.Driver;
import com.xbwq.Config.MyLogger;
import com.xbwq.Pages.AdventGoodsPage;

public class AdventGoods extends BaseTest{
	
	AdventGoodsPage page = null;
	Logger log = MyLogger.log;
	
	@BeforeClass
	public void beforeClass() throws Exception {
		driver = Driver.getDriver();
		page = new AdventGoodsPage(driver);
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
	public void addAdventReport(){
		log.info("testcase: ���������Ʒ");
		page.swipeToLeft(500);
		page.clickModule("��������Ʒ");
		page.addAdvent();
		page.setCustomer();
		
		page.addGoods("���ζ�", 2);
		page.deleteGoods();
		
		page.addGoods("���ζ�", 2);
		page.setProductionDate();
		page.setNote("���Ǳ�ע");
		
		page.submit();
		page.waitForText(10, "�ϰ�");
		page.takeScreenShot("���������Ʒ");
		page.backToHomePage2();
	}
	
	
	
}
