package steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.SeleniumDriverOld;

public class AddProductToCart {

   
	//@Before(order=2)   // commented this code, due apsen url launch was impacted
    public void login() {
        // Create an instance of the Login class
        Login loginSteps = new Login();

        // Perform the login steps
        loginSteps.user_is_on_homePage("https://www.saucedemo.com/");
        loginSteps.user_enters_valid_username("standard_user");
        loginSteps.user_enters_valid_password("secret_sauce");
        loginSteps.user_click_on_login_button();
       // loginSteps.user_navigate_to_inventory_page(); // Ensure that user is on the inventory page after login
    }
	
    @Given("^the user is on the inventory page$")
    public void userIsOnInventoryPage() throws InterruptedException {
    	login();
    	Thread.sleep(5000);
    	String pageTitle=SeleniumDriverOld.getDriver().findElement(By.xpath("//span[@class='title']")).getText();
		Assert.assertEquals(pageTitle,"Products");
    }

    @When("^the user clicks on \"([^\"]*)\" for the product \"([^\"]*)\"$")
    public void userClicksAddToCartForProduct(String addToCartButton, String productName) {
       // no use of product name
        WebElement addToCartButtonLocator = SeleniumDriverOld.getDriver().findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']"));
        addToCartButtonLocator.click();
    }

    @When("^the user clicks on the cart icon$")
    public void userClicksOnCartIcon() {
        // Assuming the cart icon has a specific locator (like an ID or class)
        WebElement cartIcon = SeleniumDriverOld.getDriver().findElement(By.xpath("//a[@class='shopping_cart_link']"));
        cartIcon.click();
    }

    @Then("^the user should see that the product \"([^\"]*)\" is in the cart$")
    public void userShouldSeeProductInCart(String productName) {
        // Verify that the product is listed in the cart
        WebElement cartItem = SeleniumDriverOld.getDriver().findElement(By.xpath("//div[@class='inventory_item_name']"));
        Assert.assertEquals(productName,cartItem.getText());
    }
}
