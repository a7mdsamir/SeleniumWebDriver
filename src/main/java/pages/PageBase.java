package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;


public class PageBase {

    protected WebDriver driver;
    // create constructor
    public PageBase(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    protected static void clickButton(WebElement button){
        button.click();
    }
    protected static void setTextElementText(WebElement textElement, String value){
        textElement.sendKeys(value);
    }
}
