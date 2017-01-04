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
	public void deleteCompetingGoodsReportCaoGao(){
		log.info("testcase:删除竞品上报草稿");
		page.swipeToLeft(500);
		page.clickModule("竞品上报");
		page.addCompetingGoods();
        driver.findElement(By.name("hehe")).click();
		page.saveAsCaogao();
		page.clickFirstData();
		page.deleteCaoGao();
		page.backToHomePage2();
	}
	

	@Test
	public void addCompetingGoodsReport(){
		log.info("testcase:新增竞品上报");
        page.swipeToLeft(500);
		page.clickModule("竞品上报");
		page.addCompetingGoods();
		page.setCustomer();
		page.setCompetingBrand("竞品品牌");
		page.setNote("这是备注");
		page.setPhoto();
		page.submit();
		page.waitForText(10, "老板");//临时代码，方便判断提交后回到列表界面
		page.takeScreenShot("新增竞品上报");

		page.clickFirstData();
		page.editTextClear(driver.findElementByName("竞品品牌"));
		page.setCompetingBrand("修改竞品品牌");
		page.backToHomePage2();
	}
}
