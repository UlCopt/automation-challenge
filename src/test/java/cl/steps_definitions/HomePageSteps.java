package cl.steps_definitions;

import cl.cucumber.TestContext;
import cl.page_objects.CreateAccountPage;
import cl.page_objects.HomePage;
import io.cucumber.java.en.Given;


public class HomePageSteps {
    private HomePage homePage;
    private CreateAccountPage createAccountPage;
    private TestContext testContext;

    public HomePageSteps(TestContext testContext) {
        this.testContext = testContext;
        homePage = testContext.getPageObjectManager().getHomePage();
        createAccountPage = testContext.getPageObjectManager().getCreateAccountPage();
    }

    @Given("Enter to Carnival")
    public void enter_to_carnival() throws Exception {
        homePage.navigateToURL();
        homePage.takeScreenshot("enterCarnival");
        homePage.nope();
        homePage.takeScreenshot("NoThanks");
    }




}