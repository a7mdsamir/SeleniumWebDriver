package tests;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase{

    HomePage homePage ;
    UserRegistrationPage userRegistrationPage ;
    LoginPage loginPage ;

    @Test (priority = 1, alwaysRun = true)
    public void userCanRegisterSuccessfully(){
        homePage = new HomePage(driver);
        homePage.openRegistrationPage();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36");
        options.addArguments("--incognito");
        options.addArguments("--headless");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        String proxy = "77.37.41.168:80"; // Example: "123.45.67.89:8080"
        options.addArguments("--proxy-server=" + proxy);

//            options = webdriver.ChromeOptions() ;
        // Add argument to disable JavaScript
        options.addArguments("--disable-javascript");
//            options = webdriver.ChromeOptions();
//            driver = webdriver.Chrome(options=options)
        // Initialize WebDriver with the options

        userRegistrationPage = new UserRegistrationPage(driver);
        userRegistrationPage.userRegistration("Ahmed", "Samir", "test6@gmail.com", "Aa123456@");

        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36");
        options.addArguments("--incognito");
        options.addArguments("--headless");
//        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
//        options.setExperimentalOption("useAutomationExtension", false);
//        String proxy = "77.37.41.168:80"; // Example: "123.45.67.89:8080"
        options.addArguments("--proxy-server=" + proxy);

//            options = webdriver.ChromeOptions() ;
        // Add argument to disable JavaScript
        options.addArguments("--disable-javascript");
//            options = webdriver.ChromeOptions();
//            driver = webdriver.Chrome(options=options)

    options.addArguments("--disable-blink-features=AutomationControlled") ;
    options.addArguments("--start-maximized");
        Assert.assertTrue(userRegistrationPage.successMessage.getText().contains("Your registration completed"));

        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36");
        options.addArguments("--incognito");
        options.addArguments("--headless");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
//        String proxy = "77.37.41.168:80"; // Example: "123.45.67.89:8080"
        options.addArguments("--proxy-server=" + proxy);

//            options = webdriver.ChromeOptions() ;
        // Add argument to disable JavaScript
        options.addArguments("--disable-javascript");
//            options = webdriver.ChromeOptions();
//            driver = webdriver.Chrome(options=options)
    }

    @Test (dependsOnMethods = "userCanRegisterSuccessfully")
    public void registeredUserCanLogoutSuccessfully(){
        userRegistrationPage.userLogout();
    }

    @Test (dependsOnMethods = "registeredUserCanLogoutSuccessfully")
    public void registeredUserCanLoginSuccessfully(){
        homePage.openLoginPage();
        loginPage = new LoginPage(driver);
        loginPage.userLogin("test6@gmail.com", "Aa123456@");
        Assert.assertTrue(userRegistrationPage.logoutLink.isDisplayed());
        Assert.assertTrue(userRegistrationPage.logoutLink.getText().contains("Log out"));
    }



}
