package com.google;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestngDemo {

    ChromeDriver driver ;
    @BeforeTest
    public void openURL()
    {
        driver = new ChromeDriver();
        driver.navigate().to("http://www.google.com");
        System.out.println("opening browser");

    }

    @Test(priority=0,alwaysRun=true,enabled=true)
    public void userCanLogin()
    {
        System.out.println(driver.getCurrentUrl());
        //fail("Throw excpetion");
    }

    @Test(priority=1,dependsOnMethods= {"userCanLogin"})
    public void userCanBuyFromWebSite()
    {
        System.out.println(driver.getTitle());
    }

    @Test(enabled=false)
    public void userRegistration()
    {
        System.out.println("Disabled Method");
    }

    @AfterTest
    public void closeWebsite()
    {
        driver.quit();
        System.out.println("closing browser");

    }




}
