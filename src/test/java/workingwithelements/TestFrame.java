package workingwithelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestFrame 
{
	public WebDriver driver ; 
	
	@BeforeClass
	public void setUp() 
	{
		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"\\Sources\\chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.navigate().to("http://cookbook.seleniumacademy.com/Frames.html");
		driver.manage().window().maximize();
	}
	
	@Test
	public void testFrameWithIdOrName() 
	{
		driver.switchTo().frame("left"); 
		WebElement msg = driver.findElement(By.tagName("p")); 
		Assert.assertEquals(msg.getText(), "This is Left Frame");
		System.out.println(msg.getText());
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("right");
		WebElement msg2 = driver.findElement(By.tagName("p"));
		Assert.assertEquals(msg2.getText(), "This is Right Frame");
		System.out.println(msg2.getText());
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(1); 
		WebElement msg3 = driver.findElement(By.tagName("p")); 
		Assert.assertEquals(msg3.getText(), "This Frame doesn't have id or name");
		System.out.println(msg3.getText());
		
		driver.switchTo().defaultContent();
		
	}

	@AfterClass
	public void tearDown() 
	{
		driver.quit();
	}
	
}
