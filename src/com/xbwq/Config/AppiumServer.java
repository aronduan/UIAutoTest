package com.xbwq.Config;

import java.io.IOException;
import java.net.Socket;

import org.apache.log4j.Logger;

public class AppiumServer{
	
	static Logger log = MyLogger.log;
	
	public static boolean isPortUsing(String host,int port){
		boolean flag = false;
		try {
			Socket socket = new Socket(host,port);
			log.info(host+":"+port+" port is on using");
			flag = true;
		} catch (IOException e) {
			log.info(host+":"+port+" port is not used");
		}
		return flag;
	}
	
	public static void stopAppiumServer(){
		String cmd = "taskkill /f /im node.exe";
		
		try {
			Runtime.getRuntime().exec(cmd);
			Runtime.getRuntime().exec("taskkill /f /im cmd.exe ");
			log.info("appium server is killed");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void startAppiumServer() {

		if (isPortUsing("127.0.0.1", 4723)) {
			stopAppiumServer();
		}

		new Thread(new Runnable() {

			@Override
			public void run() {
				String cmd = "cmd /c start appium";
				try {
					Runtime.getRuntime().exec(cmd);
					log.info("try to start appium server...");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();

		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
