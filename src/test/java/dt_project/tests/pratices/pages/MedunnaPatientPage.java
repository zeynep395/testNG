package dt_project.tests.pratices.pages;

import dt_project.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MedunnaPatientPage {
    public MedunnaPatientPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(id="jh-create-entity")
    public WebElement createANewPatientButton;

    @FindBy(id="patient-firstName")
    public WebElement patientFirstNameInput;

    @FindBy(id="patient-lastName")
    public WebElement patientLastNameInput;

    @FindBy(id = "email")
    public WebElement patientEmailInput;

    @FindBy(id = "patient-phone")
    public WebElement patientPhoneInput;

    @FindBy(id = "save-entity")
    public WebElement saveSubmitButton;




}

