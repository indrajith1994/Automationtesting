package util;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
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


//    @AfterStep
//    public void takeScreenshot(Scenario scenario) {
//        if(scenario.isFailed()) {
//            byte[] src=((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//            scenario.log(scenario.getName()+ "is failed");
//            scenario.attach(src, scenario.getName()+".png", scenario.getName());
//        }
//    }
    public static void terminate(){

//        driver.manage().deleteAllCookies();
//        driver.quit();
    }


}
