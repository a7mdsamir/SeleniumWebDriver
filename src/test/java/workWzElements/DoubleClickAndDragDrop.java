package workWzElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DoubleClickAndDragDrop {

    ChromeDriver driver;
    @BeforeTest
    public void openURl(){

        driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/dropdown");

    }
    @Test
    public void testDoubleClickAndDragDrop() throws InterruptedException {

        WebElement optionList = driver.findElement(By.id("dropdown"));

        // Verify color
        System.out.println(optionList.getCssValue("background-color"));
        Assert.assertEquals("rgba(255, 255, 255, 1)", optionList.getCssValue("background-color"));

        Actions builder = new Actions(driver);
        builder.doubleClick(optionList).perform();
        System.out.println(optionList.getCssValue("background-color"));

        Thread.sleep(2000);
        driver.navigate().to("https://the-internet.herokuapp.com/drag_and_drop");
        WebElement colA = driver.findElement(By.id("column-a"));
        WebElement colB = driver.findElement(By.id("column-b"));
//        Actions builder = new Actions(driver);
        builder.dragAndDrop(colA, colB).perform();
        Assert.assertEquals("B", colA.getText());


//    @AfterTest
//    public void closeDriver(){
//        driver.quit();
//    }

}}
