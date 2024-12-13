package com.google;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionDemo {
	ChromeDriver driver;

	@Test
	public void getTitle() 
	{
//		String chromePath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
//		System.setProperty("webdriver.chrome.driver",chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("http://www.google.com");
		String title = driver.getTitle();
		Assert.assertEquals(title, "Google");
		driver.quit();
	}

}
