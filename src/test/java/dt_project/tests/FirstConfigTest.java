package dt_project.tests;

import dt_project.utilities.ConfigReader;
import dt_project.utilities.Driver;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstConfigTest {
    /*
        Go to techproed homepage
        Assert title
    */
    @Test
    public void firstConfigTest(){
    // Driver.getDriver().get("https://www.techproeducation.com");
        Driver.getDriver().get(ConfigReader.getProperty("url_prod_techproed")); //driver.get("url") gibi

    // Verify the title contains Techpro Education
        String actualTitle = Driver.getDriver().getTitle();
        System.out.println("Actual Title = " + actualTitle);
        Assert.assertEquals("Techpro Education | Online It Courses & Bootcamps" , actualTitle);
        Assert.assertEquals(ConfigReader.getProperty("app_title"),actualTitle);
        Assert.assertTrue(actualTitle.contains(ConfigReader.getProperty("app_title")));


        //CongifReader--->>> configuration.properties file'indaki datalari okumayi saglayan methoddur.
        // getProperty( file daki value degeri alinacak key'in adi yazilir.)

    }

}
