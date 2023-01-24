package dt_project.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    //This class reads the configuration.properties file ---> one file
    //Create Properties instance
    private static Properties properties; //method static cunku calss calistiginda ilk bu method calissin diye.
    static {
        //path of the configuration file
        String path="configuration.properties";
        try {
            //Opening configuration.properties file using FileInputStream
            FileInputStream fileInputStream = new FileInputStream(path);
            properties = new Properties();
            properties.load(fileInputStream); //secilen dosya yuklenir.
            //close the file
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //This method will get the key from properties file,
    //And return the value as String
    //We create this method to read the file
    public static String getProperty(String key){ //(String key)--> properties dosyasindaki verilerin key bolumunu ifade ediyor.
        String value=properties.getProperty(key); //getProperty(key) methoduyla key in karsindaki value degeri alinir.
        return value; // return value degeridir.
    }
    //TEST IF LOGIC WORKS
//    public static void main(String[] args) {
//        System.out.println(properties.getProperty("qa_environment"));
//    }
}
