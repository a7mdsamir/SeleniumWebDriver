package workWzElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Table {

    ChromeDriver driver;
    @BeforeTest
    public void openURl(){

        driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/tables");

    }
    @Test
    public void testTable() throws InterruptedException {

        WebElement table = driver.findElement(By.id("table1"));
        // get all rows
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        Assert.assertEquals(rows.size(), 5);


        for (WebElement row : rows ) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            for (WebElement col : cols ) {
                System.out.println(col.getText());
            }
            System.out.println();
        }

//    @AfterTest
//    public void closeDriver(){
//        driver.quit();
//    }

}}
