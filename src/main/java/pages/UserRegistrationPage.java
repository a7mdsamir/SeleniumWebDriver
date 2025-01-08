package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase{

    public UserRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "gender-male")
    WebElement genderMaleRadioBtn ;

    @FindBy(id = "FirstName")
    WebElement firstNameTxtBox ;

    @FindBy(id = "LastName")
    WebElement lastNameTxtBox ;

    @FindBy(id = "Email")
    WebElement emailTxtBox ;

    @FindBy(id = "Password")
    WebElement passwordTxtBox ;

    @FindBy(id = "ConfirmPassword")
    WebElement confirmPasswordTxtBox ;

    @FindBy(id = "register-button")
    WebElement registerbtn ;

    @FindBy(css = "div.result")
    public WebElement successMessage;

    @FindBy(css = "a.ico-logout")
    public WebElement logoutLink;

    @FindBy(css = "a.ico-account")
    WebElement myAccountLink;

    public void userRegistration(String firstName, String lastName, String email, String password){
        clickButton(genderMaleRadioBtn);
        setTextElementText(firstNameTxtBox , firstName);
        setTextElementText(lastNameTxtBox , lastName);
        setTextElementText(emailTxtBox , email);
        setTextElementText(passwordTxtBox , password);
        setTextElementText(confirmPasswordTxtBox , password);
        clickButton(registerbtn);

    }

    public void userLogout(){
        clickButton(logoutLink);
    }

    public void openMyAccountPage(){
        clickButton(myAccountLink);
    }

}
