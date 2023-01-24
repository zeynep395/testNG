package dt_project.tests;

import com.github.javafaker.Faker;
import dt_project.pages.XYZBankCustomerPage;
import dt_project.pages.XYZBankHomePage;
import dt_project.pages.XYZBankManagerPage;
import dt_project.utilities.ConfigReader;
import dt_project.utilities.Driver;
import dt_project.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class XYZBankTest {
    //Open 5 New Accounts, deposit 100 USD and withdraw 100 USD from any account and delete all accounts.

    /*   Given
    Go to url https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
When
    Click on "Bank Manager Login" button
And
    Click on "Add Customer" button
And
    Fill inputs and click on "Add Customer" submit button
And
    Accept alert
And
    Add 4 more customers
And
    Click on "Open Account"  button
And
    Click on "Customer" dropdown
And
    Select customer name
And
    Click on "Currency" dropdown
And
    Select "Dollar"
And
    Click on "Process" button
And
    Accept alert
And
    Open 4 more accounts
And
    Click on "Customers" button
And
    Count table row numbers
Then
    Assert that you created 5 customers
When
    Click on "Home" button
And
    Click on "Customer Login" button
And
    Click on "Your Name" dropdown
And
    Select the any name you created
And
    Click on "Login" button
And
    Click on "Deposit" button
And
    Type 100 into "Amount to be Deposited" input
And
    Click on "Deposit"(Submit) button
Then
    Assert that "Deposit Successful" is displayed

And
    Click on "Withdrawal" button
And
    Type 100 into "Amount to be Withdrawn" input
And
    Click on "Withdraw"(Submit) button
Then
    Assert that "Transaction  Successful" is displayed
When
    Click on "Logout" button
And
    Click on "Home" button
And
    Click on "Bank Manager Login" button
And
    Click on "Customers" button
And
    Click on each "Delete" button
And
    Count table row numbers
Then
    Assert that number of customers is 0
     */

    @Test(groups = "smoke-test")
    public void xyzBankTest(){
        //Go to url https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
        Driver.getDriver().get(ConfigReader.getProperty("xyz_bank_url"));

        //Click on "Bank Manager Login" button
        XYZBankHomePage homePage = new XYZBankHomePage();
        homePage.bankManagerLoginButton.click();

        //Click on "Add Customer" button
        XYZBankManagerPage xyzBankManagerPage = new XYZBankManagerPage();
        xyzBankManagerPage.addCustomerButton.click();


        //Fill inputs and click on "Add Customer" submit button
        Faker faker = new Faker();
        for(int i =0; i<6; i++) {

            xyzBankManagerPage.firstnameInput.sendKeys(faker.name().firstName());
            xyzBankManagerPage.lastnameInput.sendKeys(faker.name().lastName());
            xyzBankManagerPage.postCodeInput.sendKeys(faker.address().zipCode());
            xyzBankManagerPage.addCustomerSubmitButton.click();

            //Accept alert
            try {
                Driver.getDriver().switchTo().alert().accept();
            } catch (Exception ignored) {
            }
        }

        //Add 4 more customers --->> yukaridaki for dongusu ile yaptik.

        //Click on "Open Account"  button
        xyzBankManagerPage.openAccountButton.click();
        ReusableMethods.waitFor(2);

        //Click on "Customer" dropdown
       //Select customer name
        Select select = new Select(xyzBankManagerPage.customerDropDown);

        //Click on "Currency" dropdown
        Select select1 = new Select(xyzBankManagerPage.currencyDropDown);

       //Select "Dollar"
        for(int i=6 ; i<11 ; i++ ){
            //Once dropdown'dan musteriyi secelim
            select.selectByIndex(i);
            //dolar yatiracagimiz icin 1. index i secmemiz yeterli.
            select1.selectByIndex(1);

            //Click on "Process" button
            xyzBankManagerPage.processSubmitButton.click();
        }

        //Accept alert
        try {
            Driver.getDriver().switchTo().alert().accept();
        } catch (Exception ignored) {
        }

        //Open 4 more accounts ---->>>for dongusu ile yaptik

        //Click on "Customers" button
        xyzBankManagerPage.customersButton.click();

        //Count table row numbers
        int numderOfRows = xyzBankManagerPage.numberOfRows.size();

        //Assert that you created 5 customers
        assertEquals(10,numderOfRows);

        //Click on "Home" button
       // xyzBankManagerPage.homeButton.click();

        //Click on "Customer Login" button
        homePage.customerLoginButton.click();

        //Click on "Your Name" dropdown
       //Select the any name you created
        XYZBankCustomerPage customerPage = new XYZBankCustomerPage();

        Select select2 = new Select(customerPage.yourNameDropDown);
        select2.selectByIndex(6);

        //Click on "Login" button
        customerPage.loginButton.click();

        //Click on "Deposit" button
        customerPage.depositButton.click();

        //Type 100 into "Amount to be Deposited" input
        customerPage.amountToBeDepositedInput.sendKeys("100");

        //Click on "Deposit"(Submit) button
        customerPage.depositSubmitButton.click();

        //Assert that "Deposit Successful" is displayed
        ReusableMethods.verifyElementDisplayed(customerPage.depositSuccessMessage);

        //Click on "Withdrawal" button
        customerPage.withdrawalButton.click();

        //Type 100 into "Amount to be Withdrawn" input
        customerPage.amountToBeWithdrawnInput.sendKeys("100", Keys.ENTER);

        //Click on "Withdraw"(Submit) button
        customerPage.withdrawSubmitButton.click(); //Selenium Click is not working

        Actions actions = new Actions(Driver.getDriver());
        actions.click(customerPage.withdrawSubmitButton);
        //Assert that "Transaction  Successful" is displayed

        //Click on "Logout" button
        customerPage.logOutButton.click();

        //Click on "Home" button
        xyzBankManagerPage.homeButton.click();

        //Click on "Bank Manager Login" button
        homePage.bankManagerLoginButton.click();

        //Click on "Customers" button
        xyzBankManagerPage.customersButton.click();

        //Click on each "Delete" button
        for(WebElement w: xyzBankManagerPage.deleteButtons){
            w.click();
        }
        //Count table row numbers
        int numberOfRowsAfterDelete = xyzBankManagerPage.deleteButtons.size();

        //Assert that number of customers is 0
        assertEquals(0 , numberOfRowsAfterDelete);

    }

}
