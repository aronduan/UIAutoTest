package com.xbwq.Pages;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;
import com.xbwq.Config.MyLogger;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.NetworkConnectionSetting;
import io.appium.java_client.NoSuchContextException;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;

public class BasePage {
	
	private AndroidDriver driver;
	Logger log = MyLogger.log;
	
	By addButton = By.name("添加");
	By customer = By.name("客户");
	By caogao = By.name("存为草稿");
	By xiugaiButton = By.name("修改");
	By deleteButton = By.name("删除");
	
	
	@FindBy(name="提交") WebElement submitButton;
	@FindBy(name="添加商品") WebElement addGoogsButton;
	@FindBy(name="删除商品") WebElement deleteGoogsButton;

	public BasePage(AndroidDriver driver){
		this.driver = driver;
	}

	
	public void clickModule(String moduleName){
		long startTime = System.currentTimeMillis();
		setElementLocateTimeOut(5);
		while(!isElementExist(By.name(moduleName), 2)){
			swipeToUp(1500);
			if(System.currentTimeMillis()-startTime >= 20*1000){
				break;
			}
		}
		WebElement element = driver.findElement(By.name(moduleName));
		click(element, "点击"+"『"+moduleName+"』"+"模块");
		setElementLocateTimeOut(10);
	}
	
	
	public void addGoods(String name,int num){
		addGoogsButton.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.view.View/android.widget.RelativeLayout"
				+ "/android.widget.ImageView[3]").click();
		driver.findElement(By.id("com.xbcx.waiqing:id/etSearch")).sendKeys(name);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement element = driver.findElementById("com.xbcx.waiqing:id/viewForClick");
		click(element, "选择商品");
		driver.findElementById("com.xbcx.waiqing:id/btnOK").click();
		for(int i=0; i<num; i++){
			driver.findElementById("com.xbcx.waiqing:id/btnPlus").click();
			log.info("[添加"+num+"个商品]");
		}
	}
	
	public void deleteGoods(){
		deleteGoogsButton.click();
		driver.findElement(By.id("com.xbcx.waiqing:id/ivDelete")).click();
		driver.findElement(By.name("是")).click();;
	}

	public void clickAddButton(){
		driver.findElement(addButton).click();
	}
	
	public void setCustomer(){
		driver.findElement(customer).click();
		driver.findElementByName("客户列表").click();
		driver.findElementByXPath("//android.widget.ListView/android.widget.LinearLayout[1]").click();
	}
	
	public void saveAsCaogao(){
		driver.findElement(caogao).click();
		driver.findElementByName("确定").click();
	}
	
	public void takeCMPhoto(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElementById("com.android.camera2:id/shutter_button").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("com.android.camera2:id/done_button").click();
	}
	
	/**
	 * 点击提交按钮，会检查是否可点击
	 */
	public void submit(){
		clickClickableElement(submitButton, 5, 1000, "点击提交按钮");
	}
	
	public void clickXiugai(){
		driver.findElement(xiugaiButton).click();
	}
	
	public void deleteCaoGao(){
		driver.findElement(deleteButton).click();
		takeScreenShot("删除草稿");
		driver.findElement(By.name("确定")).click();
	}
	
	/*点击列表第一条数据*/
	public void clickFirstData(){
		driver.findElementByXPath("//android.widget.ListView/android.widget.RelativeLayout[1]").click();
	}
	
	
	
	/**
     * override original method
     * 模拟点击,在原生方法执行时添加日志。
	 * @param element
	 * @param logText  input log text
	 */
	public void click(final WebElement element, String logText){
		log.info("["+logText+"，" + "by " + element.toString().substring(element.toString().indexOf("->")));
		element.click();
	}
	
	/**
	 * 模拟清除,在原生方法执行时添加日志。
	 * @param element
	 * @param logText
	 */
	public void clear(final WebElement element, String logText){
		log.info("["+logText+"，"+"by "+element.toString().substring(element.toString().indexOf("->")));
		element.clear();
	}
	
	
    /**
     * override original method
     * 模拟输入,在原生方法执行时添加日志。
     * @param element       the element to be found.
     * @param logText       input log text.
     * @param charSequences sendKeys content, support for multiple strings.
     */
	public void sendKeys(final WebElement element, String logText, CharSequence...charSequences){
		log.info("["+logText+"，"+"by "+element.toString().substring(element.toString().indexOf("->")));
		element.sendKeys(charSequences);
	}
	
	
	public String getText(final WebElement element, String logText){
		log.info("["+logText+"，"+"by "+element.toString().substring(element.toString().indexOf("->")));
		return element.getText();
	}
	
	
	public String getAttribute(final WebElement element, String attribute, String logText){
		log.info("["+logText+"，"+"by "+element.toString().substring(element.toString().indexOf("->")));
		return element.getAttribute(attribute);
	}
	
	
    /**
     * override original method
     * 滚动到目标文本的位置,在原生方法执行时添加日志。
     * @param targetText the target text to be scrollToExact.
     * @param logText    input log text.
     */
	public void scrollToExact(String targetText, String logText){
		log.info("["+logText+"]"+"滑动屏幕至目标文字:" + targetText);
		driver.scrollToExact(targetText);
	}
	
	
    /**
     * 长按源元素移至目标元素后释放。
     *
     * @param elementA the source element.
     * @param elementB the target element.
     * @param logText  input log text.
     */
    public void swipe_elementA_TO_elementB(WebElement elementA, WebElement elementB, String logText) {
        log.info("[" + logText + "] ");
        new TouchAction(driver).longPress(elementA).moveTo(elementB).release().perform();
    }

    
    /**
     * 设置手机的网络连接状态,可以开关飞行模式、wifi、数据流量。
     *
     * @param airplaneMode airplaneMode switch.
     * @param wifi         wifi switch.
     * @param data         data switch.
     * @param logText      input log text.
     */
    public void setNetworkConnection(Boolean airplaneMode, Boolean wifi, Boolean data, String logText) {
        log.info("[" + logText + "] ");
        driver.setNetworkConnection(new NetworkConnectionSetting(airplaneMode, wifi, data));
    }
	
	
    public void setElementLocateTimeOut(int time){
    	driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }
    
    
	/**
	 * 在指定时间内等待，直到文本出现在页面上。
	 * @param timeoutInSecends  设置等待时间，单位：秒
	 * @param targetText	等待出现的文本，可多设置几个
	 * @return 				等到指定文本出现返回true，否则返回false
	 */
	public boolean waitForText(int timeoutInSecends, String...targetText){
		log.info("[Wait For Text : "+Arrays.toString(targetText) + "]");
		boolean flag = false;
		String pageSource = null;
		long startTime = System.currentTimeMillis();
		while(true){
			pageSource = driver.getPageSource();
			
			if(pageSource != null){
				for(int i=0; i<targetText.length; i++){
					flag = pageSource.contains(targetText[i]);
				}
			}
			
			if(System.currentTimeMillis() - startTime >= timeoutInSecends*1000 || flag){
				break;
			}
		}
		return flag;
	}
	
	
	public void backToHomePage(){
		int times = 0;
		while(!waitForText(3, "工作台")){
			if(times>=20){
				log.info("尝试多次未能返回至首页，终止操作");
				break;
			}
			driver.sendKeyEvent(AndroidKeyCode.BACK);
			if(isElementExist(By.id("com.xbcx.waiqing:id/btnOK"),2)){
				WebElement okButton = driver.findElement(By.id("com.xbcx.waiqing:id/btnOK"));
				okButton.click();
				driver.sendKeyEvent(AndroidKeyCode.BACK);
			}
			times++;
		}
		log.info("back to home page");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void backToHomePage2(){
		int times = 0;
		while(!waitForText(3, "外勤工作")){
			if(times>=20){
				log.info("尝试多次未能返回至首页，终止操作");
				break;
			}
			driver.sendKeyEvent(AndroidKeyCode.BACK);
			if(isElementExist(By.id("com.xbcx.waiqing:id/btnOK"),2)){
				WebElement okButton = driver.findElement(By.id("com.xbcx.waiqing:id/btnOK"));
				okButton.click();
				driver.sendKeyEvent(AndroidKeyCode.BACK);
			}
			times++;
		}
		log.info("back to home page2");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
    
    /**
     * wait for the element clickable in timeout setting
     * 在指定时间内等待，直到对象能够被点击。
     *
     * @param by               the element locator By
     * @param timeOutInSeconds The timeout in seconds when an expectation is called
     * @param sleepInMillis    The duration in milliseconds to sleep between polls.
     */
    public boolean waitForElementClickable(By by, long timeOutInSeconds, long sleepInMillis) {
    	
    	boolean clickable = false;
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds, sleepInMillis);
		clickable = (wait.until(ExpectedConditions.elementToBeClickable(by)) != null);
		return clickable;
    }
	
    public boolean waitForElementClickable(final WebElement element, long timeOutInSeconds, long sleepInMillis) {
    	
    	boolean clickable = false;
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds, sleepInMillis);
		clickable = (wait.until(ExpectedConditions.elementToBeClickable(element)) != null);//检查有没有返回可点击的element
		return clickable;
    }
    
    /**
     * 点击可点击的元素,在一定时间内，如果不能点击则报错
     * @param by
     * @param timeOutInSeconds
     * @param sleepInMillis
     * @param dec
     * @return boolean
     */
    public boolean clickClickableElement(By by, long timeOutInSeconds, long sleepInMillis, String...dec){
    	boolean clickable = false;
    	
    	try{
    		clickable = waitForElementClickable(by, timeOutInSeconds, sleepInMillis);
    		if(clickable){
    			if(dec == null){
    				driver.findElement(by).click();
    			}else{
    				click(driver.findElement(by), dec[0]);
    			}
    		}
    	}catch(Exception e){
    		log.error(e.getStackTrace());
    		e.printStackTrace();
    	}
    	return clickable;
    }
    
    /**
     * 点击可点击的元素,在一定时间内，如果不能点击则报错
     * @param element
     * @param timeOutInSeconds
     * @param sleepInMillis
     * @return boolean
     */
    public boolean clickClickableElement(WebElement element, long timeOutInSeconds, long sleepInMillis, String...logText){
    	boolean clickable = false;
    	
    	try{
    		clickable = waitForElementClickable(element, timeOutInSeconds, sleepInMillis);
    		if(clickable){
    			if(logText == null){
    				element.click();
    			}else{
    				click(element, logText[0]);
    			}
    		}
    	}catch(Exception e){
    		log.error(e.getStackTrace());
    		e.printStackTrace();
    	}
    	return clickable;
    }
    
    
    /**
     * 在指定时间内判断指定的对象是否存在
     * @param by
     * @param timeOut
     * @return boolean
     */
	public boolean isElementExist(By by, int timeOut) {
		setElementLocateTimeOut(timeOut);
//		long startTime = System.currentTimeMillis();

		try {
			driver.findElement(by);
			setElementLocateTimeOut(10);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			setElementLocateTimeOut(10);
			return false;
		}
		
	}
	
	
	/**
	 * 清除编辑框的文字
	 * @param element
	 */
	public void editTextClear(WebElement element){
		
		//keyevent 123 ；将光标移至末尾
		//keyevent 67  : KEYCODE_DEL 退格键
		String editText = element.getText();
		element.click();
		driver.sendKeyEvent(123);
		for (int i = 0; i < editText.length(); i++) {
			driver.sendKeyEvent(67);
		}
	}
	
	
	/**
	 * 截图保存在本地
	 * @param description 截图命名描述
	 */
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
		log.info("[手动截图]->"+"描述："+description);
	}

	
	/**
	 * 向上滑动屏幕
	 * @param during 滑动的过程的间隔时间，间隔时间越短滑动速度越快，一般用500（毫秒）
	 */
	
	public void swipeToUp(int during){
		int width = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		driver.swipe(width / 2, height * 3 / 4, width / 2, height / 4, during);
	}
	
	public void swipeToDown(int during){
		int width = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		driver.swipe(width/2, height/4, width, height* 3/4, during);
	}
	
	public void swipeToLeft(int during){
		int width = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		driver.swipe(width*3/4, height/2, width/4, height/2, during);
	}
	
	public void swipeToRight(int during){
		int width = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		driver.swipe(width/4, height/2, width*3/4, height/2, during);
	}
}
