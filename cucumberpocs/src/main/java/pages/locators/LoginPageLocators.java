package pages.locators;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageLocators {

	
	
	@FindBy(how=How.XPATH,using=".//*[@id='user-name']")
	public WebElement userNameTextField;
	
	@FindBy(how=How.XPATH, using=".//*[@id='password']")
	public WebElement password;
	
	
	
}
