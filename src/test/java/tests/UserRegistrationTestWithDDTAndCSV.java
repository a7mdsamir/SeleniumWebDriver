package tests;


import com.opencsv.CSVReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

import java.io.FileReader;
import java.io.IOException;

public class UserRegistrationTestWithDDTAndCSV extends TestBase
{
	HomePage homePage ;
	UserRegistrationPage userRegistrationPage ;
	LoginPage loginPage ;

	CSVReader reader ;

	@Test(priority=1,alwaysRun=true)
	public void UserCanRegisterSuccssfully() throws IOException
	{
		// get path of CSV file
		String CSV_file = System.getProperty("user.dir")+"/src/test/java/data/UserData.csv";
		reader = new CSVReader(new FileReader(CSV_file));

		String[] csvCell ;

		// while loop will be executed till the lastvalue in CSV file .
		while((csvCell = reader.readNext()) != null)
		{
			String firstname = csvCell[0];
			String lastName = csvCell[1];
			String email = csvCell[2];
			String password = csvCell[3];

			homePage = new HomePage(driver);
			homePage.openRegistrationPage();
			userRegistrationPage = new UserRegistrationPage(driver);
			userRegistrationPage.userRegistration(firstname, lastName, email, password);
			Assert.assertTrue(userRegistrationPage.successMessage.getText().contains("Your registration completed"));
			userRegistrationPage.userLogout();
			homePage.openLoginPage();
			loginPage = new LoginPage(driver);
			loginPage.userLogin(email,password);
			Assert.assertTrue(userRegistrationPage.logoutLink.getText().contains("Log out"));
			userRegistrationPage.userLogout();
		}
	}
}
