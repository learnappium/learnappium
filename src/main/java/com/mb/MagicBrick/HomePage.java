package com.mb.MagicBrick;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mbPages.RegisterPage;

public class HomePage {
	public AndroidDriver<MobileElement> driver;

	public HomePage(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.timesgroup.magicbricks:id/bar_icon_home")
	private MobileElement toggle;
	@AndroidFindBy(id = "com.timesgroup.magicbricks:id/drawer_btn_login")
	private MobileElement registernow;

	@AndroidFindBy(id = "com.timesgroup.magicbricks:id/login_btn_newuser")
	private MobileElement registertoggle;
	
	
	//com.timesgroup.magicbricks:id/btn_buy
	//com.timesgroup.magicbricks:id/btn_rent
	//com.timesgroup.magicbricks:id/btn_newprojects
	//com.timesgroup.magicbricks:id/tv_postproperty
	
	
	public HomePage clicktoogle() throws InterruptedException
	{
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(1000L);
		toggle.click();		
		Thread.sleep(1000l);
		return this;
	}
	
	public RegisterPage clickLoginRegister() throws InterruptedException
	{
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		registernow.click();
		Thread.sleep(1000l);
		return new RegisterPage(driver);
	}
	
	public SearchPage clickRentBuyNewprojects(String proptype) throws InterruptedException
	{
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementById("com.timesgroup.magicbricks:id/btn_"+proptype+"").click();
		Thread.sleep(1000l);
		return new SearchPage(driver);
	}
	
}
