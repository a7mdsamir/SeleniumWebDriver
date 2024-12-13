package workingwithelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestUploadFile 
{
	public WebDriver driver ; 


	@BeforeClass
	public void setUp() 
	{
		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"\\Sources\\chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.navigate().to("https://the-internet.herokuapp.com/upload");
		driver.manage().window().maximize();
	}


	@Test
	public void testFileUpload() throws InterruptedException 

	{
		String imageName = "avatar-blank.jpg";
		String imagePath = System.getProperty("user.dir")+"/Uploads/"+imageName;	
		WebElement fileUploader = driver.findElement(By.id("file-upload")); 
		fileUploader.sendKeys(imagePath);
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
