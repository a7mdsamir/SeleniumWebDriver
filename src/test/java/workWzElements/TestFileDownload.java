package workWzElements;


import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.util.HashMap;

public class TestFileDownload {

    ChromeDriver driver;
    public static String downloadPath = System.getProperty("user.dir")+"\\Downloads";

    public static ChromeOptions chromeOptions()
    {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default.content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadPath);
//        chromePrefs.put("download.prompt_for_download", false);

        options.setExperimentalOption("prefs", chromePrefs);
//		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        options.setAcceptInsecureCerts(true);
        return options ;
    }
    @BeforeTest
    public void openURl(){

        driver = new ChromeDriver(chromeOptions());
        driver.navigate().to("http://the-internet.herokuapp.com/download");
        driver.manage().window().maximize();

    }
    @Test
    public void testFileDownload() throws InterruptedException {

        driver.findElement(By.linkText("some-file.txt")).click();
        Thread.sleep(3000);

    }



//    @AfterTest
//    public void closeDriver(){
//        driver.quit();
//    }


}
