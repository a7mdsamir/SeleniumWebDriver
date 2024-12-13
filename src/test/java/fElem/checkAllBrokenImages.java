package fElem;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.client.HttpClient;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class checkAllBrokenImages {

    ChromeDriver driver;
    private int invalidImageCount ;
    @BeforeTest
    public void openURl(){

        driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/broken_images");

    }
    @Test
    public void testBrokenImages() {

        invalidImageCount = 0;
        List<WebElement> imgList = driver.findElements(By.tagName("img"));

        for (WebElement img : imgList){
            if (img != null){
                verifyImageActive(img);
            }
        }
        System.out.println("total num of broken imgs is : " + invalidImageCount);

    }

    public void verifyImageActive(WebElement img){
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(img.getAttribute("src"));
        try {
            HttpResponse response = client.execute(request);

            if (response.getStatusLine().getStatusCode() != 200) {
                invalidImageCount++ ;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @AfterTest
    public void closeDriver(){
        driver.quit();
    }


}
