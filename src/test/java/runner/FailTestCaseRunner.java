package runner; //original

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "@target/failedScenarios.txt", dryRun = false, glue = "stepDefinitions", monochrome = true, publish = false, plugin = {
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })

public class FailTestCaseRunner extends AbstractTestNGCucumberTests {
 
	
}
//tags = "@Smoketest",
// tags = "@Regression",