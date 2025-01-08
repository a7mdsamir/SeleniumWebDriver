package tests;


import data.LoadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTAndPropertiesFile extends TestBase
{
	HomePage homePage ;
	UserRegistrationPage userRegistrationPage ;
	LoginPage loginPage ;
	String firtname = LoadProperties.userData.getProperty("firstname");
	String lastname = LoadProperties.userData.getProperty("lastname"); 
	String email = LoadProperties.userData.getProperty("email"); 
	String Password = LoadProperties.userData.getProperty("password"); 

	@Test(priority=1,alwaysRun=true)
	public void UserCanRegisterSuccssfully() 
	{
	
		homePage = new HomePage(driver);
		homePage.openRegistrationPage();
		userRegistrationPage = new UserRegistrationPage(driver);
		userRegistrationPage.userRegistration(firtname,lastname,email,Password);
//		Assert.assertTrue(userRegistrationPage.successMessage.getText().contains("Your registration completed"));
	}
	
	@Test(dependsOnMethods= {"UserCanRegisterSuccssfully"})
	public void RegisteredUserCanLogout() 
	{
		userRegistrationPage.userLogout();
	}
	
	@Test(dependsOnMethods= {"RegisteredUserCanLogout"})
	public void RegisteredUserCanLogin() 
	{
		homePage.openLoginPage();
		loginPage = new LoginPage(driver);
		loginPage.userLogin(email,Password);
		Assert.assertTrue(userRegistrationPage.logoutLink.getText().contains("Log out"));
	}
}
