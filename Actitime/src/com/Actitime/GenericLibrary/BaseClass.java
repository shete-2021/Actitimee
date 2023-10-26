package com.Actitime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Actitime.POM.loginpage;

public class BaseClass {
	public static WebDriver driver;
	FileLibrary f=new FileLibrary();
	@BeforeSuite
	public void databaseConnection() {
		Reporter.log("database connected",true);
	}
	
	@BeforeClass
	public void launchbrowser() throws IOException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String URL = f.readDataFromProperty("url");
		driver.get(URL);
		//driver.get("https://demo.actitime.com");
		//Reporter.log("browser launched successfully",true);
		
	}
	
	@BeforeMethod
	public void login() throws IOException {
		loginpage lp = new loginpage(driver);
		String un = f.readDataFromProperty("un");
		String pw = f.readDataFromProperty("pw");
		lp.getUntbx().sendKeys(un);
		lp.getPwtbx().sendKeys(pw);
		lp.getLgbtn().click();
		//driver.findElement(By.id("username")).sendKeys("admins");
		//driver.findElement(By.name("pwd")).sendKeys("manager");
		//driver.findElement(By.xpath("//div[.='Login ']")).click();
		Reporter.log("login successfully",true);
		
	}
	@AfterMethod
	public void logout() {
		driver.findElement(By.id("logoutLink")).click();
		Reporter.log("logged out successfully",true);
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
		Reporter.log("browser closed successfully",true);
	}
	
	@AfterSuite
	public void databasedisconnected() {
		Reporter.log("database disconnected",true);
	}

	
	
	

}
