package cl.steps_definitions;

import cl.cucumber.TestContext;
import cl.page_objects.TestPageObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class TestSteps {
    private TestPageObject testPageObject;
    private TestContext testContext;

    public TestSteps(TestContext testContext) {
        this.testContext = testContext;
        testPageObject = testContext.getPageObjectManager().getTestPage();
    }

    @Given("Enter to test")
    public void enter_to_test() throws Exception{
        testPageObject.navigateToURL();
    }
    @Then("Do things")
    public void do_things() throws Exception {
        testPageObject.nope();
        testPageObject.openSaved();
    }


}