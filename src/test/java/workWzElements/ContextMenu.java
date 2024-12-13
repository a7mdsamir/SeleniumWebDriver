package workWzElements;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ContextMenu {

    ChromeDriver driver;
    @BeforeTest
    public void openURl(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://swisnl.github.io/jQuery-contextMenu/demo/accesskeys.html");

    }
    @Test
    public void testContextMenu() throws InterruptedException {


        WebElement rightClickBtn = driver.findElement(By.cssSelector("span.context-menu-one.btn.btn-neutral"));
        WebElement contextMenu = driver.findElement(By.cssSelector("li.context-menu-item.context-menu-icon.context-menu-icon-edit"));

        Actions builder = new Actions(driver);
        builder.contextClick(rightClickBtn).
                moveToElement(contextMenu).click().perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alert = driver.switchTo().alert();
        wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(alert.getText());
        Assert.assertEquals(alert.getText(), "clicked: edit");

        alert.dismiss();
        Thread.sleep(2000);



        //    @AfterTest
//    public void closeDriver(){
//        driver.quit();
//    }

}}
