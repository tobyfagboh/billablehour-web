package loopmi;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LaunchApp {
WebDriver driver;

@BeforeTest
public void setUp() throws Exception {
	DesiredCapabilities cap = new DesiredCapabilities();
	cap.setCapability("deviceName", "Galaxy A10)");
	cap.setCapability("udid", "RF8M33Q2CTE");
	cap.setCapability("platformName", "Android");
	cap.setCapability("platformVersion", "9");
	
	cap.setCapability("appPackage", "org.antwire.loopmi");
	cap.setCapability("appActivity", "org.loopmi.MainActivity");
	//URl url = new URL("");
	driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}
	
@Test
public void invaidLogin() throws InterruptedException {
	WebElement email = driver.findElement(By.xpath("//android.widget.EditText[@text='Email Address']"));
	email.sendKeys("ghensky.oje@gmail.com");
	WebElement passwordField = driver.findElement(By.xpath("//android.widget.EditText[@text='Password']"));
	passwordField.sendKeys("password1");
	WebElement loginBtn = driver.findElement(By.xpath("//android.widget.Button[@text='LOGIN']"));
	loginBtn.click();
	Thread.sleep(4000);
	WebElement okBtn = driver.findElement(By.xpath("//android.widget.Button[@text='OK']"));
	okBtn.click();
	System.out.println("Invalid login executed successfully");
}
@Test
public void validLogin() throws InterruptedException {
	WebElement emailField =  driver.findElement(By.xpath("//android.widget.EditText[@text='ghensky.oje@gmail.com']"));
	emailField.sendKeys(Keys.ENTER);
	emailField.clear();
	emailField.sendKeys("ghensky.oje@gmail.com");
	
	WebElement passwordField = driver.findElement(By.xpath("//android.widget.EditText[@text='••••••••']"));
	passwordField.sendKeys(Keys.ENTER);
	passwordField.clear();
	passwordField.sendKeys("password");
	
	WebElement loginBtn = driver.findElement(By.xpath("//android.widget.Button[@text='LOGIN']"));
	loginBtn.click();
	Thread.sleep(4000);
	
	System.out.println("valid login executed successfully");
	
}
@AfterTest
public void closeApp() {
	driver.quit();
	System.out.println("test completed successfully");
}
}
