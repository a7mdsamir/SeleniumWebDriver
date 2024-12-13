package findingelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementByXPath {
	FirefoxDriver driver ; 

	@BeforeTest
	public void opeURL() 
	{
//		System.setProperty("webdriver.gecko.driver",
//				System.getProperty("user.dir")+"\\Sources\\geckodriver.exe");
		driver = new FirefoxDriver(); 
		driver.navigate().to("https://the-internet.herokuapp.com/login");
	}

	@Test(enabled=false)
	public void testFindByAbsoulteXPath() 
	{
		// R click on element >> copy xpath
		WebElement usernameTxt = driver.findElement(By.xpath("//*[@id=\"username\"]"));
		WebElement passwordTxt = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"login\"]/button"));

		WebElement usernameTxt3 = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div/div/input"));
		WebElement password3 = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[2]/div/input"));
		WebElement button = driver.findElement(By.xpath("/html/body/div/div/div/form/button"));


		System.out.println(usernameTxt.getTagName());
		System.out.println(passwordTxt.getTagName());
		System.out.println(loginBtn.getText());

		System.out.println(usernameTxt3.getAttribute("name"));
		System.out.println(password3.getAttribute("name"));
		System.out.println(button.getAttribute("type"));
	}
	
	@Test
	public void testFindByRelativeXPath() 
	{
		WebElement usernameTxt = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement passwordTxt = driver.findElement(By.xpath("//input[@id='password']"));
		WebElement loginBtn = driver.findElement(By.xpath("//button[@class='radius']"));

		WebElement usernameTxt2 = driver.findElement(By.xpath("//input"));
		WebElement passwordTxt2 = driver.findElement(By.xpath("//input[1]"));
		WebElement loginBtn2 = driver.findElement(By.xpath("//button"));



		//System.out.println(usernameTxt.getTagName());
		System.out.println(passwordTxt.getTagName());
		System.out.println(loginBtn.getText());

		System.out.println(passwordTxt2.getTagName());
		System.out.println(loginBtn2.getText());
	}
	
	
	@AfterTest
	public void closeDriver() 
	{
		driver.quit();
	}
	
}
