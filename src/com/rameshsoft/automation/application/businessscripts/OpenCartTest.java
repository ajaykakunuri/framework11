package com.rameshsoft.automation.application.businessscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.ajay.auotomation.base.BaseTest1;
import com.ajay.automation.driver.PojoUtility;
import com.ajay.automation.opencart.pages.LaptopsNotebookspage;
import com.ajay.automation.opencart.pages.LoginPage;
import com.ajay.automation.opencart.pages.OpenCart_Headers;
import com.relevantcodes.extentreports.LogStatus;

public class OpenCartTest extends BaseTest1 {
	
	@Test
	public void verifymyaccount() throws IOException
	{
		String url=PojoUtility.getPrConfObj().getPropertyValue("opencart_url");
		getDriver().get(url);
		getExtentTest().log(LogStatus.PASS,"url is entered"+ url);
		LoginPage.mouseoveronmyaccount();
		LoginPage.returningcustomer();
       
		
	}
	
	//@Test
	public void verifyLaptopsNotebokkssize() throws EncryptedDocumentException, InvalidFormatException, IOException {
		String undata;
		undata=PojoUtility.getExcelObj().getcelldata("Sheetname", "GmailData", 0, 0);
		String url=PojoUtility.getPrConfObj().getPropertyValue("opencart_url");
		getDriver().get(url);
		getExtentTest().log(LogStatus.PASS,"url is entered"+ url);
		
		
		LaptopsNotebookspage.mouseoveronlaptop();
		LaptopsNotebookspage.ShowAllLaptopsNotebooks();
		LaptopsNotebookspage.verifylaptopnotebooksize();
		
		
		

	}
	//@Test
	public void verifyheaders() throws EncryptedDocumentException, InvalidFormatException, IOException {
		
		String url=PojoUtility.getPrConfObj().getPropertyValue("opencart_url");
		getDriver().get(url);
		getExtentTest().log(LogStatus.PASS,"url is entered"+ url);
		OpenCart_Headers.verifyheaders();
		

	}
	//@Test
public void verifyshowalllaptops() throws EncryptedDocumentException, InvalidFormatException, IOException {
		
		String url=PojoUtility.getPrConfObj().getPropertyValue("opencart_url");
		getDriver().get(url);
		getExtentTest().log(LogStatus.PASS,"url is entered"+ url);
		LaptopsNotebookspage.mouseoveronlaptop();
		LaptopsNotebookspage.verifylaptopnotebookselements();
		

}
	}
