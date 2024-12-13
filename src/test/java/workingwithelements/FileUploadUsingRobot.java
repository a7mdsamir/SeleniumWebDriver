package workingwithelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class FileUploadUsingRobot {

	public WebDriver driver ; 


	@BeforeClass
	public void setUp() 
	{
//		System.setProperty("webdriver.chrome.driver",
//				System.getProperty("user.dir")+"\\Sources\\chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.navigate().to("https://the-internet.herokuapp.com/upload");
		driver.manage().window().maximize();
	}

	@Test
	public void FileUploadWithRobot() throws InterruptedException, AWTException 
	{
		String imageName = "DSC_0430.jpg";
		String imagePath = System.getProperty("user.dir")+"\\Uploads\\"+imageName;

		WebElement fileUploader = driver.findElement(By.id("file-upload")); 
		fileUploader.click();

		// Code using robot class for file upload

		Robot robot = new Robot();

		// CTRL + C copy image path
		StringSelection selection = new StringSelection(imagePath);
		System.out.println(imagePath);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(selection, null);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(2000);
		// Click on CTRL + V 
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);

		WebElement fileSubmit = driver.findElement(By.id("file-submit")); 
		fileSubmit.click();
		WebElement uploadedFiles = driver.findElement(By.id("uploaded-files")); 
		System.out.println(uploadedFiles.getText());
		Thread.sleep(3000);
		Assert.assertEquals(uploadedFiles.getText(), imageName);


	}

	@AfterClass
	public void tearDown() 
	{
		driver.quit();
	}

}
