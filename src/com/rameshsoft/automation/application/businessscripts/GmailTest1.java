package com.rameshsoft.automation.application.businessscripts;


	import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.testng.annotations.Test;

import com.ajay.auotomation.base.BaseTest1;
import com.ajay.automation.driver.PojoUtility;
import com.relevantcodes.extentreports.LogStatus;

	

	public class GmailTest1 extends BaseTest1 {
		
		@Test
	public void	GmailTest() throws IOException, EncryptedDocumentException, InvalidFormatException
	{
			String undata="";
			/*FileInputStream fip=new FileInputStream("C:\\Users\\lenovo\\eclipse-workspace\\Framework1\\src\\com\\ajay\\automation\\testdata\\Book1.xls");
			Workbook workbook=WorkbookFactory.create(fip);
			Sheet sheet=workbook.getSheet("GmailData");
			
				Row row=sheet.getRow(0);
				
					Cell cell=row.getCell(0);
					if(cell.getCellType()==cell.CELL_TYPE_STRING)
					{
					undata=cell.getStringCellValue();
					
					}
					else if(cell.getCellType()==cell.CELL_TYPE_BOOLEAN)
					{
					undata=cell.getBooleanCellValue()+"";
					
					}
					else if(cell.getCellType()==cell.CELL_TYPE_NUMERIC)
					{
					undata=cell.getNumericCellValue()+"";
					
					}*/
					undata=PojoUtility.getExcelObj().getcelldata("Sheetname", "GmailData", 0, 0);
			String url=PojoUtility.getPrConfObj().getPropertyValue("qa_url");
			getDriver().get(url);
			getExtentTest().log(LogStatus.PASS,"url is entered"+ url);
		String un_id=PojoUtility.getprorobj().getPropertyValue("un_id");
		WebElement username=getDriver().findElement(By.id(un_id));
		username.clear();
		getExtentTest().log(LogStatus.PASS,"username is cleared");
 String un_user=PojoUtility.getprorobj().getPropertyValue("un_next");		
 username.sendKeys(undata);
 getExtentTest().log(LogStatus.PASS,"data typing username is done"+ undata);
		WebElement nxt=getDriver().findElement(By.id(un_user));
		nxt.click();
		getExtentTest().log(LogStatus.PASS,"next is clicked");
		
				
	}


}
