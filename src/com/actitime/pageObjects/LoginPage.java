package com.actitime.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class LoginPage 
{
	@FindBy(name="username")
	private WebElement UnTxtBx;
	@FindBy(name="pwd")
	private WebElement pwdTxtBx;
	@FindBy(id="loginButton")
	private WebElement loginBtn;
	@FindBy(xpath="//span[contains(text(),'Please try again')]")
	private WebElement invalidLogin;



	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void login(String username, String password)    //Reusable method
	{
		UnTxtBx.sendKeys(username);
		pwdTxtBx.sendKeys(password);
		loginBtn.click();
	}
	public void verifyInvalidLoginMsg()
	{
		String actMsg = invalidLogin.getText();
		String expMsg = "Username or Password is invalid. Please try again.";
		Assert.assertEquals(actMsg, expMsg);
		Reporter.log("Invalid Login verified", true);

	}
}
