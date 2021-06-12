package cl.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumberOptions"},
        features = "src/test/java/cl/features",
        glue = "cl/steps_definitions",
        dryRun = true,
        monochrome = true
)

public class TestRunner {

}
