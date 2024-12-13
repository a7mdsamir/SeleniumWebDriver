package workWzElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TextBoxAndButtonsAndSubmitMethod {

    ChromeDriver driver;
    @BeforeTest
    public void openURl(){

        driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/login");

    }
    @Test
    public void buttonAndTextBox(){


        WebElement username = driver.findElement(By.id("username"));
        WebElement passwordTxt = driver.findElement(By.id("password"));
        WebElement login = driver.findElement(By.tagName("button"));

        username.sendKeys("tomsmith");
        passwordTxt.sendKeys("SuperSecretPassword!");
        login.click();
        Assert.assertEquals("https://the-internet.herokuapp.com/secure", driver.getCurrentUrl());
        WebElement label = driver.findElement(By.id("flash"));
        System.out.println(label.getText());
        Assert.assertTrue(label.getText().contains("You logged into a secure area!"));
        WebElement logOut = driver.findElement(By.xpath("/html/body/div[2]/div/div/a"));
        System.out.println(logOut.getText());

        driver.navigate().to("https://www.google.com/");
        WebElement search = driver.findElement(By.id("APjFqb"));
        search.sendKeys("sedf");
        search.submit();

//        driver.navigate().to("https://the-internet.herokuapp.com/");
//        System.out.println(driver.getCurrentUrl());
//        driver.navigate().back();
//        System.out.println(driver.getCurrentUrl());
//        driver.navigate().forward();
//        System.out.println(driver.getCurrentUrl());
//        driver.navigate().refresh();
//        System.out.println(driver.getCurrentUrl());
//        linkSelenium.click();
//        System.out.println(links.size());
//        Assert.assertEquals(46, links.size());
//
//        for (WebElement link : links){
//            System.out.println(link.getAttribute("href"));
//        }

    }
//    @AfterTest
//    public void closeDriver(){
//        driver.quit();
//    }

}
