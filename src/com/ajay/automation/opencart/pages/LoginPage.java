package com.ajay.automation.opencart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ajay.auotomation.base.ActionEngine;
import com.ajay.auotomation.base.BaseTest1;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPage extends BaseTest1 {
	
	@FindBy(xpath="//i[@class='fa fa-user']")
	private static WebElement MyAccount;
	@FindBy(xpath="//a[normalize-space()='Login']")
	private static WebElement login;
	
	@FindBy(xpath="//div[@class='col-sm-9']/div/div[2]")
	private static WebElement Returningcustomer;
	
	@FindBy(xpath="//input[@id='input-email']")
	private static WebElement username;
	
	@FindBy(xpath="//input[@id='input-password']")
	private static WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	private static WebElement loginbutton;
	
	@FindBy(xpath="//a[text()='Laptops & Notebooks']")
	private static WebElement LaptopNoteBooks;
	
	@FindBy(xpath="//a[text()='Show All Laptops & Notebooks']")
	private static WebElement ShowAllLaptopsNotebooks;

	@FindBy(xpath="//div[@class='button-group']/button/i[@class='fa fa-shopping-cart']")
	private static WebElement addtocartbutton;
	
	/*public static void myaccountdisplayed() {
		try {
			Assert.assertTrue(MyAccount.isDisplayed()&&MyAccount.isEnabled());
		getExtentTest().log(LogStatus.PASS,"myaccount page is displayed");
	
		
			Thread.sleep(3000);
			

	}catch(Exception exception) {
		getExtentTest().log(LogStatus.FAIL, "myaccount is not displayed");
		
	}
	}*/
	public static void mouseoveronmyaccount() {
		try {
			Assert.assertTrue(MyAccount.isDisplayed()&&MyAccount.isEnabled());
		getExtentTest().log(LogStatus.PASS,"laptopnotebook page is displayed");
		Actions actions=new Actions(getDriver());
		actions.moveToElement(MyAccount).build().perform();
		getExtentTest().log(LogStatus.PASS, "navigated");
		actions.click(MyAccount).build().perform();
		getExtentTest().log(LogStatus.PASS, "my account clicked");
		Thread.sleep(1000);
		login.click();
		
		
		
		getExtentTest().log(LogStatus.PASS, "mouse over is performed");
			
			

	}catch(Exception exception) {
		getExtentTest().log(LogStatus.FAIL, "myaccount is not displayed");
		
	}
	}
	public static void returningcustomer() {
		try {
			
		ActionEngine.DTA(username, "username", "ajaykakunuri@gmail.com");
		ActionEngine.DTA(password, "password", "9246484968daddy");
		loginbutton.click();
		getExtentTest().log(LogStatus.PASS, "clicked on login");
		Thread.sleep(3000);
		LaptopNoteBooks.click();
		getExtentTest().log(LogStatus.PASS, "laptop&notebookclicked");
		Thread.sleep(3000);
		ShowAllLaptopsNotebooks.click();
		getExtentTest().log(LogStatus.PASS, "shwalllaptopnotebooksclickedclicked");
		Thread.sleep(3000);
		addtocartbutton.click();
		getExtentTest().log(LogStatus.PASS, "addtocart clicked");
			

	}catch(Exception exception) {
		getExtentTest().log(LogStatus.FAIL, "login is not clicked");
		
	}
		

	}
	
		static
		{
			PageFactory.initElements(getDriver(), LoginPage.class);
		}
	
	/*public static void login() {
		try {
			Assert.assertTrue(login.isDisplayed()&&login.isEnabled());
		getExtentTest().log(LogStatus.PASS,"ShowAllLaptopsNotebooks page is displayed");
		login.click();
		Thread.sleep(3000);
			
			getExtentTest().log(LogStatus.PASS, "login is enabled");
			
			

	}catch(Exception exception) {
		getExtentTest().log(LogStatus.FAIL, "login is not displayed");
		
	}*/
		
	

}
