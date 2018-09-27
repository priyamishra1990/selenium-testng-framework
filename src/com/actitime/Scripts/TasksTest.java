package com.actitime.Scripts;

import org.testng.annotations.Test;

import com.actitime.generics.BaseLib;
import com.actitime.generics.ExcelUtilities;
import com.actitime.pageObjects.ActiveProjAndCustPage;
import com.actitime.pageObjects.CreateNewCustPage;
import com.actitime.pageObjects.CreateNewProj;
import com.actitime.pageObjects.EditCustInfoPage;
import com.actitime.pageObjects.EditProjInfo;
import com.actitime.pageObjects.EnterTimeTrackPage;
import com.actitime.pageObjects.LoginPage;
import com.actitime.pageObjects.OpenTasksPage;

public class TasksTest extends BaseLib
{

	@Test
	public void createCustomer()
	{
		String filePath="./testdata/testdata.xlsx";
		String username = ExcelUtilities.readData(filePath, "Sheet1",3, 1);
		String password = ExcelUtilities.readData(filePath, "Sheet1",3, 2);
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);


		EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);
		ettp.clickOnTasks();

		OpenTasksPage otp=new OpenTasksPage(driver);
		otp.clickOnProjAndCustLink();

		ActiveProjAndCustPage apc=new ActiveProjAndCustPage(driver);
		apc.clickOnCreateCustnBtn();
		

		String customerName = ExcelUtilities.readData(filePath, "Sheet1", 3, 3);
		CreateNewCustPage cncp=new CreateNewCustPage(driver);
		cncp.createCustomer(customerName);
		
		apc.verifySuccessPage(customerName);
		apc.clickOnLogOUT();
	}
	
	@Test(dependsOnMethods={"createCustomer"},enabled=false)
	public void deleteCustomer()
	{
		String filePath="./testdata/testdata.xlsx";
		 String username = ExcelUtilities.readData(filePath, "Sheet1",4 ,1 );
		 String password = ExcelUtilities.readData(filePath, "Sheet1",4, 2);
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		
		EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);
		ettp.clickOnTasks();
		
		OpenTasksPage otp=new OpenTasksPage(driver);
		otp.clickOnProjAndCustLink();
		
		String customerName = ExcelUtilities.readData(filePath, "Sheet1",4 ,3 );
		ActiveProjAndCustPage apc=new ActiveProjAndCustPage(driver);
		apc.showCustomer(customerName);
		
		EditCustInfoPage ecip=new EditCustInfoPage(driver);
		ecip.deleteCustomer();
		apc.verifyDeleteMsg();
		apc.clickOnLogOUT();
	}
	@Test(dependsOnMethods={"createCustomer"})
	public void createProject()
	{
		 String filePath="./testdata/testdata.xlsx";
		 String username = ExcelUtilities.readData(filePath, "Sheet1", 5, 1);
		 String password = ExcelUtilities.readData(filePath, "Sheet1", 5, 2);
	     LoginPage lp=new LoginPage(driver);
		 lp.login(username, password);
		
		EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);
		ettp.clickOnTasks();
		
		OpenTasksPage otp=new OpenTasksPage(driver);
		otp.clickOnProjAndCustLink();
		
		String customerName = ExcelUtilities.readData(filePath, "Sheet1", 5, 3);
		//String projName = ExcelUtilities.readData(filePath, "Sheet1", 5, 4);
		ActiveProjAndCustPage apc=new ActiveProjAndCustPage(driver);
		apc.clickOnCreateProject();
		
		CreateNewProj cp=new CreateNewProj(driver);
		cp.selectCustomer(customerName);
		String projName = ExcelUtilities.readData(filePath, "Sheet1", 5, 4);
		cp.enterprojname(projName);
		cp.createPrj();
		apc.clickOnLogOUT();	
		
	}
	@Test(dependsOnMethods={"createProject"})
	
	public void deleteProject(){
		String filePath="./testdata/testdata.xlsx";
		 String username = ExcelUtilities.readData(filePath, "Sheet1", 6, 1);
		 String password = ExcelUtilities.readData(filePath, "Sheet1", 6, 2);
	     LoginPage lp=new LoginPage(driver);
		 lp.login(username, password);
		
		EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);
		ettp.clickOnTasks();
		
		OpenTasksPage otp=new OpenTasksPage(driver);
		otp.clickOnProjAndCustLink();
		
		String customerName = ExcelUtilities.readData(filePath, "Sheet1", 6, 3);
		String projName = ExcelUtilities.readData(filePath, "Sheet1", 6, 4);
		ActiveProjAndCustPage apc=new ActiveProjAndCustPage(driver);
		apc.showProject(customerName, projName);
		
		EditProjInfo epi=new EditProjInfo(driver);
		epi.deleteProject();
		apc.clickOnLogOUT();
		
	}
}
