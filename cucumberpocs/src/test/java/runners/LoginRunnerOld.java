package runners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/positive/cucumber.json", "pretty", "html:target/cucumber-reports/cucumber-html-report.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        features = "src/test/resources/featurefiles/login.feature",
        glue = "steps"      
        )
public class LoginRunnerOld extends AbstractTestNGCucumberTests
{
	 
}
