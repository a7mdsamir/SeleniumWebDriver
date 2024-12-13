package fElem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Alert {

    ChromeDriver driver;
    @BeforeTest
    public void openURl(){

        driver = new ChromeDriver();
        driver.navigate().to("https://demo.guru99.com/test/delete_customer.php");

    }
    @Test
    public void testAlert() throws InterruptedException {


//        WebElement submit = driver.findElement(By.name("submit"));
//        submit.click();
        driver.findElement(By.name("submit")).click();
        org.openqa.selenium.Alert alert = driver.switchTo().alert();
//        alert.sendKeys("####");
        String alertTxt = alert.getText();
        System.out.println(alertTxt);
        Assert.assertEquals("Do you really want to delete this Customer?", alertTxt );
        alert.accept();
        Thread.sleep(2000);

        org.openqa.selenium.Alert alert2 = driver.switchTo().alert();
        String alertTxt2 = alert2.getText();
        System.out.println(alertTxt2);
        Assert.assertEquals("Customer Successfully Delete!", alertTxt2 );
        alert2.dismiss();

        //    @AfterTest
//    public void closeDriver(){
//        driver.quit();
//    }

}}
