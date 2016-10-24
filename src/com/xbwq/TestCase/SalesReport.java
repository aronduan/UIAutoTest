package com.xbwq.TestCase;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.xbwq.Config.Driver;
import com.xbwq.Config.MyLogger;
import com.xbwq.Pages.SalesReportPage;

public class SalesReport extends BaseTest{
	
	SalesReportPage page = null;
	Logger log = MyLogger.log;
	
	@BeforeClass
	public void beforeClass() throws MalformedURLException{
		driver = Driver.getDriver();
		page = new SalesReportPage(driver);
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
	public void addSalesReport(){
		log.info("testcase: 添加销量上报");
		page.swipeToLeft(500);
		page.clickModule("销量上报");
		page.addSales();
		page.setCustomer();
		
		page.addGoods("香奈儿", 2);
		log.info("删除销量上报商品");
		page.deleteGoods();
		
		page.addGoods("香奈儿", 2);//香奈儿单价 ￥120
		if(!page.waitForText(3, "240.00")){
			try {
				throw new Exception("销量金额与实际不符");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		page.setNote("这是备注");
		page.submit();
		page.waitForText(10, "老板");//临时代码，方便判断提交后回到列表界面
		page.takeScreenShot("新增销量上报");
		page.backToHomePage2();
	}
}
