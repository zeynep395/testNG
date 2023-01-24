package dt_project.tests.smoketest.reservationtests;

import com.github.javafaker.Faker;
import dt_project.pages.BlueRentCarHomePage;
import dt_project.pages.BlueRentCarLoginPage;
import dt_project.utilities.ConfigReader;
import dt_project.utilities.Driver;
import dt_project.utilities.ReusableMethods;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Day19_ReservationTest {

    BlueRentCarHomePage homePage;
    BlueRentCarLoginPage loginPage;
    Faker faker;

    @Test
    public void reservationTest(){
//        Given user is on the home page
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
//        LOGIN THE APP
        homePage=new BlueRentCarHomePage();
        loginPage= new BlueRentCarLoginPage();
        ReusableMethods.waitFor(3);
        homePage.homePageLoginLink.click();
//        sending credentials and clicking on login button
        ReusableMethods.waitFor(3);
        loginPage.email.sendKeys("jack@gmail.com");
        ReusableMethods.waitFor(3);
        loginPage.password.sendKeys("12345");
        ReusableMethods.waitFor(3);
        loginPage.loginButton.click();
        ReusableMethods.waitFor(3);
//        Verify login is successful
        ReusableMethods.verifyElementDisplayed(homePage.userID);

//        NOW THAT U LOGGED IN THE APPLICATION, WE CAN ENTER THE REQUIRED FIELDS

        // And select a car
        Select carSelect = new Select(homePage.selectACar);
        carSelect.selectByIndex(3);

    // And enter pick up field
        faker = new Faker();
        homePage.pickUpLocation.sendKeys(Faker.instance(Locale.US).address().cityName());

    // And enter drop off field
        homePage.dropOfLocation.sendKeys(Faker.instance(Locale.US).address().cityName());

    //Pick Up Date

    //Pick Up Time

    //Drop Off Date

    //Drop Off Time
        //SimpleDateFormat simpleDateFormat=new SimpleDateFormat("ddMMyyyy");
        //String today=simpleDateFormat.format(new Date());

        SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("hhmmaa");
        Calendar calendar=Calendar.getInstance();
    // enter pick up date
        homePage.pickUpDate.sendKeys("10/10/2025");

    //  enter pick up time
        homePage.pickUpTime.sendKeys(simpleDateFormat1.format(calendar.getTime()));

    // enter drop off date
        homePage.dropOffDate.sendKeys("12/11/2025");

    // enter drop off time
        homePage.dropOffTime.sendKeys(simpleDateFormat1.format(calendar.getTime()));
    //==============================
    // And click continue reservation
        homePage.continueReservationButton.click();

// CAR IS NOT RESERVED There is a BLOCKER....

    // And verify complete reservation screen pops up

    // And enter card number

    //  And enter name on the card

    // And enter expire date and CVC

    // And checks the agreement

    // And click complete reservation

    // Then verify ‘Reservation created successfully’ pop up

    // And naviaged to Reservations screen

    // And verify the last reservation is created

    // When you click on the last reservation

    // Then verify reservation detail page is displayed

    // And verify the table has the following fields: Model, Doors, Seats, Luggage, Transmission, Air Conditioning, Fuel Type, Age

    // And click on back to reservations

    // And verify Reservations page is displayed

    // And click on Home link

    // Then verify the home page is displayed

    }
}
