package pom; //original

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.common.base.Verify;

import utils.TestContextSetup;

public class loginObjects {

	private WebDriver driver;

	// public WebDriver driver;
	public loginObjects(WebDriver driver) {
		this.driver = driver;

	}

	private By usernameInputLocator = By.name("username");
	private By passwordInputLocator = By.name("password");
	private By loginButtonLocator = By.xpath("//button[@type='submit']");
	private By forgotyourpassowrdLocator = By.xpath("//p[text()='Forgot your password? ']");
	private By admindropdownLocator = By.xpath("//p[@class='oxd-userdropdown-name']");
	private By adminlogoutLocator = By.xpath("//*[text()='Logout']");
	private By displayMessageLocator = By.xpath("//p[text()='A reset password link has been sent to you via email.']");
	private By clickResetButton = By.xpath("//button[@type='submit']");

	public void enterUsername(String username) {
		WebElement usernameInput = driver.findElement(usernameInputLocator);
		usernameInput.sendKeys(username);
	}

	public void enterPassword(String password) {
		WebElement passwordinput = driver.findElement(passwordInputLocator);
		passwordinput.sendKeys(password);
	}

	public void clickLoginButton() {
		WebElement loginbutton = driver.findElement(loginButtonLocator);
		loginbutton.click();

	}

	public void clickAdminDropDown() {
		WebElement admindropdown = driver.findElement(admindropdownLocator);
		admindropdown.click();
	}

	public void clickAdminLogout() {
		WebElement adminlogout = driver.findElement(adminlogoutLocator);
		adminlogout.click();
	}

	public void clickForgotYourPassword() {
		WebElement fyp = driver.findElement(forgotyourpassowrdLocator);
		fyp.click();
	}

	public void login(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickLoginButton();

	}

	public String getForgotPassword() {
		String forgotpasswordURL = driver.getCurrentUrl();
		return forgotpasswordURL;

	}

	public boolean checkForgotpwdlink() {
		return driver.findElement(forgotyourpassowrdLocator).isDisplayed();
	}

	public String getLoggedinpage() {
		String loggedinpageURL = driver.getCurrentUrl();
		return loggedinpageURL;
	}

	public void resetUsername(String username) {
		enterUsername(username);
		WebElement rb = driver.findElement(clickResetButton);
		rb.click();
	}

	/*
	 * public boolean resetMessage() {
	 * 
	 * return driver.findElement(displayMessageLocator).isDisplayed(); }
	 */
	public String resetMessage() {

		return driver.findElement(displayMessageLocator).getText();
	}
	

}
