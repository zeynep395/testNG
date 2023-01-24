package dt_project.tests.dataprovider;

import dt_project.pages.BlueRentCarHomePage;
import dt_project.pages.BlueRentCarLoginPage;
import dt_project.utilities.ConfigReader;
import dt_project.utilities.Driver;
import dt_project.utilities.ExcelUtils;
import dt_project.utilities.ReusableMethods;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider3 {
    BlueRentCarHomePage homePage;
    BlueRentCarLoginPage loginPage;

    @DataProvider
    public Object[][] customerData() {
        ExcelUtils excelUtils =new ExcelUtils("./src/test/java/dt_project/resources/mysmoketestdata.xlsx" , "customer_info");

        Object[][] customerCredentials =excelUtils.getDataArrayWithoutFirstRow();

                /*{{"sam.walker@bluerentalcars.com", "c!fas_art"},
                {"kate.brown@bluerentalcars.com", "tad1$Fas"},
                {"raj.khan@bluerentalcars.com", "v7Hg_va^"},
                {"pam.raymond@bluerentalcars.com", "Nga^g6!"}
        };*/

        return customerCredentials;
    }


    public void login() {

        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
        homePage = new BlueRentCarHomePage();
        loginPage = new BlueRentCarLoginPage();
        ReusableMethods.waitFor(1);
        try {
            homePage.homePageLoginLink.click();
            ReusableMethods.waitFor(1);
        } catch (Exception e) {
        }
        try {
            ReusableMethods.waitFor(1);
            homePage.userID.click();
            ReusableMethods.waitFor(1);
            homePage.logoutLink.click();
            ReusableMethods.waitFor(1);
            homePage.OK.click();
            ReusableMethods.waitFor(1);
            homePage.homePageLoginLink.click();
            ReusableMethods.waitFor(1);
        } catch (Exception e) {
        }
        ReusableMethods.waitFor(1);
    }


    @Test(dataProvider = "customerData")
    public void customerLoginTest(String username, String password) {
        login();
        ReusableMethods.waitFor(1);
        loginPage.email.sendKeys(username);
        ReusableMethods.waitFor(1);
        loginPage.password.sendKeys(password);
        ReusableMethods.waitFor(1);
        loginPage.loginButton.click();
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}
