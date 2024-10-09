package steps;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import utils.SeleniumDriverOld;

public class AfterActions {

    @After(order=1)
    public static void tearDown(Scenario scenario) {
        WebDriver driver = SeleniumDriverOld.getDriver();

        // Check if the scenario failed
        if (scenario.isFailed()) {
            // Capture screenshot as a file
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            try {
            	
            	String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
                // Define the target directory where the screenshot will be saved
            	// Define the target directory where the screenshot will be saved
                String screenshotName = scenario.getName().replaceAll(" ", "_") + "_" + timeStamp + ".png";
                Path destinationPath = Paths.get("target/cucumber-reports", screenshotName);
               
                Files.createDirectories(destinationPath.getParent());
                Files.copy(screenshotFile.toPath(), destinationPath);

                // Attach screenshot file to the Cucumber report (and Extent via adapter)
                //scenario.attach(Files.readAllBytes(destinationPath), "image/png", "Screenshot for " + scenario.getName());

                // Convert the screenshot to Base64 for embedding in the Extent Report
                byte[] fileContent = Files.readAllBytes(screenshotFile.toPath());
                String base64Screenshot = Base64.getEncoder().encodeToString(fileContent);

                // Log the screenshot in the Extent report by embedding Base64 string
                scenario.log("Screenshot for test case: " + scenario.getName());
                scenario.log("<img src='data:image/png;base64," + base64Screenshot + "' />");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        SeleniumDriverOld.tearDown();
    }
}
