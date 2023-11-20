package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class personaldetailsObjects {

	private static WebDriver driver;

	public personaldetailsObjects(WebDriver driver) {
		this.driver = driver;
	}

	private By imageLocator = By.xpath("//div[@class='oxd-file-div oxd-file-div--active']//button[@role='none']");
	private By nationalityLocator = By.xpath(
			"//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//div[@class='oxd-grid-3 orangehrm-full-width-grid']//div[1]//div[1]//div[2]//div[1]//div[1]//div[2]");
	private By maritalstatusLocator = By.xpath(
			"//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//div[2]//div[1]//div[2]//div[1]//div[1]//div[2]//i[1]");
	private By dateofbirthLocator = By.xpath(
			"//body/div[@id='app']/div[@class='oxd-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='orangehrm-card-container']/div[@class='orangehrm-edit-employee']/div[@class='orangehrm-edit-employee-content']/div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/form[@class='oxd-form']/div[@class='oxd-form-row']/div[@class='oxd-grid-3 orangehrm-full-width-grid']/div[1]/div[1]/div[2]/div[1]/div[1]/i[1]");
	private By saveNMDLocator = By.cssSelector("div[class='orangehrm-custom-fields'] button[type='submit']");
	private By bloodtypeLocator = By.xpath(
			"//div[@class='orangehrm-custom-fields']//div[@class='orangehrm-card-container']//form[@class='oxd-form']//div[@class='oxd-form-row']//div[@class='oxd-grid-3 orangehrm-full-width-grid']//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']");
	private By savebtLocator = By
			.xpath("//div[@class='orangehrm-custom-fields']//button[@type='submit'][normalize-space()='Save']");
	private By empidsearchLocator = By.xpath(
			"//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']");


	public void savepersonaldetails() {
		WebElement save=driver.findElement(saveNMDLocator);
		save.click();
	}
	
	public void getpicture(String picturePath) {
		WebElement picEMP = driver.findElement(imageLocator);
	}
	
	
	
	
	
	
//	public void addPersonalDetails(String Nationality, String MaritalStatus, String DateofBirth ,String BloodType) throws InterruptedException {
//	WebElement addNationality = driver.findElement(nationalityLocator);
//	scroll(addNationality);
//	//addNationality.sendKeys(Nationality);
//    Actions keyDown = new Actions(driver);
//   keyDown.moveToElement(addNationality).click().perform();
//   keyDown.sendKeys(Keys.chord(Keys.DOWN));
//    //keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN)).perform();
//
//	//List<WebElement> nations=driver.findElements(By.xpath("//div[@class='oxd-select-text-input' and text()='Afghan']"));
//	
//    Thread.sleep(2000);
//	//selectoptionfromDropDown(addNationality, Nationality);
//	addNationality.click();
//	
//    Thread.sleep(2000);
//	WebElement addMaritalStatus = driver.findElement(maritalstatusLocator);
//	scroll(addMaritalStatus);
//	//selectoptionfromDropDown(addMaritalStatus, MaritalStatus);
//	Thread.sleep(2000);
//	WebElement addDOB = driver.findElement(dateofbirthLocator);
//	addDOB.sendKeys(DateofBirth);
//	WebElement addBloodType = driver.findElement(bloodtypeLocator);
//	scroll(addBloodType);
//	//selectoptionfromDropDown(addBloodType, BloodType);
//	Thread.sleep(2000);
//
//}
//
////public static void selectoptionfromDropDown(WebElement ele, String value) {
////
////	Select dropdown = new Select(ele);
////	List<WebElement> allOptions = dropdown.getOptions();
////	for (WebElement option : allOptions) {
////		if (option.getText().equals(value)) {
////			option.click();
////			break;
////		}
////	}
////}
//
//public static void datepicker() {
//	
//}

//public static void scroll(WebElement ele) {
//	JavascriptExecutor js = (JavascriptExecutor) driver;
//	//For Bottom
//	//js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//	js.executeScript("arguments[0].scrollIntoView();",ele );
//
//	
//}

}
