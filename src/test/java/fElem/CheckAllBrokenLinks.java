package fElem;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class CheckAllBrokenLinks {

    ChromeDriver driver;
    private int invalidImageCount ;
    @BeforeTest
    public void openURl(){

        driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/");

    }
    @Test
    public void testBrokenlinks() {

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("total links are : " + links.size());
        for (int i = 0; i < links.size() ; i++){
            WebElement element = links.get(i);
            String url = element.getAttribute("href");
            verifyLinks(url);
        }
    }

    public static void verifyLinks(String urlLink){
        try {
            URL link = new URL(urlLink);
            // create a connection using URL object
            HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
            httpConn.setConnectTimeout(20000);
            httpConn.connect();

            // use getResponseCode() to get response code
            if (httpConn.getResponseCode() == 200){
                System.out.println(urlLink + " - "+httpConn.getResponseMessage());
            }
            if (httpConn.getResponseCode() == 400){
                System.out.println(urlLink + " - "+httpConn.getResponseMessage());
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @AfterTest
    public void closeDriver(){
        driver.quit();
    }


}
