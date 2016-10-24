package com.xbwq.TestCase;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.xbwq.Config.Driver;
import com.xbwq.Config.MyLogger;
import com.xbwq.Pages.DisplayCheckPage;

public class DisplayCheck extends BaseTest{
	
	DisplayCheckPage page = null;
	Logger log = MyLogger.log;
	
	@BeforeClass
	public void beforeClass() throws MalformedURLException{
		driver = Driver.getDriver();
		page = new DisplayCheckPage(driver);
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
	public void deleteDisplayCheckCaoGao(){
		log.info("testcase:ɾ�����м��ݸ�");
		page.swipeToLeft(500);
		page.clickModule("���м��");
		page.addDisplay();
		page.saveAsCaogao();
		page.clickFirstData();
		page.deleteCaoGao();
		page.backToHomePage2();
	}
	
	@Test
	public void displayCheckCaoGao(){
		log.info("testcase:���м��ݸ�");
//		page.scrollToExact("���м��", "������Ŀ���İ�");
		page.swipeToLeft(500);
		page.clickModule("���м��");
		page.addDisplay();
		page.setCustomer();
		page.setDisplayCost("���ǳ��з���");
		page.setDisplayArea("���ǳ������");
		page.setNote("���Ǳ�ע");
		page.setPhoto();
		page.saveAsCaogao();
		page.takeScreenShot("���м��ݸ�");
		page.backToHomePage2();
	}
	
	@Test
	public void addDisplayCheck(){
		log.info("testcase:�������м��");
		page.clickModule("���м��");
		page.clickFirstData();
		page.editTextClear(driver.findElementByName("��ע"));
		page.setNote("�޸ı�ע");
		page.submit();
		page.waitForText(10, "�ϰ�");//��ʱ���룬�����ж��ύ��ص��б����
		page.takeScreenShot("�������м��");
		page.backToHomePage2();
	}
}
