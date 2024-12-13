package workWzElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DropDownAndCheckBox {

    ChromeDriver driver;
    @BeforeTest
    public void openURl(){

        driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/dropdown");

    }
    @Test
    public void testDropDown() throws InterruptedException {

        WebElement optionList = driver.findElement(By.id("dropdown"));
        Select selectOptions = new Select(optionList);

        Assert.assertFalse(selectOptions.isMultiple());
        Assert.assertEquals(selectOptions.getOptions().size(), 3);

        Thread.sleep(2000);
        selectOptions.selectByVisibleText("Option 2");
        Thread.sleep(2000);
        selectOptions.selectByValue("1");
        Thread.sleep(2000);
        selectOptions.selectByIndex(2);
        Assert.assertEquals(selectOptions.getFirstSelectedOption().getText(), "Option 2");

//        return failure You may not select a disabled option
//        SelectOptions.selectByVisibleText("Please select an option");
//        SelectOptions.selectByIndex(0);

//        return failure
//        SelectOptions.selectByValue("5");
//        SelectOptions.selectByValue("0");
//        SelectOptions.selectByIndex(3);


        driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");
        WebElement check1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[1]"));
        Thread.sleep(2000);
        check1.click();
        Thread.sleep(2000);
        WebElement check2 = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[2]"));
        check2.click();

        if (check1.isSelected()){
            check1.click();
        }

//    @AfterTest
//    public void closeDriver(){
//        driver.quit();
//    }

}}
