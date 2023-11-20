package pom;

import org.openqa.selenium.WebDriver;

public class pomManager {
	
	public WebDriver driver;
	public loginObjects loginobjects;
	public pimObjects pimobjects;
	public personaldetailsObjects personaldetailsobjects;
	
	public pomManager(WebDriver driver) {
		this.driver=driver;		
	}

	public loginObjects loginObjects() {
		loginobjects = new loginObjects(driver);
		return loginobjects;
	}
	
	public pimObjects pimObjects() {
		pimobjects = new pimObjects(driver);
		return pimobjects;
	}
	
	public personaldetailsObjects personaldetailsObjects() {
		personaldetailsobjects=new personaldetailsObjects(driver);
		return personaldetailsobjects;
	}
	
	
}
