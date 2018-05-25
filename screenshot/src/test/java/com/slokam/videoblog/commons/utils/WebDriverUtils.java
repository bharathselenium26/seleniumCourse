package com.slokam.videoblog.commons.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class WebDriverUtils {

	
	public static void takesScreenshot(WebDriver driver,String testcaseName) {
		// Taking screenshot
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String fileName = testcaseName+ "_" + AutomationUtils.getTimestamp() + ".jpeg";
		File destination = new File(fileName);
		try {
			Files.copy(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
