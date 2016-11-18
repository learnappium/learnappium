package com.mb.MagicBrick;

import java.io.File;
import java.util.Properties;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class StartServer
{
public AppiumDriverLocalService service;
public AppiumDriverLocalService service()
//Properties prop= new Properties();
{
	service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
	.withIPAddress("127.0.0.1")
	.usingPort(4723));
	//.withLogFile(new File("D:\\appiumlog.txt")));
	return service;
}
}
