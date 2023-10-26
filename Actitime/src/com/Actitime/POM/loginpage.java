package com.Actitime.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
	
	//declaration
	
		@FindBy(id="")
		private WebElement untbx;
		
		@FindBy(name="")
		private WebElement pwtbx;
		
		@FindBy(xpath="")
		private WebElement lgbtn;
		
		//initialization
		
		public loginpage(WebDriver d) {
			PageFactory.initElements(d, this);
		}

		//utilization

		public WebElement getUntbx() {
			return untbx;
		}

		public WebElement getPwtbx() {
			return pwtbx;
		}

		public WebElement getLgbtn() {
			return lgbtn;
		}
		
		


}
