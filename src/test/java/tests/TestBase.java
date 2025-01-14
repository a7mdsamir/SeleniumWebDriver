package tests;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;

import java.time.Duration;

public class TestBase extends AbstractTestNGCucumberTests {
    public static WebDriver driver;

    @BeforeSuite
    @Parameters({"browser"})
    public void startDriver(@Optional("chrome") String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
            options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36");
            options.addArguments("--incognito");
            options.addArguments("--headless");
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            options.setExperimentalOption("useAutomationExtension", false);
            options.addArguments("--proxy-server=77.37.41.168:80"); // Example proxy
            options.addArguments("--disable-javascript");
            options.addArguments("--disable-blink-features=AutomationControlled");
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
//            options = webdriver.ChromeOptions() ;
//            options.addArguments("--disable-javascript");
//            options = webdriver.ChromeOptions();
//
//            driver = webdriver.Chrome(options=options);
            // Add argument to disable JavaScript
            options.addArguments("--disable-javascript");
            options.addArguments("--disable-blink-features=AutomationControlled");
            options.addArguments("--start-maximized");
            // Initialize WebDriver with the options
            WebDriver driver = new ChromeDriver(options);

        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        else if (browserName.equalsIgnoreCase("headless")) {
//            DesiredCapabilities caps = new DesiredCapabilities();
//            caps.setJavascriptEnabled(true);
//            String[] phantomJsArgs = {"--web-security=no","--ignore-ssl--errors=yes"};
//            caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS , phantomJsArgs);
//
//            driver = new PhantomJSDriver(caps);

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");
            driver = new ChromeDriver(options);
        }
        else if (browserName.equalsIgnoreCase("headless2")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");

            driver = new FirefoxDriver(options);
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
//    if (driver != null){
//        driver.quit();
//    }
//    }

    // take screenshot on failure
    @AfterMethod
    public void screenshotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Failed, taking screenshot ...");
            Helper.captureScreenshot(driver, result.getName());
        }
    }
}
