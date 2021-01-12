package stepDefinition;

import com.aventstack.extentreports.model.Test;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import util.TestBase;


public class Hooks  extends TestBase {
    @Before
    public void beforeScenario(){

        System.out.println("This will run before the Scenario");
    }

    @After
//    public void afterScenario(){
    public void afterScenario(Scenario scenario){
        if (scenario.isFailed()) {
            byte[] src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.log(scenario.getName() + "is failed");
            scenario.attach(src,"image/png", scenario.getName() +".png");
        }
        System.out.println("This will run after the Scenario");
        driver.quit();
    }

}
