//package workingwithelements;
//
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import static org.testng.Assert.assertEquals;
//
//public class TestContextMenu {
//	public WebDriver driver ;
//
//	@BeforeClass
//	public void setUp()
//	{
//		System.setProperty("webdriver.chrome.driver",
//				System.getProperty("user.dir")+"\\Sources\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.navigate().to("http://swisnl.github.io/jQuery-contextMenu/demo/accesskeys.html");
//		driver.manage().window().maximize();
//	}
//
//	@Test
//	public void testContextMenu() throws InterruptedException
//	{
//		WebElement ClickMeBtn =
//				driver.findElement(By.cssSelector("span.context-menu-one.btn.btn-neutral"));
//		WebElement contextMenu =
//				driver.findElement
//				(By.cssSelector("li.context-menu-item.context-menu-icon.context-menu-icon-edit"));
//
//		Actions builder = new Actions(driver);
//		builder
//		.contextClick(ClickMeBtn)
//		.moveToElement(contextMenu)
//		.click()
//		.perform();
//
//		Thread.sleep(3000);
//
//		WebDriverWait wait = new WebDriverWait(driver, 20);
//		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//		assertEquals("clicked: edit", alert.getText());
//		alert.dismiss();
//	}
//
//	@AfterClass
//	public void tearDown()
//	{
//		driver.quit();
//	}
//
//}
