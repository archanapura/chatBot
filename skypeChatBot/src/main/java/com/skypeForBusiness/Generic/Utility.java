package com.skypeForBusiness.Generic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility
{
	 public static String captureScreenShot(WebDriver driver) throws IOException{
		 
		  // Take screenshot and store as a file format
		 TakesScreenshot scrShot =((TakesScreenshot)driver);
		  File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		  String path ="D:\\ByjusPOC\\skypeChatBot\\Reports\\"+System.currentTimeMillis()+".png";
	
		 
		 FileUtils.copyFile(SrcFile, new File(path));
		 return path;
		
	
		 
		}
}
