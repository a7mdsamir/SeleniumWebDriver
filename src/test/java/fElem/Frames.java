package fElem;


import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Frames {

    ChromeDriver driver;
    @BeforeTest
    public void openURl(){

        driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/nested_frames");

    }
    @Test
    public void testFrames()  {

        // Switch to frame by nameOrId
        driver.switchTo().frame("frame-bottom");

//        WebElement msg = driver.findElement(By.tagName("BOTTOM"));
//        Assert.assertEquals("BOTTOM", msg.getText());

        driver.switchTo().defaultContent();

        //driver.switchTo().frame("frame-top");
        // Switch to frame by index
        driver.switchTo().frame(1);


        //    @AfterTest
//    public void closeDriver(){
//        driver.quit();
//    }

}}
