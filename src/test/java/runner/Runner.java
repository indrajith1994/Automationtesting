package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="/Users/indrajit/IdeaProjects/Automationtesting/features/demo.feature",
        glue={"stepDefinition","demosite"},
        plugin = {
                "pretty", "html:test-output", "json:target/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
//        "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"
//        "pretty"
//                , "json:target/cucumber-reports/Cucumber.json"
//              , "junit:target/cucumber-reports/Cucumber.xml"
//              , "html:target/cucumber-reports/Cucumber.html"
                },
        tags = "@CreateTest",
        monochrome = true //display the console output in a proper readable format
)
public class Runner {

}
