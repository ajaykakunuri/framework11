package com.ajay.automation.testdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelDemo {

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
	
		FileInputStream fip=new FileInputStream("C:\\Users\\lenovo\\eclipse-workspace\\Framework1\\src\\com\\ajay\\automation\\testdata\\Book1.xls");

	Workbook workbook=WorkbookFactory.create(fip);
	Sheet sheet=workbook.getSheet("GmailData");
	System.out.println("workbookvalue is"+workbook);
	for(int i=0;i<=sheet.getLastRowNum();i++)
	{
		Row row=sheet.getRow(i);
		for(int j=0;j<row.getLastCellNum();j++)
		{
			Cell cell=row.getCell(j);
			if(cell.getCellType()==cell.CELL_TYPE_STRING)
			{
			String cellvalue=cell.getStringCellValue();
			System.out.println(cellvalue);
			}
			else if(cell.getCellType()==cell.CELL_TYPE_BOOLEAN)
			{
			String cellvalue=cell.getBooleanCellValue()+"";
			System.out.println(cellvalue);
			}
			else if(cell.getCellType()==cell.CELL_TYPE_NUMERIC)
			{
			String cellvalue=cell.getNumericCellValue()+"";
			System.out.println(cellvalue);
			}
			
			
			
			
			}
		}
	}
	
	}


