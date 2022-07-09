package com.ajay.automation.opencart.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.ajay.auotomation.base.BaseTest1;
import com.ajay.automation.driver.PojoUtility;
import com.relevantcodes.extentreports.LogStatus;

public class OpenCart_Headers extends BaseTest1 {
	
	static
	{
		PageFactory.initElements(getDriver(),OpenCart_Headers.class );
	}
	
	@FindBys(@FindBy(xpath="//ul[@class='nav navbar-nav']/li/a"))
			private static List<WebElement> headers;
	public static List<String> getHeaders()
	{
		List<String> headersdata=new ArrayList<String>();
		for(WebElement element:headers)
		{
			String headertxt=element.getText();
			headersdata.add(headertxt);
			getExtentTest().log(LogStatus.PASS, "headerstext is:"+headertxt);
			
		}
		return headersdata;
	}
	
public static void verifyheaders() throws EncryptedDocumentException, InvalidFormatException, IOException {
	String data=PojoUtility.getExcelObj().getcelldata("sheetname", "GmailData", 0, 1);
String[] str=data.split(",");
List<String> headerstestdata=new ArrayList<String>();
for(String str1:str) {
headerstestdata.add(str1);
}
List<String> actualdata=getHeaders();
Collections.sort(actualdata);
Collections.sort(headerstestdata);
if(actualdata==headerstestdata)
{
	getExtentTest().log(LogStatus.PASS, "headres are matching"+actualdata+"="+headerstestdata);
}else
{
	getExtentTest().log(LogStatus.FAIL, "headres are not matching"+actualdata+"="+headerstestdata);
}


}
}
