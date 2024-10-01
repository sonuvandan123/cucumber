Feature: Add Product to Cart


Scenario: Verify the Same Product is Added to the Cart

Given the user is on the inventory page
When the user clicks on "Add to Cart" for the product "Sauce Labs Bike Light"
And the user clicks on the cart icon
Then the user should see that the product "Sauce Labs Bike Light" is in the cart