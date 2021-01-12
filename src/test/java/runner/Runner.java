package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="/Users/indrajit/IdeaProjects/Automationtesting/features/demo.feature",
        glue={"stepDefinition"},
        tags = "@SortTest " ,
//                +"or @CreateTest",
        plugin = {
                "pretty"
                , "html:test-output/normal/index.html", "json:test-output/normal/cucumber.json"
                , "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
                },

        monochrome = true //display the console output in a proper readable format
)
public class Runner {

}
