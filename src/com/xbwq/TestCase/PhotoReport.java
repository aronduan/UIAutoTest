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
		//如果启动app，就进行滑动操作，要休眠线程3秒
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
		log.info("testcase:拍照上传草稿");
		page.swipeToLeft(500);
		page.clickModule("拍照上传");
//		page.scrollToExact("拍照上传", "滑动");
		page.clickAddPhoto();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		page.setType("无");
		page.setCustomer();
		page.setShuoMing("草稿说明");
		page.setPhoto(5);
		page.saveAsCaogao();
		page.takeScreenShot("新增草稿");
		page.backToHomePage2();
	}
	
	
	@Test(dependsOnMethods={"photoReportCaoGao"})
	public void addPhotoReport(){
		log.info("testcase:添加拍照上传");
		page.clickModule("拍照上传");
		page.clickFirstData();
		page.setType("洽谈场所");
		page.editTextClear(driver.findElementByName("说明"));
//		page.clear(driver.findElementByName("说明"), "清除文本");
		page.setShuoMing("修改说明");
		page.submit();
		page.waitForText(10, "老板");//临时代码，方便判断提交后回到列表界面
		page.takeScreenShot("添加拍照上传");
		page.backToHomePage2();
		
	}

  }
	
	
	



	


