package com.mb.MagicBrick;

import org.testng.annotations.Test;

import mbPages.RegisterPage;

public class AutodeskLoginTest extends TestConfig{
	
	@Test
	public void regtest() throws InterruptedException
	{   System.out.println("--------------------------------------------------------------------------------------");
	Thread.sleep(10000L);
		System.out.println(driver.getPageSource());
	}

}
