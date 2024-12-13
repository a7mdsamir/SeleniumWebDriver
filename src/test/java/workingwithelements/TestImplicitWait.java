package workingwithelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class TestImplicitWait 
{
public WebDriver driver ; 
	
	@BeforeClass
	public void setUp() 
	{
//		System.setProperty("webdriver.chrome.driver",
//				System.getProperty("user.dir")+"\\Sources\\chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.navigate().to("http://cookbook.seleniumacademy.com/AjaxDemo.html");
		driver.manage().window().maximize();
	}
	
	@Test
	public void testImplicityWait() 
	{
		// set the implicit wait time to 20 Seconds
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
		driver.findElement(By.linkText("Page 4")).click();
		WebElement message = driver.findElement(By.id("page4")); 
		assertTrue(message.getText().contains("Nunc nibh tortor"));
	}
	
	
	@AfterClass
	public void tearDown() 
	{
		driver.quit();
	}

}
