package com.mb.MagicBrick;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mbPages.RegisterPage;

public class SearchPage {
	public AndroidDriver<MobileElement> driver;

	public SearchPage(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
//com.timesgroup.magicbricks:id/locality_text_view  
	//android.widget.EditText
	   //com.timesgroup.magicbricks:id/rl_nearmelocality
//com.timesgroup.magicbricks:id/done_button
	//Flat House/Villa    1 BHK
	//com.timesgroup.magicbricks:id/buy_searchButton
	
	
	@AndroidFindBy(id="com.timesgroup.magicbricks:id/locality_text_view")
	private MobileElement city;
	
	@AndroidFindBy(className="android.widget.EditText")
	private MobileElement cityname;
	
	@AndroidFindBy(id="com.timesgroup.magicbricks:id/rl_nearmelocality")
	private MobileElement selectcity;
	
	@AndroidFindBy(id="com.timesgroup.magicbricks:id/done_button")
	private MobileElement citydone;
	
	@AndroidFindBy(name="Flat")
	private MobileElement protyp;
	
	@AndroidFindBy(id="com.timesgroup.magicbricks:id/buy_searchButton")
	private MobileElement serchbutton;
	
	public SearchPage selectcity() throws InterruptedException
	{
		Thread.sleep(1000);
		city.click();
		cityname.sendKeys("hadap");
		Thread.sleep(2000);
		selectcity.click();
		citydone.click();
		return this;
	}
	
	public SearchPage selectPropType(String propname) throws InterruptedException
	{
		Thread.sleep(1000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+propname+"']"));
		
		Thread.sleep(5000);
	
		return this;
	}
	
	public SearchPage selectPropSize(String propsize) throws InterruptedException
	{
		Thread.sleep(1000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+propsize+"']"));
		
		Thread.sleep(5000);
	
		return this;
	}
	
	public SearchPage clickSearchButton() throws InterruptedException
	{
		Thread.sleep(1000);
		serchbutton.click();		
		Thread.sleep(10000);
	
		return this;
	}
	
}
