package workingwithelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestMultipleWindows {

	public WebDriver driver ; 

	@BeforeClass
	public void setUp() 
	{
		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"\\Sources\\chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.navigate().to("http://cookbook.seleniumacademy.com/Config.html");
		driver.manage().window().maximize();
	}

	@Test
	public void testWindowUsingTitle() 
	{
		// Store WindowHandle of parent window
		String currentWindowID = driver.getWindowHandle();
		driver.findElement(By.id("visitbutton")).click();
		for(String windowID : driver.getWindowHandles())
		{
			String title = driver.switchTo().window(windowID).getTitle(); 
			if(title.equals("Visit Us")) 
			{
				assertEquals(driver.getTitle(), "Visit Us");
				// write any code to handle elements in visit us page
				System.out.println(driver.getTitle());
				driver.close();
				break;
			}
		}
		driver.switchTo().window(currentWindowID); 
	}


	@Test
	public void testWindowUsingName()
	{
		// Store WindowHandle of parent window
		String currentWindowID = driver.getWindowHandle();
		driver.findElement(By.id("helpbutton")).click();
		driver.switchTo().window("HelpWindow");
		assertEquals(driver.getTitle(), "Help");
		System.out.println(driver.getTitle());
		// code inside Help windows 
		driver.close();
		driver.switchTo().window(currentWindowID);

	}


	@AfterClass
	public void tearDown() 
	{
		driver.quit();
	}
}
