package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.actions.LoginPageActions;
import utils.SeleniumDriverOld;

public final class Login 
{
	
	 LoginPageActions loginPageActions = new LoginPageActions();
	 private WebDriver driver;

	    public Login() {
	        this.driver = SeleniumDriverOld.getDriver(); // Initialize the WebDriver instance
	    }

	    @Given("user is on homepage {string}")
	    public void user_is_on_homePage(String webSiteURL) {
	        SeleniumDriverOld.openPage(webSiteURL);
	    }

	    @When("user input username {string}")
	    public void user_enters_valid_username(String userName) {
	    	loginPageActions.inputUserNameIntoLoginPage(userName);
	        //driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
	    }

	    @And("user input password {string}")
	    public void user_enters_valid_password(String password) {
	    	loginPageActions.inputPasswordIntoLoginPage(password);
	        //driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
	    }

	    @And("user click on Login button")
	    public void user_click_on_login_button() {
	    	
	        driver.findElement(By.xpath("//input[@id='login-button']")).click();
	    }

	    @Then("user successfully login and navigate to inventory page")
	    public void user_navigate_to_inventory_page() {
	        String pageTitle = driver.findElement(By.xpath("//span[@class='title']")).getText();
	        Assert.assertEquals(pageTitle, "Products");
	    }

	    @Then("user should remain in login page")
	    public void user_should_remain_in_login_page() {
	        String pageTitle = driver.findElement(By.xpath("//div[@class='login_logo']")).getText();
	        Assert.assertEquals(pageTitle, "Swag Labs");
	    }
}
