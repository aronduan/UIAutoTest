//package com.xbwq.Config;
//
//import java.net.URL;
//import io.appium.java_client.service.local.AppiumDriverLocalService;
//import io.appium.java_client.service.local.AppiumServiceBuilder;
//
//public class AppiumServerUtils {
//    public static AppiumDriverLocalService service;
//    public static AppiumServerUtils appiumServerUtils = null;
//
//    private AppiumServerUtils() {}
//
//    public static AppiumServerUtils getInstance() {
//        if (appiumServerUtils == null) {
//            synchronized (AppiumServerUtils.class) {
//                if (appiumServerUtils == null) {
//                    appiumServerUtils = new AppiumServerUtils();
//                }
//            }
//        }
//        return appiumServerUtils;
//    }
//
//
//    public URL startAppiumServerByDefault() {
//        service = AppiumDriverLocalService.buildDefaultService();
//        service.start();
//        if (service == null || !service.isRunning()) {
//            throw new RuntimeException("An appium server node is note started!");
//        }
//        return service.getUrl();
//    }
//
//
//    public void stopServer() {
//        if (service != null) {
//            service.stop();
//        }
//    }
//
//    public URL startServer(String ipAddress, int port) {
//        AppiumServiceBuilder builder = new AppiumServiceBuilder();
//        builder.withIPAddress(ipAddress);
//        builder.usingPort(port);
//        service = AppiumDriverLocalService.buildService(builder);
//        service.start();
//        if (service == null || !service.isRunning()) {
//            throw new RuntimeException("An appium server node is note started!");
//        }
//        return service.getUrl();
//    }
//
//}
