package dt_project.tests.smoketest.logintests;

import com.github.javafaker.Faker;
import dt_project.pages.BlueRentCarHomePage;
import dt_project.pages.BlueRentCarLoginPage;
import dt_project.utilities.ConfigReader;
import dt_project.utilities.Driver;
import dt_project.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Day19_NegativeLoginTest {
    /*
        Acceptance Criteria:
            As customer, I should not be able to log in the application
            Customer email: fake@bluerentalcars.com
            Customer password: fakepass
        Error: User with email fake@bluerentalcars.com not found
     */

    BlueRentCarHomePage homePage;
    BlueRentCarLoginPage loginPage;
    Faker faker;

    @Test
    public void US100208_Negative_Login() throws IOException {

        // going blue rental cars home page
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
        homePage = new BlueRentCarHomePage();
        loginPage = new BlueRentCarLoginPage();
        ReusableMethods.waitFor(3); //ReusableMethods Class'i utilities package'inin icinde
        homePage.homePageLoginLink.click();

        // sending credentials and clicking on login button
        loginPage.email.sendKeys("fake@bluerentalcars.com");
        loginPage.password.sendKeys("fakepass");
        loginPage.loginButton.click();
        ReusableMethods.waitFor(3);
        //         Error: User with email fake@bluerentalcars.com not found
        String errorMessage = loginPage.errorMessage_incorrectEmailPass.getText();
        Assert.assertEquals(errorMessage,"User with email fake@bluerentalcars.com not found");
        //ReusableMethods.verifyElementDisplayed(loginPage.email); -->>alternatively assert
        ReusableMethods.getScreenshot("NegativeLoginScreenshot");

    }


    @Test
    public void invalidCredsTest() throws IOException {

        // going blue rental cars home page
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
        homePage = new BlueRentCarHomePage();
        loginPage = new BlueRentCarLoginPage();
        ReusableMethods.waitFor(3); //ReusableMethods Class'i utilities package'inin icinde
        homePage.homePageLoginLink.click();

        // sending credentials and clicking on login button
        faker = new Faker();
        String fakeEmail = faker.internet().emailAddress();
        loginPage.email.sendKeys(fakeEmail);
        loginPage.password.sendKeys(faker.internet().password(4,6));//fake password
        loginPage.loginButton.click();
        ReusableMethods.waitFor(3);
        //         Error: User with email fake@bluerentalcars.com not found
        String errorMessage = loginPage.errorMessage_incorrectEmailPass.getText();
        Assert.assertEquals(errorMessage,"User with email " + fakeEmail+ " not found");
        //ReusableMethods.verifyElementDisplayed(loginPage.email); -->>alternatively assert
        ReusableMethods.getScreenshot("NegativeLoginScreenshot");

    }

}
