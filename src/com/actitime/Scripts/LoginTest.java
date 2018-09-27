package com.actitime.Scripts;

import org.testng.annotations.Test;

import com.actitime.generics.BaseLib;
import com.actitime.generics.ExcelUtilities;
import com.actitime.pageObjects.EnterTimeTrackPage;
import com.actitime.pageObjects.LoginPage;

public class LoginTest extends BaseLib      //cz launch brwsr is in @beforemethod
{
	/*@Test(priority=1)
	public void validLoginTest()
	{   
		String filePath="./testdata/testdata.xlsx";
		String username = ExcelUtilities.readData(filePath, "Sheet1", 1, 1);
		String password = ExcelUtilities.readData(filePath, "Sheet1", 1, 2);
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);  //b=c
		ettp.verifyLogo();
		ettp.verifyHomePageTitle();

	}*/
	@Test
	public void invalidLoginTest()
	{
		String filePath="./testdata/testdata.xlsx";
		String username = ExcelUtilities.readData(filePath, "Sheet1", 2, 1);
		String password = ExcelUtilities.readData(filePath, "Sheet1", 2, 2);
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		lp.verifyInvalidLoginMsg();
	}
}

