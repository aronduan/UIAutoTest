package com.xbwq.TestCase;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.apache.commons.io.FileUtils;
import org.dom4j.DocumentException;
import org.openqa.selenium.OutputType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.xbwq.Config.AppiumServer;
import com.xbwq.Config.XMLParser;

public class BaseTest {
	
	public AndroidDriver driver;
	
	@BeforeSuite
	public void beforeSuite(){
		AppiumServer.startAppiumServer();
	}
	
	@AfterSuite
	public void afterSuite(){
		AppiumServer.stopAppiumServer();
	}
	
	@DataProvider
    public Object[][] providerMethod(Method method) throws DocumentException{
        
        List<Map<String, List<String>>> l = new XMLParser().getXMl();
        List<Map<String, String>> result = new ArrayList<Map<String, String>>();
        
        for(int i=0; i<l.size(); i++){
            Map m = (Map) l.get(i);
            if(m.containsKey(method.getName())){
                Map<String, String> finalMap = (Map) m.get(method.getName());
                result.add(finalMap);
            }
        }
        Object[][] arr = new Object[result.size()][];
        
        for(int i=0; i<result.size(); i++){
            arr[i] = new Object[]{result.get(i)};
        }
      return arr ;
     }
	
	
	public void takeScreenShot(String description){
		String currentDate, currentTime;
		String dirPath, picPath;
		
		//使用默认时区和语言环境获得一个日历  
		Calendar cale = Calendar.getInstance();  
		//将Calendar类型转换成Date类型  
		Date tasktime=cale.getTime();  
		//格式化
		currentDate = new SimpleDateFormat("yyyy-MM-dd").format(tasktime); 
		currentTime = new SimpleDateFormat("HHmmss").format(tasktime);
		
		dirPath = "D:\\screenshot\\"+currentDate;
		File file = new File(dirPath);
		
		if(!file.exists()){
			file.mkdir();
		}
		
		picPath = dirPath+"\\screen_"+currentTime+"_"+description+".png";
		
		File screen = driver.getScreenshotAs(OutputType.FILE);
		File screenFile = new File(picPath);
		try{
			FileUtils.copyFile(screen, screenFile);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
