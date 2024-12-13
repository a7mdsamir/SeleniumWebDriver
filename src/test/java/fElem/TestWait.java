package fElem;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;


public class TestWait {

    ChromeDriver driver;
    @BeforeTest
    public void openURl(){

        driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/dropdown");

    }
    @Test
    public void testWait() {

        // Implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement optionList = driver.findElement(By.id("dropdown"));
        Select selectOptions = new Select(optionList);
        selectOptions.selectByVisibleText("Option 2");

        // Explicit
        driver.get("https://www.google.com/");
        WebElement query = driver.findElement(By.id("APjFqb"));
        query.sendKeys("selenium");
        query.submit();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.titleContains("selenium"));
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().toLowerCase().startsWith("selenium"));

        // Fluent
        driver.get("https://www.google.com/");
        WebElement query2 = driver.findElement(By.id("APjFqb"));

        query2.sendKeys("selenium");
        query2.submit();
//        WebDriver driver = new ChromeDriver();
        FluentWait<ChromeDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))  // Correct way to specify timeout
                .pollingEvery(Duration.ofSeconds(2))  // Correct way to specify polling interval
                .ignoring(Exception.class);
        WebElement searchBox = fluentWait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return webDriver.findElement(By.id("APjFqb"));
            }
        });
        System.out.println(searchBox.getText());
        Assert.assertTrue(searchBox.getText().contains("selenium"));
    }


//    @ AfterTest
//    public void closeDriver(){
//        driver.quit();
//    }

}
