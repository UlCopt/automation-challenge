package cl.steps_definitions;

import cl.cucumber.TestContext;
import cl.page_objects.MyProfilePage;

public class MyProfileSteps {

    private MyProfilePage myProfilePage;
    private TestContext testContext;

    public MyProfileSteps(TestContext testContext) {
        this.testContext = testContext;
        myProfilePage = testContext.getPageObjectManager().getMyProfilePage();
    }
}
