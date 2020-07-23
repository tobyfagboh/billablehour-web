package com.test.dataSupplier;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class CustomerLogin{
	@DataProvider(name = "customerLogin")
	public static Object[][] customerLogin() throws Exception {
		
		FileInputStream file = new FileInputStream("./TestData/customerSignIn.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(file);
		XSSFSheet loginSheet = book.getSheet("customer");
		int numberOfData = loginSheet.getPhysicalNumberOfRows();
		Object [][] testData = new Object[numberOfData][2];
		
		for (int i =0; i<numberOfData;i++ ) {
			XSSFRow row = loginSheet.getRow(i);
			XSSFCell email = row.getCell(0);
			XSSFCell password = row.getCell(1);
			testData[i][0] = email.getStringCellValue();
			testData[i][1] = password.getStringCellValue();
					
		}
		return testData;
	}

}
