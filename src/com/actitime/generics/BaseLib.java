package com.actitime.generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseLib 
{
	public WebDriver driver;   //c   //this driver(global driver) is having browser instance every driver must be equal to this driver

	@BeforeMethod
	@Parameters({"browser", "testurl"})
	public void setUp(String browserName, String url)
	{
		if (browserName.equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", "./exefiles/geckodriver.exe");
			driver=new FirefoxDriver();
			Reporter.log("Firefox Launched", true);
		}
		else if (browserName.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "./exefiles/chromedriver.exe");
			driver=new ChromeDriver();
			Reporter.log("Chrome Launched", true);
			
		}
		else if (browserName.equalsIgnoreCase("ie")) 
		{
			System.setProperty("webdriver.ie.driver", "./exefiles/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			Reporter.log("IE Launched", true);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		Reporter.log(url+" Url Navigated", true);
	}
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		String scriptName = result.getMethod().getMethodName();
		if(result.isSuccess())  //true---.pass
		{
			Reporter.log(scriptName+" script is passed",  true); 
		}
		else  //false--->Fail
		{
			ScreenshotLib slib=new ScreenshotLib();
			slib.takeScreenshot(driver, scriptName);
			Reporter.log("Screenshot has been taken", true);
		} 
		driver.close();
		Reporter.log("Browser closed", true);
	}
}

