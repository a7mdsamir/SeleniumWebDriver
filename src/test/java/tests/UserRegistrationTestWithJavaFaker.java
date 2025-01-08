package tests;


import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithJavaFaker extends TestBase
{
	HomePage homePage ;
	UserRegistrationPage userRegistrationPage ;
	LoginPage loginPage ;
	Faker fakeData = new Faker(); 
	String firstname = fakeData.name().firstName(); 
	String lastname = fakeData.name().lastName();
	String email = fakeData.internet().emailAddress(); 
	String password = fakeData.number().digits(8).toString(); 

	@Test(priority=1,alwaysRun=true)
	public void UserCanRegisterSuccssfully() 
	{
		homePage = new HomePage(driver);
		homePage.openRegistrationPage();
		userRegistrationPage = new UserRegistrationPage(driver);
		userRegistrationPage.userRegistration(firstname,lastname,email,password);
		System.out.println("The Userr Data is : "+ firstname + " " + lastname + " " + email + " " + password);
		Assert.assertTrue(userRegistrationPage.successMessage.getText().contains("Your registration completed"));
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
		loginPage.userLogin(email,password);
		Assert.assertTrue(userRegistrationPage.logoutLink.getText().contains("Log out"));
	}
}
