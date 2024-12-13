package workWzElements;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TakeScreenshot {

    ChromeDriver driver;
    @BeforeTest
    public void openURl(){

        driver = new ChromeDriver();
        driver.navigate().to("https://www.amazon.eg/");

    }
    @Test
    public void testTakeScreenshot() {

        WebElement search = driver.findElement(By.id("twotabsearchtextboxx"));
        search.sendKeys("selenium");
        search.submit();
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("selenium"));

    }

    @AfterMethod
    public void takeScreenshot(ITestResult result) throws IOException {
        if(ITestResult.FAILURE == result.getStatus()){
            // create reference of take screenshot
            TakesScreenshot ts = (TakesScreenshot) driver ;
            File source = ts.getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(source , new File("./screenshots/ " + result.getName()+".png"));
        }
    }
    @AfterTest
    public void closeDriver(){
        driver.quit();
    }


}
