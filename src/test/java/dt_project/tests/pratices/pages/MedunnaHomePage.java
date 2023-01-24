package dt_project.tests.pratices.pages;

import dt_project.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MedunnaHomePage {
    public MedunnaHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath="//*[@data-icon='user']")
    public WebElement userIcon;

    @FindBy(id = "login-item")
    public WebElement signInOption;

    @FindBy(xpath = "//*[text()='Items&Titles']")
    public WebElement itemAndTitlesMenu;

    @FindBy(linkText = "Patient")
    public WebElement patientOption;


}

