package com.xbwq.TestCase;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.xbwq.Config.Driver;
import com.xbwq.Config.MyLogger;
import com.xbwq.Pages.ReturnGoodsReportPage;
import com.xbwq.Pages.SalesReportPage;

public class ReturnGoodsReport extends BaseTest{
	
	ReturnGoodsReportPage page = null;
	Logger log = MyLogger.log;
	
	@BeforeClass
	public void beforeClass() throws Exception {
		driver = Driver.getDriver();
		page = new ReturnGoodsReportPage(driver);
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
	public void addReturnGoodsReport(){
		log.info("testcase: 添加退货上报");
		page.swipeToLeft(500);
		page.clickModule("退货上报");
		page.addReturnGoods();
		page.setCustomer();
		
		page.addGoods("香奈儿", 2);
		page.deleteGoods();
		
		page.addGoods("香奈儿", 2);
		page.setReturnGoodsReason("这是退货原因");
		page.setNote("这是备注");
		
		page.submit();
		page.waitForText(10, "老板");
		page.takeScreenShot("添加退货上报");
		page.backToHomePage2();
	}
}
