package com.xbwq.Listener;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.xbwq.Pages.BasePage;
import com.xbwq.TestCase.BaseTest;

public class ScreenShotListener extends TestListenerAdapter{
	
	
	@Override
	public void onTestFailure(ITestResult tr){
		super.onTestFailure(tr);
		takeScreenShot(tr);
		
	}
	
	private void takeScreenShot(ITestResult tr){
		BaseTest bt = (BaseTest) tr.getInstance();
		bt.takeScreenShot("ÓÃÀıÊ§°Ü½ØÍ¼");
	}
	
}
