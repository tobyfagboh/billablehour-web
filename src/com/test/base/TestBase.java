package com.test.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.test.utility.Utility;

public class TestBase {
	public WebDriver driver ;
	public String projectPath = System.getProperty("user.dir");

	@BeforeTest
	public void setUp() throws IOException {
		if(Utility.fetchProperty("browserName").toString().equalsIgnoreCase("chrome")) {
			//set property and create instance of chrome browser
			System.setProperty("webdriver.chrome.driver", projectPath+"\\Drivers\\chromedriver.exe");
			driver =new ChromeDriver();
			//System.out.println(browserName + " browser running");
		}
		else if(Utility.fetchProperty("browserName").toString().equalsIgnoreCase("firefox")) {
			//set property and create instance of chrome firefox
			System.setProperty("webdriver.gecko.driver", projectPath+"\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		//	System.out.println(browserName + " browser running");
		}
		else if(Utility.fetchProperty("browserName").toString().equalsIgnoreCase("edge")) {
			//set property and create instance of chrome firefox
			System.setProperty("webdriver.edge.driver", projectPath+"\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		//	System.out.println(browserName + " browser running");
		}
		else if(Utility.fetchProperty("browserName").toString().equalsIgnoreCase("ie")) {
			//set property and create instance of chrome ie
			System.setProperty("webdriver.ie.driver", projectPath+"\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}else {
			System.setProperty("webdriver.chrome.driver", projectPath+"\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.get(Utility.fetchProperty("applicationUrl").toString());
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
	}



	@AfterTest
	public void tearDown() {
		driver.close();
	
	}

}
