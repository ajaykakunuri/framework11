package com.ajay.automation.driver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.ajay.auotomation.base.BaseTest1;

public interface Screenshotutility {
	
	public static String takescreenshot() throws IOException {
		TakesScreenshot takescreenshot=(TakesScreenshot) BaseTest1.getDriver();
		File file=takescreenshot.getScreenshotAs(OutputType.FILE);
		String imagepath="C:\\Users\\lenovo\\eclipse-workspace\\Framework1\\screenshots"+BaseTest1.gettcname()+".jpeg";
		FileUtils.copyFile(file, new File(imagepath));
	return imagepath;
	}

	public static String takescreenshot(String tcname) throws IOException {
		TakesScreenshot takescreenshot=(TakesScreenshot) BaseTest1.getDriver();
		File file=takescreenshot.getScreenshotAs(OutputType.FILE);
		String imagepath="C:\\Users\\lenovo\\eclipse-workspace\\Framework1\\screenshots"+tcname+".jpeg";
		FileUtils.copyFile(file, new File(imagepath));
	return imagepath;
	}
	
	}

