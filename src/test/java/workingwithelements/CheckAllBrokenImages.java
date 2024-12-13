package workingwithelements;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class CheckAllBrokenImages {

	public WebDriver driver ;

	private int invalidImageCount;

	@BeforeClass
	public void setUp()
	{
//		System.setProperty("webdriver.chrome.driver",
//				System.getProperty("user.dir")+"\\Sources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/broken_images");
		driver.manage().window().maximize();
	}

	@Test
	public void testBrokenImages()
	{
		invalidImageCount = 0 ;
		List<WebElement> imageList = driver.findElements(By.tagName("img"));
		for(WebElement imgElement : imageList)
		{
			if (imgElement != null)
			{
				VerifyImageActive(imgElement);
			}
		}
		System.out.println("Total no. of invalid Images are : " + invalidImageCount);
	}


	public void VerifyImageActive(WebElement imgElement)
	{
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(imgElement.getAttribute("src"));

		try {
			HttpResponse response = client.execute(request);

			if (response.getStatusLine().getStatusCode() != 200) {
				invalidImageCount++ ;
			}

		} catch (ClientProtocolException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}





	}



	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}
