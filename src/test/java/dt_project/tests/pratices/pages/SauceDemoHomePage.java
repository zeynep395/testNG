package dt_project.tests.pratices.pages;

import dt_project.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SauceDemoHomePage {
    public SauceDemoHomePage(){
        PageFactory.initElements(Driver.getDriver() ,this);
    }


    @FindBy(id="user-name")
    public WebElement usernameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(id = "login-button")
    public WebElement loginButton;

}
