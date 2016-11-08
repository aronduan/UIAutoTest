package com.xbwq.TestCase;

import io.appium.java_client.android.AndroidKeyCode;

import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.xbwq.Config.Driver;
import com.xbwq.Config.MyLogger;

public class ManageReport extends BaseTest{
	
	Logger log = MyLogger.log;
	
	@BeforeClass
	public void beforeClass() throws MalformedURLException{
		driver = Driver.getDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("管理")).click();
	}
	
	@AfterClass
	public void afterClass(){
		driver.quit();
		Driver.driver = null;
	}
	
	@Test
	public void webViewTest() throws InterruptedException{
		Thread.sleep(3000);
		Set<String> contexts = driver.getContextHandles();
		for(String context : contexts){
			System.out.println(context);
//			if(context.contains("WEBVIEW")){
//				System.out.println("切换到WEBVIEW");
//				driver.context("WEBVIEW");
//			}
		}
		Thread.sleep(3000);
		System.out.println(driver.getContext());
		
		driver.findElement(By.xpath("//android.view.View[@index='1']/android.view.View[@index='1']")).click();
		driver.sendKeyEvent(AndroidKeyCode.BACK);
//		driver.findElement(By.name("查看轨迹分析 ")).click();
		driver.findElement(By.xpath("//android.view.View[contains(@content-desc,'查看轨迹分析')]")).click();
	}
	
}
