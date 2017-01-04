package com.xbwq.Listener;

import com.xbwq.Config.MyLogger;
import org.apache.log4j.Logger;
import org.testng.*;

import com.xbwq.Pages.BasePage;
import com.xbwq.TestCase.BaseTest;
import org.testng.annotations.Test;

import java.util.Iterator;

import static com.xbwq.Config.Driver.driver;

public class TestNGListener extends TestListenerAdapter{

    private Logger log = MyLogger.log;

    @Override
    public void onTestStart(ITestResult tr){
        log.info("----------------------------------------");
        log.info("Test Started....");
    }

    @Override
    public void onTestSuccess(ITestResult tr) {

        // This will print the class name in which the method is present
        log.info(tr.getTestClass());

        log.info("Testcase '" + tr.getName() + "' PASSED");

        // This will print the priority of the method.
        // If the priority is not defined it will print the default priority as
        // 该方法的优先级为多少
//		log.info("Priority of this method is " + tr.getMethod().getPriority());

    }

	@Override
	public void onTestFailure(ITestResult tr){
		super.onTestFailure(tr);
        log.info("Testcase '" + tr.getName() + "' FAILED");
		takeScreenShot(tr);

        //用例失败时返回homePage,以免下次重跑或下一条用例失败
        try {
            new BasePage(driver).backToHomePage2();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	private void takeScreenShot(ITestResult tr){
		BaseTest bt = (BaseTest) tr.getInstance();
		bt.takeScreenShot("用例失败截图");
	}

    @Override
    public void onTestSkipped(ITestResult tr) {
        log.info("Testcase '" + tr.getName() + "' SKIPPED");
    }

    @Override
    public void onFinish(ITestContext testContext) {
        super.onFinish(testContext);
        log.info("TestSuite Finish");
    }

    @Override
    public void onStart(ITestContext testContext) {
        log.info("TestSuite Start");
    }
}
