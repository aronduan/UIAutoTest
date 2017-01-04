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
	public void addInventoryReport(){
		log.info("testcase: 添加库存上报");
		page.swipeToLeft(500);
		page.clickModule("库存上报");
		page.addInventory();
		page.setCustomer();
		
		page.addGoods("香奈儿", 2);
		log.info("删除库存上报商品");
		page.deleteGoods();
		
		page.addGoods("香奈儿", 2);
		page.setNote("这是备注");
		page.submit();
		page.waitForText(10, "老板");//临时代码，方便判断提交后回到列表界面
		page.takeScreenShot("新增库存上报");
		page.backToHomePage2();
	}
}
