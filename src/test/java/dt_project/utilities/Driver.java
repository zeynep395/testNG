package dt_project.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {
    //  Driver.getDriver();  -->> driver
    private static WebDriver driver;

    // getDriver() is used to instantiate the driver object
    public static WebDriver getDriver(){
        if(driver==null) {
            switch (ConfigReader.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "firefox": //different driver
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "chrome-headless":  //run background driver
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;

                case "edge": //different driver
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
            }
        //    driver= WebDriverManager.chromiumdriver().create(); // Yukaridaki 2 komut satiri yerine yazabiliriz.
            // Note: Selenium 4.5 versionu icin
        }
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
         driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
         driver.manage().window().maximize();
         return driver;
        }
    // closeDriver()  is used to close the driver.
        public static void closeDriver(){
         //if driver is already being used(pointing an object)
            if(driver!=null) { // if driver is pointing anywhere
                driver.quit(); //quit when I call closeDriver
                driver=null; //make the driver null so when we call getDriver(), we can  open the driver again
            }
        }


}
