package dt_project.pages;

import dt_project.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class XYZBankHomePage {
    public XYZBankHomePage(){ //defaoult Constructor
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//button[.='Bank Manager Login']")
    public WebElement bankManagerLoginButton;

    @FindBy(xpath = "//button[.='Customer Login']")
    public WebElement customerLoginButton;

}
