package com.mb.MagicBrick;

import java.io.File;
import java.io.IOException;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestConfig 
{
	
	public static AndroidDriver<MobileElement> driver;
	public InitDriver init;
	
	@BeforeTest
	public void beforeTest() throws IOException{
		
		init = new InitDriver();
		
		driver = init.initdriver();
		
	}
	
	@AfterTest
	public void afterTest(){
		driver.quit();
	}
	
	@AfterMethod
	public void takeFailedtestScreenShot(ITestResult result) throws IOException{
          if(!result.isSuccess()){
			
			File imageFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String failureImage=result.getMethod().getMethodName()+ System.nanoTime()+".png";
			File failureImageFile = new File(failureImage);
			org.apache.commons.io.FileUtils.moveFile(imageFile, failureImageFile);
		}
	}

}
