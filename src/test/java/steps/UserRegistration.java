package steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import junit.framework.Assert;
import pages.HomePage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class UserRegistration extends TestBase {

    HomePage homePage ;
    UserRegistrationPage userRegistrationPage ;

    @Given("^the user in the home page$")
    public void the_user_in_the_home_page() throws Throwable {
        homePage = new HomePage(driver);
        homePage.openRegistrationPage();
    }

    @When("^I click on register link$")
    public void i_click_on_register_link()  {

        Assert.assertTrue(driver.getCurrentUrl().contains("register"));
    }

	/*
	@When("^I entered the user data$")
	public void i_entered_the_user_data()  {
		userRegistrationPage = new UserRegistrationPage(driver);
		userRegistrationPage.userRegistration("Moataz", "Nabil", "moataz@test.com", "12345678");
	}
	*/

    @When("^I entered \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\"$")
    public void i_entered(String firstname, String lastname, String email, String password) {
        userRegistrationPage = new UserRegistrationPage(driver);
        userRegistrationPage.userRegistration(firstname, lastname,email,password);
    }

    @Then("^The registration page displayed successfully$")
    public void the_registration_page_displayed_successfully()  {

        userRegistrationPage.userLogout();
    }
}
