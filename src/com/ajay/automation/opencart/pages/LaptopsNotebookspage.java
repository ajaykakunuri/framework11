package com.ajay.automation.opencart.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ajay.auotomation.base.BaseTest1;
import com.relevantcodes.extentreports.LogStatus;

public class LaptopsNotebookspage extends BaseTest1 {
	@FindBy(xpath="//a[text()='Laptops & Notebooks']")
	private static WebElement LaptopNoteBooks;
	
	@FindBy(xpath="//a[text()='Show All Laptops & Notebooks']")
	private static WebElement ShowAllLaptopsNotebooks;
	
	@FindBy(xpath="//div[@class='list-group']/a[2]")
	private static WebElement actualLaptopSize;
	
	@FindBys(@FindBy(xpath="//div[@class='product-thumb']/div/a/img"))
	private static List<WebElement> expectedlaptopsize;
	
	@FindBy(xpath="(//a[text()='Macs (0)'])")
	private static WebElement mac;
	
	@FindBy(xpath="(//a[text()='Windows (0)'])")
	private static WebElement windows;
	
	
	public static void verifylaptopnotebookselements() {
		try {
			Assert.assertTrue(ShowAllLaptopsNotebooks.isDisplayed()&&ShowAllLaptopsNotebooks.isEnabled());
		getExtentTest().log(LogStatus.PASS,"ShowAllLaptopsNotebooks page is displayed");
		Assert.assertTrue(mac.isDisplayed()&&mac.isEnabled());
		getExtentTest().log(LogStatus.PASS,"mac page is displayed");
		Assert.assertTrue(windows.isDisplayed()&&windows.isEnabled());
		getExtentTest().log(LogStatus.PASS,"windows page is displayed");
		}
		catch(Exception exception)
		{
			getExtentTest().log(LogStatus.FAIL,"windows page is not displayed");
			getExtentTest().log(LogStatus.FAIL,"mac page is not displayed");
			
		}

	}
	public static void mouseoveronlaptop() {
		try {
			Assert.assertTrue(LaptopNoteBooks.isDisplayed()&&LaptopNoteBooks.isEnabled());
		getExtentTest().log(LogStatus.PASS,"laptopnotebook page is displayed");
		Actions actions=new Actions(getDriver());
		actions.moveToElement(LaptopNoteBooks).build().perform();
		getExtentTest().log(LogStatus.PASS, "mouse over is performed");
			Thread.sleep(3000);
			

	}catch(Exception exception) {
		getExtentTest().log(LogStatus.FAIL, "laptopnotebooks is not displayed");
		
	}
	}
	public static void ShowAllLaptopsNotebooks() {
		try {
			Assert.assertTrue(ShowAllLaptopsNotebooks.isDisplayed()&&ShowAllLaptopsNotebooks.isEnabled());
		getExtentTest().log(LogStatus.PASS,"ShowAllLaptopsNotebooks page is displayed");
		ShowAllLaptopsNotebooks.click();
		Thread.sleep(3000);
			
			getExtentTest().log(LogStatus.PASS, "ShowAllLaptopsNotebooks is enabled");
			
			

	}catch(Exception exception) {
		getExtentTest().log(LogStatus.FAIL, "ShowAllLaptopsNotebooks is not displayed");
		
	}
		
	}
	
	
	public static int getactualLaptopSize() {
	   int actuallaptopsize=0;
		try {
			Assert.assertTrue(actualLaptopSize.isDisplayed()&&actualLaptopSize.isEnabled());
		getExtentTest().log(LogStatus.PASS,"actualLaptopSize page is displayed");
		String txt=actualLaptopSize.getText();
			
			getExtentTest().log(LogStatus.PASS, "actualLaptopSize is"+txt);
			String[] str=txt.split(" ");
			String txt1=str[str.length-1];
			String[] txt2=txt1.split("");
			String actualsize=txt2[1];
			actuallaptopsize=Integer.parseInt(actualsize);
			
			Thread.sleep(2000);
			
			
			

	}catch(Exception exception) {
		getExtentTest().log(LogStatus.FAIL, "actualLaptopSize is not displayed");
		
	}
		return actuallaptopsize;

	}
public static int getexpectedlaptopsize() {
	int expectedlaptopnumber=0;
	try {
		expectedlaptopnumber=expectedlaptopsize.size();
		}catch(Exception exception) {
	getExtentTest().log(LogStatus.FAIL, "expectedLaptopSize is not displayed");
	
}
	return expectedlaptopnumber;

	}
public static void verifylaptopnotebooksize() {
	try {
		int actuallaptopsize1=getactualLaptopSize();
		int expectedlaptopnumber1=getexpectedlaptopsize();
		if(actuallaptopsize1==expectedlaptopnumber1) {
			getExtentTest().log(LogStatus.PASS, "laptops and notebooks size is matched");
		}
		
			else {
				getExtentTest().log(LogStatus.FAIL, "laptops and notebooks size is not matched");
				
			}
			
		}catch(Exception exception)
	{
	}
	
	}
static
{
	PageFactory.initElements(getDriver(),LaptopsNotebookspage.class);		
}




}
