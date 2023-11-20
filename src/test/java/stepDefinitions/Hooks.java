package stepDefinitions;

import utils.TestContextSetup;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks {

	private TestContextSetup tcs;
	private WebDriver driver;
	
	public Hooks(TestContextSetup tcs) {
		this.tcs=tcs;
	}
	//In After order 1 will be exceuted first and then order 0 
//	@After(order=0)
//	public void teardown() throws IOException {
//		
//		if(tcs.DriverSetting()!=null) {
//			tcs.DriverSetting().quit();
//		}
//		//tcs.DriverSetting().quit();
//	}
//	
	@After(order=1)
	public void failTest(Scenario scenario) throws WebDriverException, IOException, InterruptedException {
		if(scenario.isFailed()) {
			//Take Screenshot
			Thread.sleep(2000);
			String screenshotName=scenario.getName().replace(" ", "_");
			byte[] sourcePath=((TakesScreenshot)tcs.DriverSetting()).getScreenshotAs(OutputType.BYTES); //bytes is taken for jenkins since if we take file it will not accept
			scenario.attach(sourcePath,"image/png", screenshotName);
		}
	}
	/*
	@After(order=2)
	public void afterTest(Scenario scenario) throws WebDriverException, IOException {
		while(scenario == null) {
			String screenshotName=scenario.getName().replace(" ", "_");
			byte[] sourcePath=((TakesScreenshot) tcs.DriverSetting()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath,"imagesrc/png", screenshotName);
		}
		} */
	}
	

