package BDD.APIFrameworkBDD.cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/BDD/APIFrameworkBDD/Features",
					glue={"BDD.APIFrameworkBDD.StepDefination"})

public class TestRunner {

}
