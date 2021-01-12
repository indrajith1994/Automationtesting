package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RegistrationPage;
import util.TestBase;

public class Registration extends TestBase {
    RegistrationPage regpage = new RegistrationPage();
    @Given("Navigate register-user page")
    public void navigateRegisterUserPage() {
        TestBase.initialization();
    }

    @When("Fill user details")
    public void fillUserDetails() throws InterruptedException {
        regpage.RegLink();
        regpage.enterdetails();
        Thread.sleep(2000);
    }

    @Then("Click register and validate in webtable")
    public void clickRegisterAndValidateInWebtable() throws InterruptedException {
        regpage.submit();
        Thread.sleep(5000);
        Thread.sleep(5000);
        TestBase.terminate();
    }


}
