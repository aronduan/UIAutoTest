package com.xbwq.TestCase;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xbwq.Config.Driver;
import com.xbwq.Config.MyLogger;
import com.xbwq.Pages.OrderReportPage;

public class OrderReport extends BaseTest{
	
	OrderReportPage page = null;
	Logger log = MyLogger.log;
	
	
	@BeforeClass
	public void beforeClass() throws MalformedURLException{
		driver = Driver.getDriver();
		page = new OrderReportPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void afterClass(){
		driver.quit();
		Driver.driver = null;
	}
	
	@Test
	public void addOrderReport(){
		log.info("testcase:添加订单");
		page.swipeToLeft(500);
		page.clickModule("订单上报");
		page.clickAddOrder();
		page.setCustomer();
		page.addGoods("香奈儿", 2);
		page.setBangPing();
		page.setRemakes();
		page.submit();
		page.waitForText(10, "订单上报");
		page.takeScreenShot("提交订单");
		page.backToHomePage2();
	}
	
	@Test(dependsOnMethods={"addOrderReport"})
	public void editOrder(){
		//修改订单
		page.clickModule("订单上报");
		log.info("testcase:修改订单");
		page.clickFirstData();
		page.clickXiugai();
		page.deleteGoods();
		page.addGoods("脑白金", 1);
		page.submit();
		page.waitForText(10, "订单上报");
		page.takeScreenShot("修改订单");
		page.backToHomePage();
	}
}
