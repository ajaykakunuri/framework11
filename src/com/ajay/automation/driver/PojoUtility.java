package com.ajay.automation.driver;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.ajay.automation.support.ExcelReader;
import com.ajay.automation.support.PropertiesReader;
import com.ajay.automation.support.TextReader;

public class PojoUtility {
	public static PropertiesReader getPrConfObj() throws IOException
	{
		PropertiesReader prconf=new PropertiesReader(FilePaths.configpath);
		return prconf;
	}

	public static PropertiesReader getprorobj() throws IOException
	{
		PropertiesReader pror=new PropertiesReader(FilePaths.orpath);
		return pror;
	}
	public static ExcelReader getExcelObj() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		ExcelReader excelreader=new ExcelReader(FilePaths.excelpath);
		return excelreader;
	}
	
	public static TextReader getTextObj() throws IOException
	{
		TextReader textreader=new TextReader(FilePaths.txtpath);
		return textreader;
	}
		
		
		
	}

