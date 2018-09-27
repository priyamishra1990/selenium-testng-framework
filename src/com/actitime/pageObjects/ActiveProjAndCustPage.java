package com.actitime.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

public class ActiveProjAndCustPage extends BasePage
{
	@FindBy(css="input[value='Create New Customer']")
	private WebElement createNewCustBtn;
	@FindBy(className="successmsg")
	private WebElement successMsg;   //msg for everything can be stored here[common element for create and dlt customer]
	@FindBy(name="selectedCustomer")
	private WebElement customerDrpDwn;
    @FindBy(css="input[value*='Show']")
    private WebElement showBtn;
    @FindBy(xpath="//td[starts-with(@id,'customerNameCell')]//a[contains(@href,'customerId')]")
    //private WebElement custNameLink;
    private List<WebElement> custNameLink;  //to select multiple customer from same xpath(for single and all active customer)
    @FindBy(css="input[value='Create New Project']")
    private WebElement createNewProject;
    @FindBy(xpath="//td[starts-with(@id,'projectNameCell')]//a[contains(@href,'projectId')]")
    private List<WebElement> projLink;
    

	public ActiveProjAndCustPage(WebDriver driver)
	{
		super(driver);  //since extended basepage
		PageFactory.initElements(driver, this);
	}

	public void clickOnCreateCustnBtn()
	{
		createNewCustBtn.click();
	}

	public void verifySuccessPage(String customerName)
	{
		String actMsg = successMsg.getText();
		// String expMsg = "Customer \"GE HealthCare\" has been successfully created.";
		Assert.assertTrue(successMsg.isDisplayed());
		Assert.assertTrue(actMsg.contains(customerName));
		Reporter.log(actMsg, true);
	}
	public void showCustomer(String customerName)
	{
		Select sel=new Select(customerDrpDwn);
		sel.selectByVisibleText(customerName);  //cust name from excel; sheet
		showBtn.click();
		if(custNameLink.get(0).getText().equals(customerName))
		{
			custNameLink.get(0).click();
		}
		else
		{
	      System.out.println(customerName+" customer doesn't exist");
		}
}
	public void verifyDeleteMsg()
	{
		String expMsg = "Customer has been successfully deleted.";
		String actMsg = successMsg.getText();
		Assert.assertEquals(actMsg, expMsg);
		Reporter.log(expMsg, true);
	}
	public void clickOnCreateProject()
	{
		createNewProject.click();
	}
	public void verifyProjCreation()
	{
		String expMsg = "Project has been successfully created.";
		String actMsg = successMsg.getText();
		//Assert.assertTrue(successMsg.isDisplayed());
		//Assert.assertTrue(actMsg.contains(ProjectName));
		Assert.assertEquals(actMsg, expMsg);
		Reporter.log(expMsg, true);
	}
	public void showProject(String customerName,String projName)
	{
		Select sel=new Select(customerDrpDwn);
		sel.selectByVisibleText(customerName);  //cust name from excel; sheet
		showBtn.click();
		if(projLink.get(1).getText().equals(projName))
		{
			projLink.get(1).click();
		}
		else
		{
	      System.out.println(projName+" project doesn't exist");
		}
} 
}




