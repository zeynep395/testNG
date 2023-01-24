package dt_project.tests.smoketest.logintests;

import dt_project.pages.BlueRentCarHomePage;
import dt_project.pages.BlueRentCarLoginPage;
import dt_project.utilities.ConfigReader;
import dt_project.utilities.Driver;
import dt_project.utilities.ReusableMethods;
import org.testng.annotations.Test;


public class Day18_PosotoveLoginTest {
    /*
        https://www.bluerentalcars.com/
        Admin email: jack@gmail.com
        Admin password: 12345
    */

    BlueRentCarHomePage homePage;
    BlueRentCarLoginPage loginPage;

    @Test
    public void US100201_Admin_Login(){
    // going blue rental cars home page
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
        homePage = new BlueRentCarHomePage();
        loginPage = new BlueRentCarLoginPage();
        ReusableMethods.waitFor(3); //ReusableMethods Class'i utilities package'inin icinde
        homePage.homePageLoginLink.click();

    // sending credentials and clicking on login button
        loginPage.email.sendKeys("jack@gmail.com");
        loginPage.password.sendKeys("12345");
        loginPage.loginButton.click();
        ReusableMethods.waitFor(3);

    // Verify login is successful
        ReusableMethods.verifyElementDisplayed(homePage.userID); //dogrulamak istedigimiz locator varmi yokmu methodu
    // Alternatively We Can Assert If Home Page Login Link Is not Displayed. NOT RECOMMENDED.
    //    ReusableMethods.verifyElementNotDisplayed(homePage.homePageLoginLink);// alternatifli method.

    }
}
