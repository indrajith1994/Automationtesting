package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="/Users/indrajit/IdeaProjects/Automationtesting/features/demo.feature",
        glue={"stepDefinition","demosite"},
        plugin = {
                "pretty", "html:test-output", "json:target/cucumber.json",
                },
        tags = "@CreateTest",
        monochrome = true //display the console output in a proper readable format
)
public class Runner {

}
