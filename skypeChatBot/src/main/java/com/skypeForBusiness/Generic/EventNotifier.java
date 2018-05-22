package com.skypeForBusiness.Generic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class EventNotifier implements ITestListener{

	@Override
	public void onFinish(ITestContext result) {
		// TODO Auto-generated method stub
		
		
		
	}

	@Override
	public void onStart(ITestContext result) {
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		 String FailedTestName=result.getMethod().getMethodName();
	        EventFiringWebDriver edri=new EventFiringWebDriver(BaseLibrary.driver);
	        File srcfile=edri.getScreenshotAs(OutputType.FILE);
	        File dstfile=new File("./screenshot/"+FailedTestName+".png");
	        try{
	        	
	            FileUtils.copyFile(srcfile, dstfile);
	            }
	            catch(IOException e){
	            };
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		
	}

}
