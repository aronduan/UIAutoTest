package com.xbwq.TestCase;
import java.net.MalformedURLException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.dom4j.DocumentException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.xbwq.Config.Driver;
import com.xbwq.Config.MyLogger;
import com.xbwq.Config.XMLParser;
import com.xbwq.Listener.ScreenShotListener;
import com.xbwq.Pages.AddPhotoReportPage;


//@Listeners({ScreenShotListener.class})
public class PhotoReport extends BaseTest{
	
	AddPhotoReportPage page = null;
	Logger log = MyLogger.log;
	
	@BeforeClass
	public void beforeClass() throws MalformedURLException{
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
		page.clickAddPhoto();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		page.setType("��");
		page.setCustomer();
		page.setShuoMing("�ݸ�˵��");
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
		page.setShuoMing("�޸�˵��");
		page.submit();
		page.waitForText(10, "�ϰ�");//��ʱ���룬�����ж��ύ��ص��б����
		page.takeScreenShot("��������ϴ�");
		page.backToHomePage2();
		
	}

  }
	
	
	



	


