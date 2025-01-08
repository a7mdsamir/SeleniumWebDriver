package tests;


import data.JsonDataReader;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

import java.io.IOException;

public class UserRegistrationTestWithDDTAndJSON extends TestBase
{
	
	HomePage homePage ;
	UserRegistrationPage userRegistrationPage ;
	LoginPage loginPage ;

	@Test(priority=1,alwaysRun=true)
	public void UserCanRegisterSuccssfully() throws IOException, ParseException 
	{
		JsonDataReader jsonReader = new JsonDataReader(); 
		jsonReader.JsonReader();

		homePage = new HomePage(driver);
		homePage.openRegistrationPage();
		userRegistrationPage = new UserRegistrationPage(driver);
		userRegistrationPage.userRegistration(jsonReader.firstname,jsonReader.lastname,jsonReader.email,jsonReader.password);
		Assert.assertTrue(userRegistrationPage.successMessage.getText().contains("Your registration completed"));
		userRegistrationPage.userLogout();
		homePage.openLoginPage();
		loginPage = new LoginPage(driver);
		loginPage.userLogin(jsonReader.email, jsonReader.password);
		Assert.assertTrue(userRegistrationPage.logoutLink.getText().contains("Log out"));
		userRegistrationPage.userLogout();
	}

}
