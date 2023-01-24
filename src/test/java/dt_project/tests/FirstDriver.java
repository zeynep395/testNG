package dt_project.tests;

import dt_project.utilities.Driver;
import org.testng.annotations.Test;

public class FirstDriver {
    @Test
    public void firstDriverTest(){
        // driver -->> Driver.getDriver()
        Driver.getDriver().get("https://techproeducation.com");


        // close the driver
        //    Driver.closeDriver();
    }
}
