package runners;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = {"src/test/resources/featurefiles/verifyCartItem.feature",
	    		"src/test/resources/featurefiles/addToCart.feature"},
	          
	    glue = {"steps"},
	    plugin = {"pretty", "html:target/cucumber-reports/cucumber-html-report.html"
	    		,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
	    
	)
public class AddToCartRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
