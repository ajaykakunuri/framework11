package com.ajay.automation.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ajay.automation.driver.Screenshotutility;

public class TestcaseActivity implements ITestListener {

	@Override
	public void onTestStart(ITestResult arg0) {
		System.out.println("test started"+arg0.getName());
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		System.out.println("test succeded"+arg0.getName());;
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		System.out.println("test failed"+arg0.getName());
		try {
			Screenshotutility.takescreenshot(arg0.getName());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		System.out.println("test failed"+arg0.getName());
		try {
			Screenshotutility.takescreenshot(arg0.getName());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}


	@Override
	public void onStart(ITestContext arg0) {
		System.out.println("suite started");
	}

	@Override
	public void onFinish(ITestContext arg0) {
	System.out.println("suite completed");
	}
	

}
