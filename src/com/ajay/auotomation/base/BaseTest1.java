package com.ajay.auotomation.base;


	
	import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
	import org.testng.annotations.Parameters;

import com.ajay.automation.driver.Driverpaths;
import com.ajay.automation.driver.Screenshotutility;
import com.ajay.automation.exception.FrameworkException;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.io.File;
import java.io.IOException;

	public class BaseTest1 {
		private static WebDriver driver; 
		private static String tcname;
		private static ExtentReports extentreports;
		private static ExtentTest extenttest;
			
	    @Parameters({"browser"})
		@BeforeSuite
		public void OpenBrowser(@Optional("chrome")String browser)
		{
			if(browser.equalsIgnoreCase("msedge"))
			{
				System.setProperty(Driverpaths.edgekey,Driverpaths.edgevalue);
			driver=new EdgeDriver();
			init();
			}
			
		
		else if (browser.equalsIgnoreCase("ie"))
		{
			System.setProperty(Driverpaths.iekey,Driverpaths.ievalue);
		driver=new InternetExplorerDriver();
		init();
		
		}
		else if (browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty(Driverpaths.chromekey,Driverpaths.chromevalue);
		driver=new ChromeDriver();
		init();
		
		}

		}
		public void init() {
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(45,TimeUnit.SECONDS);

		}
		@AfterSuite
		public void close() throws FrameworkException {
			if(driver!=null) {
				driver.close();
			}
			else {
				FrameworkException exception =new FrameworkException("null");
				System.out.println("null");
				throw exception;
			}
		}
		
		@BeforeMethod
		public void beforetcexecution(Method method) {
			tcname=method.getName();
			System.out.println("test excecution"+tcname);
			extenttest=extentreports.startTest(tcname);
			extenttest.log(LogStatus.PASS,"test case is passed"+ tcname);
			
		}
		@AfterMethod
		public void aftertcexecution(ITestResult result) throws IOException {
			String tcname=result.getName();
			if(result.getStatus()==ITestResult.SUCCESS)
			{
			System.out.println("test case is passed"+tcname);
			extenttest.log(LogStatus.PASS,"test case is passed"+ tcname);
			}
			else if(result.getStatus()==ITestResult.FAILURE)
			{
				System.out.println("tc failed"+tcname);
				String imagepath=Screenshotutility.takescreenshot();
				extenttest.log(LogStatus.FAIL,"test case is failed"+ tcname);
				extenttest.log(LogStatus.FAIL,result.getThrowable());
				extenttest.addScreenCapture(imagepath);
			}
			else if(result.getStatus()==ITestResult.SKIP)
			{
				System.out.println("test case skipped"+tcname);
				String imagepath=Screenshotutility.takescreenshot();
				extenttest.log(LogStatus.SKIP,"test case is skipped"+ tcname);
				extenttest.log(LogStatus.SKIP,result.getThrowable());
				extenttest.addScreenCapture(imagepath);
			}
			extentreports.endTest(extenttest);
			extentreports.flush();
			}
		@BeforeTest
		public void initreports()
		{
			extentreports=new ExtentReports("C:\\Users\\lenovo\\eclipse-workspace\\Framework1\\reports\\reports3.html");
			
		}
		public void generatereports() throws FrameworkException {
			if(extentreports!=null) {
				extentreports.close();
		}
		else
		{
			FrameworkException exception=new FrameworkException("extent reports are pointing to null");
			throw exception;
		}
		

		}
		
			public static WebDriver getDriver()
			{
				return driver;
			}

			public static String gettcname()
			{
				return tcname;
			}
			
				
public static ExtentTest getExtentTest() {
	return extenttest;
	
}

		}




