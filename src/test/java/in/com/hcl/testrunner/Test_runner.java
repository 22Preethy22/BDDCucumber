package in.com.hcl.testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)	
@CucumberOptions(
features = "src/test/resources/feature",
plugin = {"pretty","html:testOutput/cucumber.html","json:testOutput/cucumber.json"},
tags="@APItest",
//features = "features",
//features = "C:\\Users\\suryakanthnag.pujar\\workspace\\HackathonDemo\\src\\main\\resource\\TestFeatures\\test.feature",
glue={"in.com.hcl.stepdefinition"}
)
public class Test_runner {

}
