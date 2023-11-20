package pom;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.ParameterType;

public class pimObjects {

public loginObjects lo;
private WebDriver driver;

public pimObjects(WebDriver driver) {
	this.driver=driver;
}

private By pimLocator=By.xpath("//span[text()='PIM']");
private By addemployeeLocator=By.xpath("//i[@class='oxd-icon bi-plus oxd-button-icon']");
private By checkboxLocator=By.xpath("//form[@class='oxd-form']//div[@class='oxd-switch-wrapper']//input[@type='checkbox']");
private By empfirstnameLocator =By.name("firstName");
private By empmidnameLocator =By.name("middleName");
private By emplastnameLocator =By.name("lastName");
private By empcodeLocator=By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
private By setusernameLocator=By.xpath("//body/div[@id='app']/div[@class='oxd-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='orangehrm-card-container']/form[@class='oxd-form']/div[@class='orangehrm-employee-container']/div[@class='orangehrm-employee-form']/div[@class='oxd-form-row']/div[1]/div[1]/div[1]/div[2]/input[1]");
private By setpasswordLocator=By.xpath("(//input[@type='password'])[1]");
private By confirmpasswordLocator=By.xpath("(//input[@type='password'])[2]");
private By enabledLocator=By.xpath("//div[@class='oxd-radio-wrapper']//input[@value='1']");
private By disableLocator=By.xpath("//div[@class='oxd-radio-wrapper']//input[@value='2']");
private By saveLocator=By.xpath("//button[@type='submit']");
private By empidsearchLocator=By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']");
private By deleteempLocator=By.xpath("//i[@class='oxd-icon bi-trash']");


//div[@class='oxd-switch-wrapper']//input[@type='checkbox']
public void clickPimTab()  {
WebElement pimTab=driver.findElement(pimLocator);
pimTab.click();
}

public void clickAddEmployee() {
WebElement addEmployee=	driver.findElement(addemployeeLocator);
addEmployee.click();
}

public String getPIMpage() {
	String pimURL=driver.getCurrentUrl();
	return pimURL;
}

public void clickCheckbox() {
	WebElement checkbox = driver.findElement(checkboxLocator);
	Actions action = new Actions(driver);
    action.moveToElement(checkbox).click().perform();
	}

public void firstnameEMP(String FirstName) {
	WebElement fnEMP=driver.findElement(empfirstnameLocator);
     fnEMP.sendKeys(FirstName);
}

public void lastnameEMP(String LastName) {
	WebElement lnEMP =driver.findElement(emplastnameLocator);
	lnEMP.sendKeys(LastName);
}

public void uniqueIDEMP(String EmployeeID) throws InterruptedException {
	WebElement idEMP=driver.findElement(empcodeLocator);
	Thread.sleep(2000);
	idEMP.sendKeys(Keys.CONTROL,Keys.chord("a"));
	idEMP.sendKeys(Keys.BACK_SPACE);
	//idEMP.clear();
	Thread.sleep(2000);
	idEMP.sendKeys(EmployeeID);
}

public String getEmployeeID(String ID) {
	String getID=driver.findElement(empcodeLocator).getText();
	System.out.println("Emp ID is "+getID);
	return ID;
}

public void usernameEMP(String UserName) {
	WebElement unEMP= driver.findElement(setusernameLocator);
	unEMP.sendKeys(UserName);
}

public void passwordEMP(String Password) {
	WebElement passEMP=driver.findElement(setpasswordLocator);
	passEMP.clear();
	passEMP.sendKeys(Password);
}

public void confirmpasswordEMP(String ConfirmPassword) {
	WebElement confpassEMP=driver.findElement(confirmpasswordLocator);
	confpassEMP.clear();
	confpassEMP.sendKeys(ConfirmPassword);
}

public void enabledstatus() {
	Boolean enabledEMP=driver.findElement(enabledLocator).isSelected();	
}

public void disabledstatus() {
	Boolean disabledEMP=driver.findElement(disableLocator).isSelected();
}



public void saveDetails() {
	WebElement save=driver.findElement(saveLocator);
	save.click();
}

public String validatePersonalPage() {
	String validatepersonal =driver.getCurrentUrl();
	return validatepersonal;
}

public String checkEmpID(String EmployeeID) {
	WebElement CheckempID=driver.findElement(empidsearchLocator);
	CheckempID.sendKeys(EmployeeID);
	return EmployeeID;
}

public void deleteEmployee() {
	WebElement deleteEmp=driver.findElement(deleteempLocator);
	deleteEmp.click();	
	//WebElement click=driver.findElement(By.xpath("[@class='oxd-icon bi-trash-fill oxd-button-icon']"));
	//click.click();
}

public void confirmdeletion() throws InterruptedException {

 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button//i[@class='oxd-icon bi-trash oxd-button-icon']"))).click();

//	WebElement element = driver.findElement(By.xpath("(//button[@type='button'])[16]"));
//	Actions actions = new Actions(driver);
//	actions.moveToElement(element).click().build().perform();
	
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("//button//i[@class='oxd-icon bi-trash oxd-button-icon']")).click();
}

}



