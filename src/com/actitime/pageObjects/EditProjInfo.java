package com.actitime.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditProjInfo 
{
  @FindBy(xpath="//input[@value='Delete This Project']")
  private WebElement dltPrjBtn;
  @FindBy(id="deleteButton")
  private WebElement delCnfmBtn;
  
  public EditProjInfo(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void deleteProject()
	{
		dltPrjBtn.click();
		delCnfmBtn.click();
		

	}

}


