package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:reports/", "json:reports/cucumber.json"},
        features = {"src/test/resources/features/"},
        glue = {"com.regression.steps", "runner"}
)

public class StepsRunner {
}
