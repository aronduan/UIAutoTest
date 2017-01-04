package com.xbwq.Pages;

import java.util.List;
import java.util.Set;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
	
	private AndroidDriver driver;
	
	@FindBy(id="com.xbcx.waiqing:id/etCompany") WebElement company;
	@FindBy(id="com.xbcx.waiqing:id/etUser") WebElement username;
	@FindBy(id="com.xbcx.waiqing:id/etPwd") WebElement password;
	@FindBy(name="登录") WebElement loginButton;
	
	public LoginPage(AndroidDriver driver) throws Exception {
		super(driver,"");
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void login(String companyStr, String usernameStr, String passwordStr){
		if(isElementExist(By.name("进入小步外勤"), 3)){
			click(driver.findElement(By.name("进入小步外勤")), "点击引导页进入登录界面");
		}
		editTextClear(company);
		sendKeys(company, "输入公司名称", companyStr);
		editTextClear(username);
		sendKeys(username, "输入用户名", usernameStr);
		sendKeys(password, "输入密码", passwordStr);
		click(loginButton, "点击登录按钮");
		waitForText(10, "工作台");
		takeScreenShot("登录到首界面");
	}
	
	public void logout(){
		driver.findElement(By.name("我的")).click();
		List<WebElement> elements = driver.findElements(By.className("android.widget.ImageView"));
		elements.get(1).click();
		swipeToUp(500);
		driver.findElement(By.name("注销登录")).click();
		driver.findElement(By.name("确定")).click();
		if(isElementExist(By.id("com.xbcx.waiqing:id/viewLogo"), 10)){
			takeScreenShot("注销到登录界面");
		}
	}

}
