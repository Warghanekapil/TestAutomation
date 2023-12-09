package runner; //original

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", dryRun = false, glue = "stepDefinitions", monochrome = true, publish = true, plugin = {
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "rerun:target/failedScenarios.txt" })

public class TestRunner extends AbstractTestNGCucumberTests {
	
/*
@Override
@DataProvider(parallel=true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}*/
	//tags = "@E2ETEST",
}
//tags = "@Smoketest",@E2ETEST
// tags = "@Regression",