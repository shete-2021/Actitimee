package com.Actitime.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePAge {
	
	//declaration
	
	@FindBy(xpath="//div[.='Tasks']")
	private WebElement tasklnk;
	
	@FindBy(xpath="//div[.='Reports']")
	private WebElement reportlnk;
	
	@FindBy(xpath="//div[.='Users']")
	private WebElement lgoutlnk;
	
	//initialization
	public HomePAge(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	
	//utilization
	public WebElement getTasklnk() {
		return tasklnk;
	}

	public WebElement getReportlnk() {
		return reportlnk;
	}

	public WebElement getLgoutlnk() {
		return lgoutlnk;
	}
	
	
}
