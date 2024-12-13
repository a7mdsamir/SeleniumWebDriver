package com.google;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGDemo2 {

	ChromeDriver driver;
	
	@BeforeTest(groups= {"regression"})
	public void openURL() 
	{
//		String chromePath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
//		System.setProperty("webdriver.chrome.driver",chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("http://www.google.com");
	}

	@Test(groups= {"regression"})
	public void userCanLogin() 
	{

		System.out.println(driver.getCurrentUrl());
	}

	@Test(groups= {"regression"})
	public void userCanBuyFromWebSite() 
	{

		System.out.println(driver.getTitle());
	}
	
	@Test(groups= {"live"})
	public void userCanUseCreditCard() 
	{

		System.out.println(driver.getTitle());
	}

	@AfterTest(groups= {"regression"})
	public void closeWebsite() 
	{

		driver.quit();
	}

}
