package tests;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTAndDataProvider extends TestBase
{
	HomePage homePage ;
	UserRegistrationPage userRegistrationPage ;
	LoginPage loginPage ;


	@DataProvider(name="testData")
	public static Object[][] userData()
	{
		return new Object[][] {
			{"Ahmed" , "Samir","test5@gmail.com","123456"},
			{"Ahmed","Ali","testuser1@gmail.com","12345678"}
		};
	}

	@Test(priority=1,dataProvider="testData")
	public void UserCanRegisterSuccssfully(String fname, String lname , String email , String password ) 
	{
		homePage = new HomePage(driver);
		homePage.openRegistrationPage();
		userRegistrationPage = new UserRegistrationPage(driver);
		userRegistrationPage.userRegistration(fname,lname,email,password);
		Assert.assertTrue(userRegistrationPage.successMessage.getText().contains("Your registration completed"));
		userRegistrationPage.userLogout();
		homePage.openLoginPage();
		loginPage = new LoginPage(driver);
		loginPage.userLogin(email, password);
		Assert.assertTrue(userRegistrationPage.logoutLink.getText().contains("Log out"));
		userRegistrationPage.userLogout();
	}


}
