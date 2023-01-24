package dt_project.tests;

import dt_project.utilities.ConfigReader;
import dt_project.utilities.Driver;
import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

/*
    USE @Listeners annotation to connect test classes and listeners
    dt_project.utilities.Listeners.class ==> path of listeners utility
*/


@Listeners(dt_project.utilities.Listeners.class) //Boylece classi Listener classina baglamis olduk.
                                                // Class isminden once eklenir.
public class ListenersTest1 {

    @Test
    public void test1(){
        System.out.println("Test case 1 PASS");
        assertTrue(true); //PASS
    }

    @Test
    public void test2(){
        System.out.println("Test case 2 FAIL");
        assertTrue(false); //FAIL
    }

    @Test
    public void test3(){
        System.out.println("Test case 3 SKIPPED");
        throw new SkipException("SKIP This Test Case");
    }

    @Test
    public void test4(){
        System.out.println("Test case 4 No Such Element Exception");
        Driver.getDriver().get(ConfigReader.getProperty("url_prod_techproed"));
        Driver.getDriver().findElement(By.id("abcd")); // No Such Element Exception
    }
}
