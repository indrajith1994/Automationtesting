package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {
    public static WebDriver driver;
    @Before
    public void beforeScenario(){
        System.out.println("This will run before the Scenario");
    }



    @After
    public void afterScenario(){

        System.out.println("This will run after the Scenario");
    }
}
