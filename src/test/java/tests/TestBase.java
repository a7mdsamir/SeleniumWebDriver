package tests;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;

import java.time.Duration;

public class TestBase extends AbstractTestNGCucumberTests{
    public static WebDriver driver;

    @BeforeSuite
    @Parameters({"browser"})
    public void startDriver(@Optional("chrome") String browserName)  {
        if (browserName.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
            options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36");
            options.addArguments("--incognito");
            options.addArguments("--headless");
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            options.setExperimentalOption("useAutomationExtension", false);
            String proxy = "77.37.41.168:80"; // Example: "123.45.67.89:8080"
            options.addArguments("--proxy-server=" + proxy);

//            options = webdriver.ChromeOptions() ;
//            options.addArguments("--disable-javascript");
//            options = webdriver.ChromeOptions();
//
//            driver = webdriver.Chrome(options=options);
            // Add argument to disable JavaScript
            options.addArguments("--disable-javascript");
            options.addArguments("--disable-blink-features=AutomationControlled") ;
            options.addArguments("--start-maximized");
            // Initialize WebDriver with the options
            WebDriver driver = new ChromeDriver(options);

        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        else {
            System.out.println("Unsupported browser: " + browserName);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
        driver.navigate().to("https://demo.nopcommerce.com/");

    }

//    @AfterSuite
//    public void stopDriver(){
//        driver.quit();
//    }

    // take screenshot on failure
    @AfterMethod
    public void screenshotOnFailure(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE){
            System.out.println("Failed, taking screenshot ...");
            Helper.captureScreenshot(driver, result.getName());
        }
    }
}
