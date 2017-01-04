package com.xbwq.TestCase;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.xbwq.Config.Driver;
import com.xbwq.Config.MyLogger;
import com.xbwq.Pages.AdventGoodsPage;
import com.xbwq.Pages.CompetingGoodsReportPage;

public class CompetingGoodsReport extends BaseTest{
	
	CompetingGoodsReportPage page = null;
	Logger log = MyLogger.log;
	
	@BeforeClass
	public void beforeClass() throws Exception {
		driver = Driver.getDriver();
		page = new CompetingGoodsReportPage(driver);
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
	public void deleteCompetingGoodsReportCaoGao(){
		log.info("testcase:ɾ����Ʒ�ϱ��ݸ�");
		page.swipeToLeft(500);
		page.clickModule("��Ʒ�ϱ�");
		page.addCompetingGoods();
        driver.findElement(By.name("hehe")).click();
		page.saveAsCaogao();
		page.clickFirstData();
		page.deleteCaoGao();
		page.backToHomePage2();
	}
	

	@Test
	public void addCompetingGoodsReport(){
		log.info("testcase:������Ʒ�ϱ�");
        page.swipeToLeft(500);
		page.clickModule("��Ʒ�ϱ�");
		page.addCompetingGoods();
		page.setCustomer();
		page.setCompetingBrand("��ƷƷ��");
		page.setNote("���Ǳ�ע");
		page.setPhoto();
		page.submit();
		page.waitForText(10, "�ϰ�");//��ʱ���룬�����ж��ύ��ص��б����
		page.takeScreenShot("������Ʒ�ϱ�");

		page.clickFirstData();
		page.editTextClear(driver.findElementByName("��ƷƷ��"));
		page.setCompetingBrand("�޸ľ�ƷƷ��");
		page.backToHomePage2();
	}
}
