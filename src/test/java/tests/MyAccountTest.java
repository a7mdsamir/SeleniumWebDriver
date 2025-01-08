package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase{

    HomePage homePage ;
    UserRegistrationPage userRegistrationPage ;
    MyAccountPage myAccountPage ;
    LoginPage loginPage ;
    String oldPassword = "Aa123456@";
    String newPassword = "123456";
    String firstName = "Ahmed" ;
    String lastName = "Samir" ;
    String email = "test4@gmail.com";


    @Test(priority = 1, alwaysRun = true)
    public void userCanRegisterSuccessfully(){
        homePage = new HomePage(driver);
        homePage.openRegistrationPage();

        userRegistrationPage = new UserRegistrationPage(driver);
        userRegistrationPage.userRegistration(firstName, lastName, email, oldPassword);

        Assert.assertTrue(userRegistrationPage.successMessage.getText().contains("Your registration completed"));
    }

    @Test (dependsOnMethods = "userCanRegisterSuccessfully")
    public void registeredUserCanChangePassword(){
        myAccountPage = new MyAccountPage(driver);
        userRegistrationPage.openMyAccountPage();
        myAccountPage.openChangePasswordPage();
        myAccountPage.changePassword(oldPassword, newPassword);
        Assert.assertTrue(myAccountPage.resultLbl.getText().contains("Password was changed"));
    }

    @Test (dependsOnMethods = "registeredUserCanChangePassword")
    public void registeredUserCanLogoutSuccessfully(){
        userRegistrationPage.userLogout();
    }

    @Test (dependsOnMethods = "registeredUserCanLogoutSuccessfully")
    public void registeredUserCanLoginSuccessfully(){
        homePage.openLoginPage();
        loginPage = new LoginPage(driver);
        loginPage.userLogin(email, newPassword);
        Assert.assertTrue(userRegistrationPage.logoutLink.isDisplayed());
        Assert.assertTrue(userRegistrationPage.logoutLink.getText().contains("Log out"));
    }
}
