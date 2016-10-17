package com.xbwq.TestCase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TesNGExample {

	@BeforeTest
	public void openDBConnection(){
		System.out.println("BeforeTest");
	}

	@AfterTest
	public void CloseDBConnection(){
		System.out.println("AfterTest");
	}
	
	@BeforeClass
	public void beforeClass(){
		System.out.println("BeforeClass");
	}
	
	@AfterClass
	public void afterClass(){
		System.out.println("afterClass");
	}
	
	@Test
	public void testCase01(){
		System.out.println("testcase1");
	}
	
	@Test
	public void testCase02(){
		System.out.println("testcase2");
	}
	
	@Test
	public void testCase03(){
		System.out.println("testcase3");
	}
	
	@BeforeMethod
	public void openBrowser(){
		System.out.println("BeforeMethod");
	}
	
	@AfterMethod
	public void CloseBrowser(){
		System.out.println("BeforeMethod");
	}
}