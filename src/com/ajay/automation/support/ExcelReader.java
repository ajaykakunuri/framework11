package com.ajay.automation.support;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {

	private String filePath;
	private FileInputStream fip;
	private Workbook workbook;
	private Sheet sheet;
	private Row row;
	private String cellvalue;
	private Cell cell;

	public ExcelReader(String filePath) throws EncryptedDocumentException, InvalidFormatException, IOException {
		this.filePath = filePath;
		fip = new FileInputStream(filePath);
		workbook = WorkbookFactory.create(fip);

	}

	public Sheet getSheetobj(String how, String howvalue) {
		if (workbook != null) {
			if (how.equalsIgnoreCase("sheetname"))
				sheet = workbook.getSheet(howvalue);

		} else if (how.equalsIgnoreCase("index")) {
			int index = Integer.parseInt(howvalue);
			workbook.getSheetAt(index);
		} else {
			System.out.println("workbook is null");
		}
		return sheet;
	}

	public int getRowcount(String how, String howvalue) {
		sheet = getSheetobj(how, howvalue);
		int rowcount = 0;
		if (sheet != null) {
			rowcount = sheet.getLastRowNum();
		} else {
			System.out.println("pointing to null");
		}
		return rowcount;
	}

	public int getCellcount(String how, String howvalue, int rowcount) {
		sheet = getSheetobj(how, howvalue);
		int cellcount = 0;
		if (sheet != null) {
			row = sheet.getRow(rowcount);
			cellcount = row.getLastCellNum();
		} else {
			System.out.println("pointing to null");
		}
		return cellcount;
	}

	public String getcelldata(String how, String howvalue, int rowcount, int cellnum) {
		sheet = getSheetobj(how, howvalue);
		cell = sheet.getRow(rowcount).getCell(cellnum);
		if (cell.getCellType() == cell.CELL_TYPE_STRING) {
			cellvalue = cell.getStringCellValue();

		} else if (cell.getCellType() == cell.CELL_TYPE_BOOLEAN) {
			cellvalue = cell.getBooleanCellValue() + "";

		} else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
			cellvalue = cell.getNumericCellValue() + "";

		}

		return cellvalue;
	}

	public List<String> getRowData(String how, String howvalue, int rowcount) {
		List<String> rowData=new ArrayList<String>();
		sheet=getSheetobj(how,howvalue);
		row=sheet.getRow(rowcount);
		if(row!=null) {
			for(int i=0;i<row.getLastCellNum();i++)
		{
				
		cell=row.getCell(i);
				if (cell.getCellType() == cell.CELL_TYPE_STRING) {
					cellvalue = cell.getStringCellValue();
					rowData.add(cellvalue);

				} else if (cell.getCellType() == cell.CELL_TYPE_BOOLEAN) {
					cellvalue = cell.getBooleanCellValue() + "";
					rowData.add(cellvalue);

				} else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
					cellvalue = cell.getNumericCellValue() + "";
					rowData.add(cellvalue);
			
		}
		}
		
		}
	
	else
	{
		System.out.println("row is null");
	}
		return rowData;
		
	}
	public List<String> getSheetData(String how,String howvalue)
	{
		List<String> sheetData=new ArrayList<String>();
		sheet=getSheetobj(how,howvalue);
		for(int i=0;i<=sheet.getLastRowNum();i++)
		{
			row=sheet.getRow(i);
			for(int j=0;j<=row.getLastCellNum();j++)
			{
				cell=row.getCell(j);
				if (cell.getCellType() == cell.CELL_TYPE_STRING) {
					cellvalue = cell.getStringCellValue();
					sheetData.add(cellvalue);

				} else if (cell.getCellType() == cell.CELL_TYPE_BOOLEAN) {
					cellvalue = cell.getBooleanCellValue() + "";
					sheetData.add(cellvalue);

				} else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
					cellvalue = cell.getNumericCellValue() + "";
					sheetData.add(cellvalue);
				
			}
		}
		}
		return sheetData;
	}
	
	public Set<String> getUniqueSheetData(String how,String howvalue)
	{
		List<String> listSheetData=getSheetData(how,howvalue);
		Set<String> setSheetData=new HashSet<String>(listSheetData);
		return setSheetData;
	}
	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		ExcelReader excelReader = new ExcelReader("C:\\Users\\lenovo\\eclipse-workspace\\Framework1\\src\\com\\ajay\\automation\\testdata\\Book1.xls");
		excelReader.getSheetobj("sheetname", "GmailData");

	}

	
	}

