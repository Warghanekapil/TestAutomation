package stepDefinitions;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.loginObjects;
import pom.pimObjects;
import pom.pomManager;
import utils.TestContextSetup;

public class PIMDef {

	public WebDriver driver;
	public TestContextSetup tcs;
	public pimObjects pimobjects;
	public pomManager pm;
	public loginObjects loginobjects;

	public PIMDef(TestContextSetup tcs) {
		this.tcs = tcs;
	}

	@Given("Admin loggedIn on portal")
	public void admin_logged_in_on_portal() throws IOException {
		WebDriver driver = tcs.DriverSetting();
		pm = new pomManager(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		pm.loginObjects().enterUsername("Admin");
		pm.loginObjects().enterPassword("admin123");
		pm.loginObjects().clickLoginButton();
		System.out.println("Enter admin");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//	po = new pimObjects(driver);
//	lo=new loginObjects(driver);
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//	po.lo.enterUsername("admin");
//	po.lo.enterPassword("admin123");
//	po.lo.clickLoginButton();

	}

	@Given("Click on PIM")
	public void click_on_pim() {
		pm.pimObjects().clickPimTab();
	}

	@Given("Admin on Personnel Information Management page")
	public void admin_on_personnel_information_management_page() {
		Assert.assertEquals(pm.pimObjects().getPIMpage().contains("pim/viewEmployeeList"), true);
	}

	@Given("Click on Add Employee")
	public void click_on_add_employee() {
		pm.pimObjects().clickAddEmployee();
	}

	@Given("Click on Checkbox for Creating Login Details")
	public void click_on_checkbox_for_creating_login_details() throws InterruptedException {
		Thread.sleep(5000);
		pm.pimObjects().clickCheckbox();
	}

	@When("Admin entered {string} {string} {string} {string} {string}  {string} {string}")
	public void admin_entered_and_select_status(String FirstName, String LastName, String EmployeeID, String UserName,
			String Password, String ConfirmPassword, String Status) throws InterruptedException {
		// pm.pimObjects().getpicture(picturePath);

		pm.pimObjects().firstnameEMP(FirstName);
		pm.pimObjects().lastnameEMP(LastName);
		pm.pimObjects().uniqueIDEMP(EmployeeID);
		pm.pimObjects().usernameEMP(UserName);
		pm.pimObjects().passwordEMP(Password);
		System.out.println(Password.length());
		pm.pimObjects().confirmpasswordEMP(ConfirmPassword);
		System.out.println(ConfirmPassword.length());
		{
			if (Status.equalsIgnoreCase("enabled")) {
				pm.pimObjects().enabledstatus();
			} else if (Status.equalsIgnoreCase("disabled")) {
				pm.pimObjects().disabledstatus();
			}
			Thread.sleep(5000);
		}
		System.out.println("Emplyee ID " + pm.pimObjects().getEmployeeID(EmployeeID));
		String empcode = pm.pimObjects().getEmployeeID(EmployeeID);
	}

	@When("Click Save")
	public void click_save() throws InterruptedException {
		pm.pimObjects().saveDetails();
		Thread.sleep(5000);
		pm.personaldetailsObjects().savepersonaldetails();
	}

//	@When("Add {string} {string} {string} {string}")
//	public void add(String Nationality, String MaritalStatus, String DateofBirth, String BloodType) throws InterruptedException {
//	pm.personaldetailsObjects().addPersonalDetails(Nationality, MaritalStatus, DateofBirth,BloodType);
//	}

//	@When("Click Save for Saving Nationality, MaritalStatus and DOB")
//	public void click_save_for_saving_nationality_marital_status_and_dob() {
//		// Write code here that turns the phrase above into concrete actions
//		throw new io.cucumber.java.PendingException();
//	}
//
//	@When("Save added BloodType")
//	public void save_added_blood_type() {
//		// Write code here that turns the phrase above into concrete actions
//				throw new io.cucumber.java.PendingException();
//	}

	@Then("Click on PIM Tab")
	public void click_on_pim_tab() {
		pm.pimObjects().clickPimTab();
	}

	@Then("Validate Emp Creation by Searching Employee Information with {string} on PIM")
	public void validate_emp_creation_by_searching_employee_information_with_on_pim(String EmployeeID) {
		Assert.assertEquals(pm.pimObjects().checkEmpID(EmployeeID), EmployeeID);
	}

	@Then("Perform Logout")
	public void perform_logout() {
		pm.loginObjects().clickAdminDropDown();
		pm.loginObjects().clickAdminLogout();
	}
	
	@When("Click on Delete the Employee")
	public void click_on_delete_the_employee() throws InterruptedException {
		pm.pimObjects().deleteEmployee();
		pm.pimObjects().confirmdeletion();

	}
	@Then("Admin verifies the Employee deletion with {string} from system")
	public void admin_verifies_the_employee_deletion_with_from_system(String EmployeeID) {
	   Assert.assertNotEquals(pm.pimObjects().checkEmpID(EmployeeID), EmployeeID, null);
	}
	

}
