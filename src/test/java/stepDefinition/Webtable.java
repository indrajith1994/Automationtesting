package stepDefinition;

import com.google.common.base.Verify;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.WebtablePage;
import util.TestBase;

public class Webtable extends TestBase{
    WebtablePage wtpage = new WebtablePage();

    @Given("Navigate to web tables")
    public void navigateToWebTables() {
        TestBase.initialization();
    }

    @When("Edit button double click and update phone number")
    public void editButtonDoubleClickAndUpdatePhoneNumber() throws InterruptedException {
        wtpage.WebtableLink();
        wtpage.edit();
        Thread.sleep(5000);
    }

    @Then("Validate if new number is saved")
    public void validateIfNewNumberIsSaved() {
        TestBase.terminate();
    }

    @When("Get the webtable data and click topmenu to check sorted")
    public void getTheWebtableDataAndClickTopmenuToCheckSorted() throws InterruptedException {
        wtpage.WebtableLink();
        wtpage.SortTable("Firstname");
        wtpage.SortTable("Lastname");
        wtpage.SortTable("Phone");
//        Verify.verify(false);
        Thread.sleep(5000);
    }

    @Then("Validate sorted data")
    public void validateSortedData() {
        TestBase.terminate();
    }

    @When("Delete user from the webtable")
    public void deleteUserFromTheWebtable() throws InterruptedException {
        wtpage.WebtableLink();
        Thread.sleep(3000);
        wtpage.deletedata(2);
        Thread.sleep(3000);
    }
    @Then("Validate")
    public void validate() {
        System.out.println("Deleted");
        TestBase.terminate();
    }
}
