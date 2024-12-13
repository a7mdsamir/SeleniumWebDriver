package workWzElements;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class TestCookies {

    ChromeDriver driver;
    @BeforeTest
    public void openURl(){

        driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/dropdown");

    }
    @Test
    public void testCookies() throws InterruptedException {

        WebElement optionList = driver.findElement(By.id("dropdown"));
        Select selectOptions = new Select(optionList);

        Assert.assertEquals(selectOptions.getFirstSelectedOption().getText(), "Please select an option");

        Cookie storeCookie = driver.manage().getCookieNamed("store");
        Assert.assertEquals(storeCookie, null);
        selectOptions.selectByVisibleText("Option 2");
        Thread.sleep(2000);
        storeCookie = driver.manage().getCookieNamed("store");
//        Assert.assertEquals(null, storeCookie.getValue());
//        System.out.println(storeCookie.getValue());

        // Get all cookies
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println(" num of cookies " + cookies.size());
        Iterator<Cookie> itr = cookies.iterator();
        while (itr.hasNext()) {
            Cookie cookie = itr.next();
            System.out.println(cookie.getDomain());
            System.out.println(cookie.getName());
            System.out.println(cookie.getPath());
            System.out.println(cookie.getValue());
        }

    }

    @ AfterTest
    public void closeDriver(){
        driver.quit();
    }

}
