package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static Properties prop;


    public TestBase(){
        try{
            prop = new Properties();
            FileInputStream fs = new FileInputStream("/Users/indrajit/IdeaProjects/Automationtesting/src/test/java/config/config.properties");
            prop.load(fs);
        }catch(IOException e){
            e.getMessage();
        }
    }

    public static void initialization(){
        String browserName = prop.getProperty("browser");

        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
    }



    public static void terminate(){

//        driver.manage().deleteAllCookies();
//        driver.quit();
    }


}
