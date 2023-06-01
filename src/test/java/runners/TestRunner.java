package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/test/resources/featureFiles"},
        glue = {"stepsDefinition", "hooks"},
          plugin = {
                  "pretty",
                  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
          },
        tags = "@Run"
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
