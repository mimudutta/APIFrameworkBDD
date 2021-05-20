package BDD.APIFrameworkBDD.cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/BDD/APIFrameworkBDD/Features",
					glue = {"BDD.APIFrameworkBDD.StepDefination"},
					tags = "@Regression",
					//tags="@createOrder or @canclePayout",
					plugin = {//"pretty",
							  	"junit:target/MyReports/report.xml",
							    "html:target/MyReports/report.html",
								"json:target/MyReports/cucumber.json"}
					//publish = true,
					//monochrome = true
					//dryRun = true
					)

public class TestRunner {

}
