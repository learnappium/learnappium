package com.mb.MagicBrick;

import org.testng.annotations.Test;

public class SearchPropTest extends TestConfig
{

@Test
public void regtest() throws InterruptedException
{
	new HomePage(driver)
	.clickRentBuyNewprojects("buy")
	.selectcity()
	.selectPropType("House/Villa")
	.selectPropSize("1 BHK")
	.clickSearchButton()
	;
}

}
