package com.actitime.pageObjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class EnterTimeTrackPage extends BasePage
{
	WebDriver driver;//its not global only class var    //a

	public EnterTimeTrackPage(WebDriver driver)  //b
	{
		super(driver);
		this.driver=driver;    //a=b	
	}

	public void verifyHomePageTitle()
	{
		String actTitle = driver.getTitle();    //this driver is same as above
		String expTitle = "actiTIME - Enter Time-Track";
		Assert.assertEquals(actTitle, expTitle);
		Reporter.log("Home Page is displayed", true);
	}

}
