package com.actitime.pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public abstract class BasePage 
{
    @FindBy(css="img[src*='default-logo.png']")
    private WebElement logo;
    @FindBy(xpath="//div[text()='Tasks']")
    private WebElement tasks;
    @FindBy(id="logoutLink")
    private WebElement logoutLink;
    
    public BasePage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }
     public void verifyLogo()
     {
    	 Assert.assertTrue(logo.isDisplayed());
    	 Reporter.log("Logo is Displayed");
     }
     public void clickOnTasks()
     {
    	 tasks.click();
     }
     
    public void clickOnLogOUT()
    {
    	logoutLink.click();
    }
}

