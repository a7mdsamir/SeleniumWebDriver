package findingelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class FindElementInTableByTagName {
	ChromeDriver driver ; 

	@BeforeTest
	public void opeURL() 
	{
//		System.setProperty("webdriver.chrome.driver",
//				System.getProperty("user.dir")+"\\Sources\\chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.navigate().to("https://the-internet.herokuapp.com/tables");
	}

	@Test
	public void testFindByTageName() 
	{
		WebElement table = driver.findElement(By.id("table1"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		// 5
		System.out.println(rows.size());
		// get 3rd row , while rows saved in list starts with 0 , but is not sequential
		System.out.println(rows.get(2).getText());
		// assert return true
		System.out.println(rows.get(2).getText().contains("bac"));

	}
	
	@AfterTest
	public void closeDriver() 
	{
		driver.quit();
	}
	
}
