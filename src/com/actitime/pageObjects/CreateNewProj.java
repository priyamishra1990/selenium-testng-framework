package com.actitime.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewProj 
{
  @FindBy(name="customerId")
  private WebElement cstmrDrpdwn;
  @FindBy(name="name")
  private WebElement projName;
  @FindBy(name="createProjectSubmit")
  private WebElement createProjBtn;
  
  public CreateNewProj(WebDriver driver)
  {
	  PageFactory.initElements(driver, this);
  }
  public void selectCustomer(String customerName)
  {
    Select sel=new Select(cstmrDrpdwn);
    sel.selectByVisibleText(customerName); 
  }
  public void enterprojname(String ProjectName)
  {
	  projName.sendKeys(ProjectName);
  }
  public void createPrj()
  {
	  createProjBtn.click();
  }
}
  
  
