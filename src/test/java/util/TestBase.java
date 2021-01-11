package util;

import com.relevantcodes.extentreports.ExtentReports;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static Properties prop;
    static ExtentReports e;

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

        e = new ExtentReports("/Users/indrajit/IdeaProjects/Automationtesting/target/cucumber-reports/report.html");
        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
    }

    private static String getReportConfigPath(){
        String reportConfigPath = prop.getProperty("reportConfigPath");
        if(reportConfigPath!= null) return reportConfigPath;
        else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
    }

    public static void terminate(){
//        getReportConfigPath();
        e.flush();
        driver.quit();
    }
}
