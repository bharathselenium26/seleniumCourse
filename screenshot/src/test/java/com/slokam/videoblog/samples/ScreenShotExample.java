package com.slokam.videoblog.samples;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class ScreenShotExample {

	public String url ="http://demo.shopizer.com:8080/admin/";
	public String username = "admin";
	public String password = "admin123";
	
	WebDriver driver;
	@Test
	public void verifyLoginTest() {
		
		System.setProperty("webdriver.gecko.driver", "./src/test/resources/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait( 40,TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("formSubmitButton")).click();
		
		String error = driver.findElement(By.cssSelector(".alert-error")).getText();
		System.out.println(error);
		
		//Screenshot
		
		 File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		File destination = new File("verifyLoginTest_"+getTimestamp()+".jpeg");
		
		try {
			Files.copy(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
	
	public String getTimestamp() {
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
		return timeStamp;
	}
}
