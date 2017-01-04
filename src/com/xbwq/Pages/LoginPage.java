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
	@FindBy(name="��¼") WebElement loginButton;
	
	public LoginPage(AndroidDriver driver) throws Exception {
		super(driver,"");
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void login(String companyStr, String usernameStr, String passwordStr){
		if(isElementExist(By.name("����С������"), 3)){
			click(driver.findElement(By.name("����С������")), "�������ҳ�����¼����");
		}
		editTextClear(company);
		sendKeys(company, "���빫˾����", companyStr);
		editTextClear(username);
		sendKeys(username, "�����û���", usernameStr);
		sendKeys(password, "��������", passwordStr);
		click(loginButton, "�����¼��ť");
		waitForText(10, "����̨");
		takeScreenShot("��¼���׽���");
	}
	
	public void logout(){
		driver.findElement(By.name("�ҵ�")).click();
		List<WebElement> elements = driver.findElements(By.className("android.widget.ImageView"));
		elements.get(1).click();
		swipeToUp(500);
		driver.findElement(By.name("ע����¼")).click();
		driver.findElement(By.name("ȷ��")).click();
		if(isElementExist(By.id("com.xbcx.waiqing:id/viewLogo"), 10)){
			takeScreenShot("ע������¼����");
		}
	}

}
