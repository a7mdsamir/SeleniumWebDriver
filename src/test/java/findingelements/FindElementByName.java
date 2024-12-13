package findingelements;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementByName {

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
	public void findElemenyByName() 
	{
		try {
			WebElement usernameTxt = driver.findElement(By.name("fa fa-2x fa-sign-in")); 
			WebElement passwordTxt = driver.findElement(By.name("password"));
			System.out.println(usernameTxt.getTagName());
			System.out.println(passwordTxt.getTagName());

		} catch (NoSuchElementException e) {
			System.out.println("The Element is not found please use another attibute");
		}


	}

	@AfterTest
	public void closeDriver() 
	{
		driver.quit();
	}

}
