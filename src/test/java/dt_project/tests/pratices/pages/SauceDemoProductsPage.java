package dt_project.tests.pratices.pages;

import dt_project.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SauceDemoProductsPage {
    public SauceDemoProductsPage(){
        PageFactory.initElements(Driver.getDriver() ,this);
    }


    @FindBy(className="inventory_item_price")
    public List<WebElement> price;

}
