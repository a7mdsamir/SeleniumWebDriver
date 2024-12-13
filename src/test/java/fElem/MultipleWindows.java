package fElem;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MultipleWindows {

    ChromeDriver driver;
    @BeforeTest
    public void openURl(){

        driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/windows");
    }
    @Test
    public void testMultipleWindows() throws InterruptedException {

        String currentWinID= driver.getWindowHandle();
        driver.findElement(By.linkText("Click Here")).click();

        for (String winID : driver.getWindowHandles()){
            String title = driver.switchTo().window(winID).getTitle();
            if (title.equals("New Window")){
                Assert.assertEquals("New Window" , driver.getTitle());
                System.out.println(driver.getTitle());
                driver.close();
                break;
            }
        }
        driver.switchTo().window(currentWinID);
    }

    @Test
    public void testWindowsUsingName() {

        String currentWinIDf= driver.getWindowHandle();
        driver.findElement(By.linkText("Click Here")).click();

            driver.switchTo().window(driver.getWindowHandle());
            System.out.println(driver.getTitle());
            driver.close();

//            driver.switchTo().window(currentWinIDf);

        }



        //    @AfterTest
//    public void closeDriver(){
//        driver.quit();
//    }

}
