package workingwithelements;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

public class TestHTML5VideoPlayer 
{
	private WebDriver driver;

	@BeforeClass
	public void setUp() {
//		System.setProperty("webdriver.gecko.driver",
//				System.getProperty("user.dir")+"\\Sources\\geckodriver.exe");
		driver = new ChromeDriver();
		driver.get("https://videojs.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void testHTML5VideoPlayer() throws Exception {
		// Get the HTML5 Video Element
		WebElement videoPlayer = driver.findElement(By.id("vjs_video_3_html5_api"));

		// We will need a JavaScript Executor for interacting with Video
		// Element's methods and properties for automation
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		// Get the Source of Video that will be played in Video Player
		String source = (String) jsExecutor.executeScript(
				"return arguments[0].currentSrc;", videoPlayer);

		// Get the Duration of Video
//		long duration = (Long) jsExecutor.executeScript(
//				"return arguments[0].duration", videoPlayer);
		double duration = (Double) jsExecutor.executeScript("return arguments[0].duration", videoPlayer);

		System.out.println("Video duration: " + duration + " seconds");


		// Verify Correct Video is loaded and duration
		System.out.println("Video source: " + source);

		// Play the Video
		jsExecutor.executeScript("arguments[0].play()", videoPlayer);

		Thread.sleep(5000);

		// Pause the video
		jsExecutor.executeScript("arguments[0].pause()", videoPlayer);

		// Take a screenshot for later verification
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("./Screenshots/pause_play2.png"));
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}

