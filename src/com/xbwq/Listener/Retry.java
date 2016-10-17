package com.xbwq.Listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.xbwq.Config.MyLogger;

public class Retry implements IRetryAnalyzer{
	
	private int retryCount = 0;
	private int maxRetryCount = 1;
	
	@Override
	public boolean retry(ITestResult result) {
		if(retryCount<maxRetryCount){
			MyLogger.log.info("retrying test " + result.getName() + " with status " + 
					getResultStatusName(result.getStatus()));
			retryCount++;
			return true;
		}
		return false;
	}
	
	public String getResultStatusName(int status){
		String resultName = null;
		if(status==1)
			resultName = "SUCCESS";
		if(status==2)
			resultName = "FAILURE";
		if(status==3)
			resultName = "SKIP";
		return resultName;
		
	}
}
