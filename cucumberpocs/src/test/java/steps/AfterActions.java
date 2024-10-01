package steps;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



import io.cucumber.java.After;
import io.cucumber.java.Scenario;

import utils.SeleniumDriverOld;

public class AfterActions {

    @After
    public static void tearDown(Scenario scenario) {
    	
    	WebDriver driver=SeleniumDriverOld.getDriver();
    	System.out.println(scenario.isFailed());
    	if (scenario.isFailed()) {
            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            // Attach screenshot to the scenario
            scenario.attach(screenshotBytes, "image/png", "screenshot");
        }
    SeleniumDriverOld.tearDown();
    }
}
