package workWzElements;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class TestFileUploadUsingRobot {

    ChromeDriver driver;
    @BeforeTest
    public void openURl(){

        driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/upload");

    }
    @Test
    public void testFileUploadUsingRobot() throws AWTException {
        String imgName = "DSC_0430.jpg";
        String imgPath = System.getProperty("user.dir") + "/Uploads/" + imgName ;
        WebElement fileUploader = driver.findElement(By.id("file-upload"));
        fileUploader.click();

        Robot robot = new Robot();
        // Copy image path OR CTRL+C
        StringSelection selection = new StringSelection(imgPath);
        System.out.println(selection);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, null);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(2000);
        // Paste image path OR CTRL+V
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        WebElement fileSubmit = driver.findElement(By.id("file-submit"));
        fileSubmit.click();

        WebElement uploadedFile = driver.findElement(By.id("uploaded-files"));
        System.out.println(uploadedFile.getText());
        Assert.assertEquals(uploadedFile.getText(), imgName);
        
    }



//    @AfterTest
//    public void closeDriver(){
//        driver.quit();
//    }


}
