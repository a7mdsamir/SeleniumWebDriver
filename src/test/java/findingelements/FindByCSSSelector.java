package findingelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindByCSSSelector {

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
	public void testFindByCSSSelector() 
	{
		WebElement headerLbl = driver.findElement(By.cssSelector("h2"));
		WebElement usernameTxt = driver.findElement(By.cssSelector("input#username"));
		WebElement passwordTxt = driver.findElement(By.cssSelector("input#password"));
		WebElement LoginBtn = driver.findElement(By.cssSelector("button.radius"));
		System.out.println(LoginBtn.getText());
		System.out.println(usernameTxt.getTagName());
		System.out.println(passwordTxt.getTagName());
		System.out.println(headerLbl.getText());
	}
	
	@AfterTest
	public void closeDriver() 
	{
		driver.quit();
	}
	
}
