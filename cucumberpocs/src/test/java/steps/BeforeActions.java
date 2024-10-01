package steps;

import io.cucumber.java.Before;
import utils.SeleniumDriverOld;


public class BeforeActions 
{
	@Before(order=1)
    public static void setUp() {
		//ExtentCucumberFormatter.initiateExtentCucumberFormatter();
    	//System.out.println("Before");
        SeleniumDriverOld.setUpDriver();
    }
}
