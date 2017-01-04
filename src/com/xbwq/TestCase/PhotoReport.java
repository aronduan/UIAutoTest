package com.xbwq.TestCase;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.xbwq.Config.Driver;
import com.xbwq.Config.MyLogger;
import com.xbwq.Pages.AddPhotoReportPage;


//@Listeners({TestNGListener.class})
public class PhotoReport extends BaseTest{
	
	AddPhotoReportPage page = null;
	Logger log = MyLogger.log;
	
	@BeforeClass
	public void beforeClass() throws Exception {
		driver = Driver.getDriver();
		page = new AddPhotoReportPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//�������app���ͽ��л���������Ҫ�����߳�3��
		try {
			Thread.sleep(3000);
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
	public void photoReportCaoGao(){
		log.info("testcase:�����ϴ��ݸ�");
		page.swipeToLeft(500);
		page.clickModule("�����ϴ�");
//		page.scrollToExact("�����ϴ�", "����");
        page.click("������հ�ť");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		page.setType("��");
		page.setCustomer();
		page.sendKeys("˵�������","�ݸ�˵��");
		page.setPhoto(5);
		page.saveAsCaogao();
		page.takeScreenShot("�����ݸ�");
		page.backToHomePage2();
	}
	
	
	@Test(dependsOnMethods={"photoReportCaoGao"})
	public void addPhotoReport(){
		log.info("testcase:��������ϴ�");
		page.clickModule("�����ϴ�");
		page.clickFirstData();
		page.setType("Ǣ̸����");
		page.editTextClear(driver.findElementByName("˵��"));
//		page.clear(driver.findElementByName("˵��"), "����ı�");
		page.sendKeys("˵�������","�޸�˵��");
		page.submit();
		page.waitForText(10, "�ϰ�");//��ʱ���룬�����ж��ύ��ص��б����
		page.takeScreenShot("��������ϴ�");
		page.backToHomePage2();

	}

  }
	
	
	



	


