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
    public void afterScenario(Scenario scenario){
        try {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            if (scenario.isFailed()) {
                scenario.log("this is my failure message");
                TakesScreenshot ts = (TakesScreenshot) driver;
                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", screenshotName);
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
        System.out.println("This will run after the Scenario");
    }
}
