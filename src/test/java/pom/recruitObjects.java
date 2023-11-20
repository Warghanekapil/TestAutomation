package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class recruitObjects {

WebDriver driver;

public recruitObjects() {
	this.driver=driver;
}
	
private By addtabLocator=By.xpath("/button[@type='button']//i[@class='oxd-icon bi-plus oxd-button-icon']");

public void clickAddTab() {
	WebElement clickadd=driver.findElement(addtabLocator);
}
	
}
