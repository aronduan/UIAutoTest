package com.xbwq.Config;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Driver {
	public volatile static AndroidDriver driver = null;

	private Driver() {}

	public static AndroidDriver getDriver() throws MalformedURLException {
		
		if (driver == null) {
			synchronized (Driver.class) {
				if (driver == null) {
					DesiredCapabilities capabilities = new DesiredCapabilities();
					capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
					capabilities.setCapability("platformName", "Android");
					capabilities.setCapability("platformVersion", "4.3");
					capabilities.setCapability("deviceName", "android");
					capabilities.setCapability("appPackage", "com.xbcx.waiqing");
					capabilities.setCapability("appActivity","com.xbcx.waiqing.activity.StartActivity");
					// support Chinese
					capabilities.setCapability("unicodeKeyboard", "True");
					capabilities.setCapability("resetKeyboard", "True");
					driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				}
			}
		}
		return driver;
	}

}
