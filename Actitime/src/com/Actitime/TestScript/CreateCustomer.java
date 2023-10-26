package com.Actitime.TestScript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Actitime.GenericLibrary.BaseClass;
import com.Actitime.GenericLibrary.FileLibrary;
import com.Actitime.POM.HomePAge;
import com.Actitime.POM.TAskpage;

public class CreateCustomer extends BaseClass {
	
	@Test
	public void create() throws EncryptedDocumentException, IOException {
		HomePAge hp = new HomePAge(driver);
		hp.getTasklnk().click();
		TAskpage tp = new TAskpage(driver);
		tp.getAddnewbtn().click();
		tp.getNewcustbtn().click();
	    FileLibrary f = new FileLibrary();
		String Custname = f.readDataFromExcel("CUSTOMER", 1, 1);
		String custdesp = f.readDataFromExcel("CUSTOMER", 1, 2);
		tp.getCustomername().sendKeys(Custname);
		tp.getCustdesp().sendKeys(custdesp);
		tp.getCreatecustbtn().click();
		String expecteddata = Custname;
		String actualdata = driver.findElement(By.xpath("(//div[.='abacd'])[2]")).getText();
		SoftAssert s=new SoftAssert();
		s.assertEquals(expecteddata, actualdata);
		s.assertAll();
		
		
		
	}

}
