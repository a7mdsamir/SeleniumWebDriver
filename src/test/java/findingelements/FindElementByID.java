package findingelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementByID 
{

	ChromeDriver driver ; 

	@BeforeTest
	public void opeURL() 
	{
//		System.setProperty("webdriver.chrome.driver",
//				System.getProperty("user.dir")+"\\Sources\\chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.navigate().to("https://the-internet.herokuapp.com/login");
	}

	@Test
	public void findElemenyByID() 
	{
		WebElement usernameTxt = driver.findElement(By.id("username")); 
		WebElement passwordTxt = driver.findElement(By.id("password"));
		System.out.println(usernameTxt.getLocation());
		System.out.println(passwordTxt.getLocation());
	}

	@AfterTest
	public void closeDriver() 
	{
		driver.quit();
	}

}
