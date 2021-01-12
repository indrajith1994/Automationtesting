package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ChartsPage;
import pages.RegistrationPage;
import pages.WebtablePage;
import util.TestBase;

public class demosite extends TestBase{
    RegistrationPage regpage = new RegistrationPage();
    WebtablePage wtpage = new WebtablePage();
    ChartsPage cpage = new ChartsPage();

//    @Given("Navigate register-user page")
//    public void navigateRegisterUserPage() {
//        TestBase.initialization();
//    }
//
//    @When("Fill user details")
//    public void fillUserDetails() throws InterruptedException {
//        regpage.RegLink();
//        regpage.enterdetails();
//        Thread.sleep(2000);
//    }
//
//    @Then("Click register and validate in webtable")
//    public void clickRegisterAndValidateInWebtable() throws InterruptedException {
//        regpage.submit();
//        Thread.sleep(5000);
//        Thread.sleep(5000);
//        TestBase.terminate();
//    }

//    @Given("Navigate to web tables")
//    public void navigateToWebTables() {
//        TestBase.initialization();
//    }
//
//    @When("Edit button double click and update phone number")
//    public void editButtonDoubleClickAndUpdatePhoneNumber() throws InterruptedException {
//        wtpage.WebtableLink();
//        wtpage.edit();
//        Thread.sleep(5000);
//    }
//
//    @Then("Validate if new number is saved")
//    public void validateIfNewNumberIsSaved() {
//        TestBase.terminate();
//    }

//    @When("Get the webtable data and click topmenu to check sorted")
//    public void getTheWebtableDataAndClickTopmenuToCheckSorted() throws InterruptedException {
//        wtpage.WebtableLink();
//        wtpage.SortTable("Firstname");
//        wtpage.SortTable("Lastname");
//        wtpage.SortTable("Phone");
//        Thread.sleep(5000);
//    }

//    @Then("Validate sorted data")
//    public void validateSortedData() {
//        TestBase.terminate();
//    }
//
//    @When("Navigate to charts page")
//    public void navigateToChartsPage() {
//        cpage.ChartsLink();
//    }
//
//    @Then("Print the available data")
//    public void printTheAvailableData() {
//        cpage.chartdetails();
//        TestBase.terminate();
//    }
//
//    @When("Delete user from the webtable")
//    public void deleteUserFromTheWebtable() throws InterruptedException {
//        wtpage.WebtableLink();
//        Thread.sleep(3000);
//        wtpage.deletedata(2);
//        Thread.sleep(3000);
//    }
//    @Then("Validate")
//    public void validate() {
//        System.out.println("Deleted");
//        TestBase.terminate();
//    }


}

