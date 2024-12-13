package workWzElements;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TestHTML5VideoPlayer {

    ChromeDriver driver;

    @BeforeTest
    public void openURl() {
        // Set up WebDriver using WebDriverManager
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://videojs.com/");
    }

    @Test
    public void testHTML5VideoPlayer() throws IOException, InterruptedException {
        // Locate the video player
        WebElement videoPlayer = driver.findElement(By.id("vjs_video_3_html5_api"));

        // Use JavaScriptExecutor for interacting with video element
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Get the source of the video
        String source = (String) js.executeScript("return arguments[0].currentSrc", videoPlayer);
        System.out.println("Video source: " + source);

        // Get the duration of the video
        double duration = (Double) js.executeScript("return arguments[0].duration", videoPlayer);
        System.out.println("Video duration: " + duration + " seconds");

        // Verify correct video is loaded
//        Assert.assertEquals(source, "https://videojs.com/2dd8574c-c82c-46ff-bc24-7b0faecc27b9");

        // Play the video
        js.executeScript("arguments[0].play();", videoPlayer);

        // Wait for video to start playing
//        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
//                webDriver -> (Boolean) ((JavascriptExecutor) webDriver)
//                        .executeScript("return arguments[0].paused === false;", videoPlayer)
//        );
        Thread.sleep(6000);
        System.out.println("Video is now playing.");

        // Pause the video after a few seconds
        js.executeScript("arguments[0].pause();", videoPlayer);
        System.out.println("Video is now paused.");

        // Take a screenshot
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshotDir = new File("./Screenshots");

        FileUtils.copyFile(scrFile, new File(screenshotDir, "pause_play.png"));

        // Get the current time of the video
//        Double currentTime = (Double) js.executeScript("return arguments[0].currentTime;", videoPlayer);
//        System.out.println("Video current time: " + currentTime + " seconds");
    }

    @AfterTest
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
