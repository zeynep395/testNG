package dt_project.tests.pratices.tests;

import dt_project.tests.pratices.pages.SauceDemoHomePage;
import dt_project.tests.pratices.pages.SauceDemoProductsPage;
import dt_project.utilities.ConfigReader;
import dt_project.utilities.Driver;
import dt_project.utilities.JSUtils;
import dt_project.utilities.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class SauceDemoPrice {
    /*
  Given
       Go to  https://www.saucedemo.com/
  When
       Enter the username  as "standard_user"
  And
       Enter the password as "secret_sauce"
  And
       Click on login button
  Then
       Assert that total price of all products is 129.94 dollars
  And
       Flash each web element you used
   */

    SauceDemoHomePage homePage;
    SauceDemoProductsPage productsPage;

    @Test(groups = "smoke-test")
    public void totalPrice(){
    // Go to  https://www.saucedemo.com/
        Driver.getDriver().get(ConfigReader.getProperty("sauce_demo_url"));

    // Enter the username  as "standard_user"
        homePage = new SauceDemoHomePage(); //page class taki locators kullanmak icin
        JSUtils.flash(homePage.usernameInput);
        homePage.usernameInput.sendKeys(ConfigReader.getProperty("sauce_demo_username"));

    // Enter the password as "secret_sauce"
        JSUtils.flash(homePage.passwordInput);
        homePage.passwordInput.sendKeys(ConfigReader.getProperty("sauce_demo_password"));

    // Click on login button
        homePage.loginButton.click();

    // Assert that total price of all products is 129.94 dollars
        productsPage = new SauceDemoProductsPage();
        double sum = 0;
        for(WebElement w:productsPage.price){
            JSUtils.flash(w);
            sum+=Double.valueOf(w.getText().replaceAll("\\$" , ""));
        }
        System.out.println("Total Price: " + sum);

        //Assert
        ReusableMethods.waitFor(3);
        assertEquals("129.94" , sum);

        // Flash each web element you used
        //Driver.getDriver().close();

    }
}
