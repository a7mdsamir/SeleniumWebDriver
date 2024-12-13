//package workingwithelements;
//
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import static org.testng.Assert.assertTrue;
//
//public class TestExplicitWait
//{
//public WebDriver driver ;
//
//	@BeforeClass
//	public void setUp()
//	{
//		System.setProperty("webdriver.chrome.driver",
//				System.getProperty("user.dir")+"\\Sources\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.navigate().to("http://www.google.com");
//		driver.manage().window().maximize();
//	}
//
//	@Test
//	public void testImplicityWait()
//	{
//		WebElement queryTxt = driver.findElement(By.id("lst-ib"));
//		queryTxt.sendKeys("Selenium WebDriver");
//		queryTxt.submit();
//		WebDriverWait wait = new WebDriverWait(driver, 20) ;
//		wait.until(ExpectedConditions.titleContains("Selenium"));
//		assertTrue(driver.getTitle().toLowerCase().startsWith("selenium"));
//	}
//
//
//	@AfterClass
//	public void tearDown()
//	{
//		driver.quit();
//	}
//
//}
