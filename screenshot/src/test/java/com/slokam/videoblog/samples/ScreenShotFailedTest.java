package com.slokam.videoblog.samples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.slokam.videoblog.commons.listeners.CustomListener;
@Listeners(value=CustomListener.class)
public class ScreenShotFailedTest {
	private static WebDriver driver = null;

	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.gecko.driver", "./src/test/resources/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("http://demo.shopizer.com:8080/admin/");
	}

	@Test
	public void verifyLoginTest() {
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.id("formSubmitButton")).click();
		String error = driver.findElement(By.cssSelector(".alert-error")).getText();
		System.out.println(error);

		Assert.assertEquals(error, "Invalid username or password");
		//Assert.assertEquals(error, "Invalid username or password");
		
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public static WebDriver getDriverInstance() {
		return driver;
	}
	
}
