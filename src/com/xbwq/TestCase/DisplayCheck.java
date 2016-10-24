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
		//如果启动app，就进行滑动操作，要休眠线程4秒
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
		log.info("testcase:删除陈列检查草稿");
		page.swipeToLeft(500);
		page.clickModule("陈列检查");
		page.addDisplay();
		page.saveAsCaogao();
		page.clickFirstData();
		page.deleteCaoGao();
		page.backToHomePage2();
	}
	
	@Test
	public void displayCheckCaoGao(){
		log.info("testcase:陈列检查草稿");
//		page.scrollToExact("陈列检查", "滑动到目标文案");
		page.swipeToLeft(500);
		page.clickModule("陈列检查");
		page.addDisplay();
		page.setCustomer();
		page.setDisplayCost("这是陈列费用");
		page.setDisplayArea("这是陈列面积");
		page.setNote("这是备注");
		page.setPhoto();
		page.saveAsCaogao();
		page.takeScreenShot("陈列检查草稿");
		page.backToHomePage2();
	}
	
	@Test
	public void addDisplayCheck(){
		log.info("testcase:新增陈列检查");
		page.clickModule("陈列检查");
		page.clickFirstData();
		page.editTextClear(driver.findElementByName("备注"));
		page.setNote("修改备注");
		page.submit();
		page.waitForText(10, "老板");//临时代码，方便判断提交后回到列表界面
		page.takeScreenShot("新增陈列检查");
		page.backToHomePage2();
	}
}
