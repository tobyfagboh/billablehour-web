package com.test.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.base.TestBase;
import com.test.dataSupplier.CustomerLogin;
import com.test.dataSupplier.CustomerSignUp;
import com.test.utility.Utility;



public class ValidateInvoiceUpload extends TestBase{
	
	@Test
	public void validateFileUpload() throws IOException, InterruptedException {
	String	expectedprojectName = "Google";
	String expectedprojectName2 = "Facebook";
	
	
	//to select file
	WebElement uploadFile =	driver.findElement(By.id(Utility.fetchLocator("browseBtn_ID")));
		uploadFile.sendKeys("C:\\test.csv");
		Thread.sleep(6000);
		
		//to click the pares file button
		WebElement parseBtn = driver.findElement(By.xpath(Utility.fetchLocator("parseInvoiceBtn_XPATH")));
		parseBtn.click();
		Thread.sleep(15000);
		//Assert the first company Name is displayed
		Assert.assertEquals("Google", expectedprojectName);
	//	Validate Company name is displayed
		Assert.assertEquals("Facebook", expectedprojectName2);
		
		//click azure link
		WebElement googlelink = driver.findElement(By.linkText(Utility.fetchLocator("googlelinkText")));
		googlelink.click();
	}

}
