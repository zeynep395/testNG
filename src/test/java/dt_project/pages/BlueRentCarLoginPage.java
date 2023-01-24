package dt_project.pages;

import dt_project.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlueRentCarLoginPage {
    public BlueRentCarLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(name = "email")
    public WebElement email;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement errorMessage_incorrectEmailPass;



}