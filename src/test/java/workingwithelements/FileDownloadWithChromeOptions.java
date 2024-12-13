//package workingwithelements;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.remote.CapabilityType;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.util.HashMap;
//
//public class FileDownloadWithChromeOptions
//{
//	public WebDriver driver ;
//	public static String downloadPath = System.getProperty("user.dir")+"\\Downloads";
//
//	public static ChromeOptions chromeOption()
//	{
//		ChromeOptions options = new ChromeOptions();
//		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
//		chromePrefs.put("profile.default.content_settings.popups", 0);
//		chromePrefs.put("download.default_directory", downloadPath);
//		options.setExperimentalOption("prefs", chromePrefs);
//		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//		return options ;
//	}
//
//	@BeforeClass
//	public void setUp()
//	{
//		System.setProperty("webdriver.chrome.driver",
//				System.getProperty("user.dir")+"\\Sources\\chromedriver.exe");
//		driver = new ChromeDriver(chromeOption());
//		driver.navigate().to("http://the-internet.herokuapp.com/download");
//		driver.manage().window().maximize();
//	}
//
//	@Test
//	public void testDownloadFile() throws InterruptedException
//	{
//		driver.findElement(By.linkText("люблюсики.jpg")).click();
//		Thread.sleep(3000);
//	}
//
//	@AfterClass
//	public void tearDown()
//	{
//		driver.quit();
//	}
//
//}
