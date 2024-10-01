package pages.actions;


import org.openqa.selenium.support.PageFactory;

import pages.locators.LoginPageLocators;
import utils.SeleniumDriverOld;

public class LoginPageActions 
{
	LoginPageLocators loginPageLocators=null;
	public LoginPageActions()
	{
		this.loginPageLocators=new LoginPageLocators();
		PageFactory.initElements(SeleniumDriverOld.getDriver(), loginPageLocators);
	}
	
	public void inputUserNameIntoLoginPage(String userName)
	{
		//driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
		loginPageLocators.userNameTextField.sendKeys(userName);
	}
	
	public void inputPasswordIntoLoginPage(String password)
	{
		//driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
		loginPageLocators.password.sendKeys(password);
	}
	
}
