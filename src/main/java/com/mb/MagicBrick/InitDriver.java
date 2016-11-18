package com.mb.MagicBrick;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


public class InitDriver
{
	public static AndroidDriver<MobileElement>driver;
	public static DesiredCapabilities cap;
	Properties prop= new Properties();
	public StartServer server;
	 
	//AppiumDriverLocalService services=
	//		AppiumDriverLocalService.buildService(new AppiumServiceBuilder().withStartUpTimeOut(30,TimeUnit.SECONDS));
	 public AndroidDriver<MobileElement> initdriver() throws MalformedURLException, IOException 
	 {
		ReadWriteFromPropertyFile prop=new ReadWriteFromPropertyFile("android_config_");
		server = new StartServer();
	cap = new DesiredCapabilities();
	 
    cap.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.readProperty().getProperty("platformname"));
    cap.setCapability(MobileCapabilityType.DEVICE_NAME, prop.readProperty().getProperty("devicename"));
    
   
    //cap.setCapability(MobileCapabilityType.APP_ACTIVITY, prop.readProperty().getProperty("unlocker_activity")); 
    //cap.setCapability(MobileCapabilityType.APP_PACKAGE, prop.readProperty().getProperty("unlocker_package"));
    
    	cap.setCapability(MobileCapabilityType.APP_ACTIVITY, prop.readProperty().getProperty("setting_activity")); 
        cap.setCapability(MobileCapabilityType.APP_PACKAGE, prop.readProperty().getProperty("setting_package"));
    
   // URL url = new URL("http://"+prop.readProperty().getProperty("ip")+":"+prop.readProperty().getProperty("port")+"/wd/hub");
   // URL url=new URL("http://127.0.0.1:4723/wd/hub");
   driver = new AndroidDriver<MobileElement>(server.service(),cap);
   
   	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   	boolean isappinstalled=driver.isAppInstalled(prop.readProperty().getProperty("app_package"));
   	if(!isappinstalled)
   	{
   		System.out.println("Application is not istalled.........installing app");
   		driver.installApp(prop.readProperty().getProperty("filepath"));
   		System.out.println("Application is installed.....");
   		System.out.println("Opening application");
   		driver.startActivity(prop.readProperty().getProperty("app_package"), prop.readProperty().getProperty("app_activity"));
   		System.out.println("application Launched successfully");
   	}
   	else{
   		
   		System.out.println("App already installed ..... Reseting app");
		//driver.resetApp();    		
		System.out.println("Opening app");
		driver.startActivity(prop.readProperty().getProperty("app_package"), prop.readProperty().getProperty("app_activity"));    		
		System.out.println("App lunched successfully");
   	}
   	
   	return driver;
	}

}
