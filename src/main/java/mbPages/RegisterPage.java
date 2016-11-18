package mbPages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RegisterPage 
{
	public AndroidDriver<MobileElement>driver;
	
	public RegisterPage(AndroidDriver<MobileElement> driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
@AndroidFindBy(id="com.timesgroup.magicbricks:id/bar_icon_home")
private MobileElement toggle;
@AndroidFindBy(id="com.timesgroup.magicbricks:id/drawer_btn_login")
private MobileElement registernow;

@AndroidFindBy(id="com.timesgroup.magicbricks:id/login_btn_newuser")
private MobileElement registertoggle;


@AndroidFindBy(id="com.timesgroup.magicbricks:id/personImage")
private MobileElement textregister;
@AndroidFindBy(id="com.timesgroup.magicbricks:id/register_lin_owner")
private MobileElement owner;
@AndroidFindBy(id="com.timesgroup.magicbricks:id/user_name_edit")
private MobileElement name;
//@AndroidFindBy(id="com.timesgroup.magicbricks:id/user_email_edit")
//private MobileElement email;

@AndroidFindBy(id="com.timesgroup.magicbricks:id/user_password_confirm_edit")
private MobileElement location;

@AndroidFindBy(id="com.timesgroup.magicbricks:id/et_city_expanded_search_locality")
private MobileElement entercity;

@AndroidFindBy(id="com.timesgroup.magicbricks:id/tv_subcity_title")
private MobileElement selectcity;




@AndroidFindBy(id="com.timesgroup.magicbricks:id/user_email_edit")
private MobileElement emailtext;
@AndroidFindBy(id="com.timesgroup.magicbricks:id/user_password_edit")
private MobileElement password;
@AndroidFindBy(id="com.timesgroup.magicbricks:id/user_password_confirm_edit")
private MobileElement city;
@AndroidFindBy(id="com.timesgroup.magicbricks:id/user_mobile_edit")
private MobileElement phonenumber;
@AndroidFindBy(id="com.timesgroup.magicbricks:id/signin_text")
private MobileElement authorization;
@AndroidFindBy(id="com.timesgroup.magicbricks:id/submitButton")
private MobileElement submit;
@AndroidFindBy(id="com.timesgroup.magicbricks:id/et_city_expanded_search_locality")
private MobileElement searchcity;
@AndroidFindBy(id="com.timesgroup.magicbricks:id/tv_subcity_title")
private MobileElement searchtext;


public RegisterPage clicktoogle() throws InterruptedException
{
	//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	Thread.sleep(1000L);
	toggle.click();
	registernow.click();
	Thread.sleep(1000l);
	return this;
}
public RegisterPage registration(String name1,String Email1,String password1,String Phone1)
{
	String expected="REGISTER NOW TO BECOME A MEMBER";
	//String actual=driver.findElementByName("REGISTER NOW TO BECOME A MEMBER").getText();
	//Assert.assertEquals(actual, expected);
	System.out.println("In registration page.........");
	registertoggle.click();
    owner.click();
	name.sendKeys(name1);
	emailtext.sendKeys(Email1);
	//location.click();
	//entercity.sendKeys("pune");
	//selectcity.click();
	phonenumber.sendKeys(Phone1);
	driver.scrollToExact("Password");
	password.sendKeys(password1);
	//city.sendKeys(city1);
	
	/*if(authorization.isSelected())
	{
		System.out.println("Authorization is selected....");
	}else
		System.out.println("selecting authorization.....");*/
	return this;
		
}
public RegisterPage submit()
{
	submit.click();
	return this;
}
public RegisterPage selectcity() throws InterruptedException
{
	Thread.sleep(1000);
	city.click();
	searchcity.sendKeys("hyde");
	searchtext.click();
	return this;
}

}
