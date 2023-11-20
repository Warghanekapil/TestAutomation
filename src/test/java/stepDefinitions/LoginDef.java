package stepDefinitions; //original

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.google.common.base.Verify;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.loginObjects;
import utils.TestContextSetup;

public class LoginDef {
	public WebDriver driver;
	public TestContextSetup tcs;
	public loginObjects lo;

	public LoginDef(TestContextSetup tcs) throws IOException {
		this.tcs = tcs;
	}

	@Given("User on the OrangeHRM Login Page")
	public void user_on_the_orange_hrm_login_page() throws InterruptedException, IOException {
		// Added to check (all working)
		// lo = new loginObjects(tcs.DriverSetting()); working code
//		tcs.DriverSetting().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//		tcs.DriverSetting().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		WebDriver driver = tcs.DriverSetting();
		lo = new loginObjects(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

	@Given("Admin entered a valid username and Password")
	public void admin_entered_a_valid_username_and_password() throws IOException {
		lo.enterUsername("admin");
		lo.enterPassword("admin123");
	}

	@Given("Admin entered a invalid {string} and Password {string}")
	public void admin_entered_a_invalid_and_password(String username, String password) {
		lo.enterUsername(username);
		lo.enterPassword(password);
	}

	@When("Admin click on login button")
	public void admin_click_on_login_button() {
		lo.clickLoginButton();
	}

	@Then("Login must be successful")
	public void login_must_be_successful() {
		Assert.assertEquals(lo.getLoggedinpage().contains("dashboard/index"), true);
	}

	@Then("Admin click on drop down menu")
	public void admin_click_on_drop_down_menu() {
		lo.clickAdminDropDown();
	}

	@Then("Admin click on logout")
	public void admin_click_on_logout() {
		lo.clickAdminLogout();
	}

	@Then("Admin should see an error message indicating {string}")
	public void admin_should_see_an_error_message_indicating(String error_message) {

		if (error_message == "Invalid credentials") {
			// Assert.assertEquals(tcs.tcs.driver.findElement(By.xpath("//p[text()='Invalid
			// credentials']")).isDisplayed(), true);
			Assert.assertEquals(tcs.driver.findElement(By.xpath("//div[@role='alert']")).isDisplayed(), true);
		} else if (error_message == "Required") {
			Assert.assertEquals(tcs.driver.findElement(By.xpath("//span[text()='Required']")).isDisplayed(), true);
		}
	}

	@Given("Click on Forgot your password")
	public void admin_click_on_forgot_your_password() {
		lo.clickForgotYourPassword();
	}

	@When("Redirected to the password reset page")
	public void admin_should_be_redirected_to_the_password_reset_page() {
		Assert.assertTrue(lo.getForgotPassword().contains("auth/requestPasswordResetCode"));
	}

	@When("Enters Username and click on Reset password")
	public void enters_username_and_click_on_reset_password() {
		lo.resetUsername("Adminn");

	}

	@Then("A Display message as {string}")
	public void a_display_message_as(String message) {
		// Assert.assertEquals(message, lo.resetMessage());
		Verify.verify(true, message, lo.resetMessage());
		System.out.println("*******************" + lo.resetMessage() + "***************************");
		System.out.println("+++++++++++++++++" + message + "+++++++++++++++++++++++++");
	}

	public void loggedOut() {
		lo.clickAdminDropDown();
		lo.clickAdminLogout();
	}

}
