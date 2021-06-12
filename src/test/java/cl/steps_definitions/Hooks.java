package cl.steps_definitions;

import cl.cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    TestContext testContext;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @Before
    public void beforeScenario() throws Exception {

    }

    @After
    public void afterScenario() throws Exception {
        testContext.getWebDriverManager().closeDriver();

    }
}
