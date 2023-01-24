package dt_project.tests.pratices.tests;

import dt_project.tests.pratices.pages.MedunnaHomePage;
import dt_project.tests.pratices.pages.MedunnaLoginPage;
import dt_project.tests.pratices.pages.MedunnaPatientPage;
import dt_project.utilities.*;
import org.checkerframework.checker.units.qual.C;
import org.testng.annotations.*;

public class MedunnaPatient {
    //Admin can create patients
    /*
        Given
            Go to https://medunna.com/
        When
            Click on "user icon"
        And
            Click on "Sign In" option
        And
            Enter username into "john_doe" input
        And
            Enter password into "John.123" input
        And
            Click on "Remember me" check box
        And
            Click on "Sign in" submit button
        And
            Click on "Items&Titles" menu
        And
            Click on "Patient" option
        And
            Click on "Create a new patient" button
        And
            Enter firstname into "First Name" input
        And
            Enter lastname into "Last Name" input
        And
            Enter email into "Email" input
        And
            Enter phone number into "Phone" input
        And
            Click on "Save" button

    */



    @DataProvider
    public Object[][] medunnaCredentialsExcelData(){

        ExcelUtils excelUtils = new ExcelUtils("./src/test/java/dt_project/resources/MedunnaCredentials.xlsx", "medunna01");

        Object[][] arr = excelUtils.getDataArrayWithoutFirstRow();

        return arr;
    }
    MedunnaHomePage homePage;
    MedunnaLoginPage loginPage;
    MedunnaPatientPage patientPage;

    @Test(dataProvider = "medunnaCredentialsExcelData", groups = "smoke-test")
    public void createPatientExcelData(String username, String password, String patientFN, String patientLN, String patientEmail, String patientPhone){
        //Go to https://medunna.com/
        Driver.getDriver().get(ConfigReader.getProperty("medunna_url"));

        //Click on "user icon"
        homePage = new MedunnaHomePage();
        ReusableMethods.waitFor(3);
        homePage.userIcon.click();

        //Click on "Sign In" option
        homePage.signInOption.click();
        ReusableMethods.waitFor(2);

        //Enter username into "Username" input
        loginPage = new MedunnaLoginPage();
        loginPage.userName.sendKeys(username);

        //Enter password into "Password" input
        loginPage.password.sendKeys(password);

        //Click on "Remember me" check box
        loginPage.rememberMe.click();

        //Click on "Sign in" submit button
        loginPage.signInButton.click();

        //Click on "Items&Titles" menu
        homePage.itemAndTitlesMenu.click();

        //Click on "Patient" option
        homePage.patientOption.click();

        //Click on "Create a new patient" button
        patientPage = new MedunnaPatientPage();
        patientPage.createANewPatientButton.click();

        //Enter firstname into "First Name" input
        patientPage.patientFirstNameInput.sendKeys(patientFN);

        //Enter lastname into "Last Name" input
        patientPage.patientLastNameInput.sendKeys(patientLN);

        //Enter email into "Email" input
        patientPage.patientEmailInput.sendKeys(patientEmail);

        //Enter phone number into "Phone" input
        patientPage.patientPhoneInput.sendKeys(patientPhone);


        //Click on "Save" button
        //patientPage.saveSubmitButton.click();
        // click() methodu calismadiginda wait koyabiliriz. try-catch konulabilir. Actions class kullanilabilir.

        JSUtils.clickElementByJS(patientPage.saveSubmitButton);

        ReusableMethods.waitFor(2);

    }
    @AfterMethod
    public void closeBrowser(){
        ReusableMethods.waitFor(3);
        Driver.closeDriver();
    }


    @DataProvider
    public Object[][] medunnaCredentials(){
        Object[][] arr = {
                {"john_doe11" ,"John.123","Merry" , "Star", "a@b.com", "1234567890"},
                {"john_doe12" ,"John.123","Merry" , "Terry", "a@b.com", "1234567890"},
                {"john_doe13" ,"John.123","Merry" , "Terry", "a@b.com", "1234567890"},
                {"john_doe14" ,"John.123","Merry" , "Terry", "a@b.com", "1234567890"},
                {"john_doe15" ,"John.123","Merry" , "Terry", "a@b.com", "1234567890"}
        };
        return arr;
    }



    @Test(dataProvider = "medunnaCredentials")
    public void createPatient(String username, String password, String patientFN, String patientLN, String patientEmail, String patientPhone){
        //Go to https://medunna.com/
        Driver.getDriver().get(ConfigReader.getProperty("medunna_url"));

        //Click on "user icon"
        homePage = new MedunnaHomePage();
        homePage.userIcon.click();

        //Click on "Sign In" option
        homePage.signInOption.click();

        //Enter username into "Username" input
        loginPage = new MedunnaLoginPage();
        loginPage.userName.sendKeys(username);

        //Enter password into "Password" input
        loginPage.password.sendKeys(password);

        //Click on "Remember me" check box
        loginPage.rememberMe.click();

        //Click on "Sign in" submit button
        loginPage.signInButton.click();

        //Click on "Items&Titles" menu
        homePage.itemAndTitlesMenu.click();

        //Click on "Patient" option
        homePage.patientOption.click();

        //Click on "Create a new patient" button
        patientPage = new MedunnaPatientPage();
        patientPage.createANewPatientButton.click();

        //Enter firstname into "First Name" input
        patientPage.patientFirstNameInput.sendKeys(patientFN);

        //Enter lastname into "Last Name" input
        patientPage.patientLastNameInput.sendKeys(patientLN);

        //Enter email into "Email" input
        patientPage.patientEmailInput.sendKeys(patientEmail);

        //Enter phone number into "Phone" input
        patientPage.patientPhoneInput.sendKeys(patientPhone);


        //Click on "Save" button
        //patientPage.saveSubmitButton.click();
        // click() methodu calismadiginda wait koyabiliriz. try-catch konulabilir. Actions class kullanilabilir.

        JSUtils.clickElementByJS(patientPage.saveSubmitButton);


    }


    @Test
    public void test1(){
        //Go to https://medunna.com/
        Driver.getDriver().get(ConfigReader.getProperty("medunna_url"));

        //Click on "user icon"
        homePage = new MedunnaHomePage();
        homePage.userIcon.click();

        //Click on "Sign In" option
        homePage.signInOption.click();

        //Enter username into "Username" input
        loginPage = new MedunnaLoginPage();
        loginPage.userName.sendKeys("john_doe");

        //Enter password into "Password" input
        loginPage.password.sendKeys("John.123");

        //Click on "Remember me" check box
        loginPage.rememberMe.click();

        //Click on "Sign in" submit button
        loginPage.signInButton.click();

        //Click on "Items&Titles" menu
        homePage.itemAndTitlesMenu.click();

        //Click on "Patient" option
        homePage.patientOption.click();

        //Click on "Create a new patient" button
        patientPage = new MedunnaPatientPage();
        patientPage.createANewPatientButton.click();

        //Enter firstname into "First Name" input
        patientPage.patientFirstNameInput.sendKeys("Mary");

        //Enter lastname into "Last Name" input
        patientPage.patientLastNameInput.sendKeys("Terry");

        //Enter email into "Email" input
        patientPage.patientEmailInput.sendKeys("a@b.com");

        //Enter phone number into "Phone" input
        patientPage.patientPhoneInput.sendKeys("1234567890");


        //Click on "Save" button
        //patientPage.saveSubmitButton.click();
        // click() methodu calismadiginda wait koyabiliriz. try-catch konulabilir. Actions class kullanilabilir.

        JSUtils.clickElementByJS(patientPage.saveSubmitButton);

    }
    @AfterTest
    public void close(){
         Driver.getDriver().quit();
    }

}
