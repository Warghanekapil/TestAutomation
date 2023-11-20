package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestContextSetup {
		
public WebDriver driver;

public WebDriver DriverSetting() throws IOException {
	FileInputStream fis = new FileInputStream(
			System.getProperty("user.dir") + "//src//test//resources//config//configuration.properties");  //AutomationTesting/src/test
	Properties prop = new Properties();
	prop.load(fis);
	String url = prop.getProperty("qaURL");
	System.out.println("***************Starting Browser Provided In Configuration file **************");
	if (driver == null) {
		if (prop.getProperty("browser").equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (prop.getProperty("browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (prop.getProperty("browser").equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("***************Provide the Browser In Configuration file **************");
		}
		driver.get(url);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	return driver;
}



}
