package dt_project.tests.pratices.pages;

import dt_project.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MedunnaLoginPage {
    public MedunnaLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(id="username")
    public WebElement userName;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(id="rememberMe")
    public WebElement rememberMe;



    @FindBy(xpath="(//span[text()='Sign in'])[3]")
    public WebElement signInButton;


}

