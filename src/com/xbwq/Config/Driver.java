package com.xbwq.Config;

import java.net.MalformedURLException;
import java.net.URL;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Driver {
	public volatile static AndroidDriver driver = null;

	private Driver() {}

	public static AndroidDriver getDriver() throws MalformedURLException {

		if (driver == null) {
			synchronized (Driver.class) {
				if (driver == null) {
					DesiredCapabilities capabilities = new DesiredCapabilities();
					capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
					capabilities.setCapability("noReset", true);//不需要再次安装app
					capabilities.setCapability("platformName", "Android");
					capabilities.setCapability("platformVersion", "5.1.1");
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
