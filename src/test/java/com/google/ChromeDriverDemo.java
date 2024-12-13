package com.google;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ChromeDriverDemo {
    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver() ;
        driver.navigate().to("http://www.google.com");

        FirefoxDriver driver1 = new FirefoxDriver() ;
        driver1.navigate().to("http://www.amazon.de");
        driver.quit();
        // to get the path of your proj
        //System.out.println(System.getProperty("user.dir" ));
    }
}
