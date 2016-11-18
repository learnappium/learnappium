package com.mb.MagicBrick;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import mbPages.RegisterPage;

public class RegistrationTest extends TestConfig
{

@Test
public void regtest() throws InterruptedException
{
	new HomePage(driver)
	.clicktoogle()
	.clickLoginRegister()
	.registration("Arvind","learnappium@gmail.com","test1234", "9920536712")
	.selectcity()
	.submit();
}

}
