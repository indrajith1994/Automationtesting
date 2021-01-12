package stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ChartsPage;
import util.TestBase;

public class Charts extends TestBase{
    ChartsPage cpage = new ChartsPage();

    @When("Navigate to charts page")
    public void navigateToChartsPage() {
        cpage.ChartsLink();
    }

    @Then("Print the available data")
    public void printTheAvailableData() {
        cpage.chartdetails();
        TestBase.terminate();
    }
}
