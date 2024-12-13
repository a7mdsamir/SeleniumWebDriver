package workWzElements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JavaScriptCallsAndScroll {

    ChromeDriver driver;
    @BeforeTest
    public void openURl(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com");

    }
    @Test
    public void testJavaScript() throws InterruptedException {

        JavascriptExecutor js = driver;
        String title = (String) js.executeScript("return document.title");
        Assert.assertEquals(title, "Google");
        System.out.println(title);

        long links = (Long) js
                .executeScript("var links = document.getElementsByTagName('A'); return links.length");
        System.out.println(links);
        Assert.assertEquals(links, 17);

        driver.navigate().to("https://www.amazon.eg/");
        js.executeScript("scrollBy(0,3000)");
        Thread.sleep(4000);

        WebElement footerLogo = driver.findElement(By.cssSelector("div.nav-logo-base.nav-sprite"));
        Assert.assertTrue(footerLogo.isDisplayed());

        //    @AfterTest
//    public void closeDriver(){
//        driver.quit();
//    }

}}
