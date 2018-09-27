package com.actitime.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewCustPage 
{
	@FindBy(name="name")
	private WebElement enterName;
	@FindBy(name="createCustomerSubmit")
	private WebElement createCustSubmitBtn;

	public CreateNewCustPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this); 
	}
	public void createCustomer(String customerName)
	{
		enterName.sendKeys(customerName);
		createCustSubmitBtn.click();
	}
}
