package fElem;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;

public class TestFileUpload {

    ChromeDriver driver;
    @BeforeTest
    public void openURl(){

        driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/upload");

    }
    @Test
    public void testFileUpload() throws AWTException {
        String imgName = "DSC_0430.jpg";
        String imgPath = System.getProperty("user.dir") + "/Uploads/" + imgName ;

        WebElement fileUploader = driver.findElement(By.id("file-upload"));
        // fileUploader element has (type="file") as attribute
        fileUploader.sendKeys(imgPath);
        WebElement fileSubmit = driver.findElement(By.id("file-submit"));
        fileSubmit.click();

        WebElement uploadedFile = driver.findElement(By.id("uploaded-files"));
        System.out.println(uploadedFile.getText());
        Assert.assertEquals(imgName , uploadedFile.getText());
        
    }



//    @AfterTest
//    public void closeDriver(){
//        driver.quit();
//    }


}
