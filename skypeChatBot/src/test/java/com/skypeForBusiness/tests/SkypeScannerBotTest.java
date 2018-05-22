package com.skypeForBusiness.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.skypeForBusiness.Generic.BaseLibrary;
import com.skypeForBusiness.Generic.ExcelUtils;
import com.skypeForBusiness.pageObjectlib.SkyScannerBot;

public class SkypeScannerBotTest extends BaseLibrary
{

	@Test
	public void skypeScannerBotTest() throws Throwable 
	{
		//WebDriverWait wait = new WebDriverWait(driver,30);
		logger=extent.startTest("skypeScannerBotTest");
		logger.log(LogStatus.INFO, "Application started");
				int count =5;
				int rown=ExcelUtils.getRowNo("Sheet1");
				SkyScannerBot botTest = new SkyScannerBot();
				// wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a.recent.Avatar-whiteThemeHover.message.read.active")));
				botTest.waitForPageload();
				botTest.selectBot();
				Thread.sleep(3000);
				botTest.enterQuiries("Hi");
				Thread.sleep(3000);
				WebElement resMeg=driver.findElement(By.xpath("(//p[contains(text(),'Hello')]/../../..//h4[text()='Skyscanner'])[last()]"));
		       
				if(resMeg.isDisplayed()) 
				{
					System.out.println(botTest.responseForQuiries("(//p[contains(text(),'Hello')])[last()]"));
					Thread.sleep(6000);
				}
				else
				{
					 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//p[contains(text(),'Hello')]/../../..//h4[text()='Skyscanner'])[last()]")));
					 System.out.println(botTest.responseForQuiries("(//p[contains(text(),'Hello')])[last()]"));
				}

				int rowno=ExcelUtils.getRowNo("Sheet1");
				while(count>0)
				{
					for(int i=0;i<rowno;i++)
					{
						String res= ExcelUtils.getExcelData("Sheet1",i+1,0);
						String req=ExcelUtils.getExcelData("Sheet1",i+1,1);
						if(botTest.responseForQuiries("(//p[contains(text(),'you')])[last()-1]").contains(res)) 
						{
							botTest.enterQuiries(req);
							Thread.sleep(4000);
							break;
						}
					}
					count--;
				}
				driver.findElement(By.xpath("//p[@class='Me-moodMessage']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//span[text()='Sign out']")).click();
				Thread.sleep(3000);
				
			}
	}

