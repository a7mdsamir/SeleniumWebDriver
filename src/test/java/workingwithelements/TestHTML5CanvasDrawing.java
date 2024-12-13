package workingwithelements;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

public class TestHTML5CanvasDrawing 
{
	private WebDriver driver;

	@BeforeClass
	public void setUp() {
//		System.setProperty("webdriver.gecko.driver",
//				System.getProperty("user.dir")+"\\Sources\\geckodriver.exe");
		driver = new ChromeDriver();
		driver.get("http://cookbook.seleniumacademy.com/html5canvasdraw.html");
	}

	@Test
	public void testHTML5CanvasDrawing() throws Exception {
		// Get the HTML5 Canvas Element
		WebElement canvas = driver.findElement(By.id("imageTemp"));

		// Select the Pencil Tool
		Select drawTools = new Select(driver.findElement(By.id("dtool")));
		drawTools.selectByValue("pencil");

		// Create a Action chain to draw a shape on Canvas
		Actions builder = new Actions(driver);
		builder.clickAndHold(canvas).moveByOffset(10, 50).moveByOffset(50, 10)
		.moveByOffset(-10, -50).moveByOffset(-50, -10).release()
		.perform();

		// Get a screenshot of Canvas element after drawing and compare it to
		// the base version
		// Take a screenshot for later verification
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("./Screenshots/canvas.png"));		
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
