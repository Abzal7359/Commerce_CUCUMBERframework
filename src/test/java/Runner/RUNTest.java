package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/java/Features/Loginss.feature","src/test/java/Features/CustomerADD.feature"},
		glue = {"StepDefinations"},
		
		dryRun = false,
		plugin = {"pretty","html:target/CucumberReport.html"}
		)
public class RUNTest extends AbstractTestNGCucumberTests {

}
