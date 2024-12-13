package findingelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementByTagName {

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
	public void testFindByTageName() 
	{
		WebElement loginBtn = driver.findElement(By.tagName("button"));
		loginBtn.click();
	}
	
//	@AfterTest
//	public void closeDriver()
//	{
//		driver.quit();
//	}
	
}
