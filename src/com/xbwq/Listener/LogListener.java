package com.xbwq.Listener;
import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.xbwq.Config.MyLogger;

public class LogListener extends TestListenerAdapter {
	
	Logger log = MyLogger.log;
	
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
	public void onTestFailure(ITestResult tr) {

		log.info("Testcase '" + tr.getName() + "' FAILED");
//		log.info("Priority of this method is " + tr.getMethod().getPriority());
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		log.info("Testcase '" + tr.getName() + "' SKIPPED");
	}
}
