package workingwithelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DownloadFileWithFireFoxOptions
{
	public WebDriver driver ;
	public static String downloadPath = System.getProperty("user.dir")+"\\Downloads";

	public static FirefoxOptions firefoxOption()
	{
		FirefoxOptions option = new FirefoxOptions();
		option.addPreference("browser.download.folderList", 2);
		option.addPreference("browser.download.dir", downloadPath);
		option.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");

		option.addPreference("browser.download.manager.showWhenStarting", false);
		return option;
	}

	@BeforeClass
	public void setUp()
	{
//		System.setProperty("webdriver.gecko.driver",
//				System.getProperty("user.dir")+"\\Sources\\geckodriver.exe");
		driver = new FirefoxDriver(firefoxOption());
		driver.navigate().to("http://the-internet.herokuapp.com/download");
		driver.manage().window().maximize();
	}

	@Test
	public void TestDownloadFile() throws InterruptedException
	{
		driver.findElement(By.linkText("some-file.txt")).click();
		Thread.sleep(3000);
	}


	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}
