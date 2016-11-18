package com.mb.MagicBrick;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class AppiumTest {
	public AndroidDriver driver;
	public DesiredCapabilities cap;
	
	@BeforeTest
	public void init() throws MalformedURLException{
		File appDir = new File("D://Appium//Android//android-sdk//platform-tools");
        File app = new File(appDir, "Deckard.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device","Android");

        //mandatory capabilities
        capabilities.setCapability("deviceName","Android");
        capabilities.setCapability("platformName","Android");

        //other caps
        capabilities.setCapability("app", app.getAbsolutePath());
        driver  =  new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);


        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);   ;
	}
	
	@Test
	public void absTest(){
		System.out.println("this is test");
	}

}
