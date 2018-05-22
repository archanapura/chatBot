package com.skypeForBusiness.pageObjectlib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.skypeForBusiness.Generic.BaseLibrary;

public class SkyScannerBot extends BaseLibrary
{
	public static void enterQuiries(String query) throws InterruptedException
	{
		WebElement enterText=driver.findElement(By.id("chatInputAreaWithQuotes"));
		enterText.click();
		enterText.clear();
		enterText.sendKeys(query);

		enterText.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	}
	public static String responseForQuiries(String path) 
	{
		return driver.findElement(By.xpath(path)).getText();
	}
	public static void LoginToSkype() throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=13&ct=1526621326&rver=7.0.6730.0&wp=MBI_SSL&wreply=https%3A%2F%2Flw.skype.com%2Flogin%2Foauth%2Fproxy%3Fclient_id%3D578134%26redirect_uri%3Dhttps%253A%252F%252Fweb.skype.com%26intsrc%3Dclient-_-webapp-_-production-_-go-signin%26site_name%3Dlw.skype.com&lc=1033&id=293290&mkt=en-IN&psi=skype&lw=1&cobrandid=2befc4b5-19e3-46e8-8347-77317a16a5a5&client_flight=hsu%2CReservedFlight33%2CReservedFlight67");
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("loginfmt")));
		driver.findElement(By.name("loginfmt")).sendKeys("archanapura@gmail.com");
		driver.findElement(By.xpath("//input[@value='Next']")).click();
		Thread.sleep(3000);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.name("passwd")));
		driver.findElement(By.name("passwd")).sendKeys("pura1982");
		driver.findElement(By.xpath("//input[@value='Sign in']")).click();
	}
	public static void waitForPageload() throws InterruptedException 
	{
		Thread.sleep(25000);
	}
	public static void selectBot() 
	{
		driver.findElement(By.cssSelector("a.recent.Avatar-whiteThemeHover.message.read.active")).click();
	}

}
