package com.xbwq.TestCase;

import java.net.MalformedURLException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.jasper.tagplugins.jstl.core.Param;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.xbwq.Config.Driver;
import com.xbwq.Config.MyLogger;
import com.xbwq.Pages.LoginPage;

public class Login extends BaseTest{
	
	LoginPage page = null;
	Logger log = MyLogger.log;
	
	@BeforeClass
	public void beforeClass() throws Exception {
		driver = Driver.getDriver();
		page = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void afterClass(){
		driver.quit();
		Driver.driver = null;
	}
	
	@Test(dataProvider="providerMethod")
	public void loginTest(Map<?, ?> param){
		page.login(param.get("company").toString(), param.get("username").toString(), param.get("password").toString());
		page.logout();
	}
	
	
//    @DataProvider(name="user")
//    public Object[][] Users(){
//        return new Object[][]{
//                {"zdhcs", "Aleader","aaaaaa"},
//        };
//    }
}
