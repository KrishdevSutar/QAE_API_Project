package com.fdmgroup.stepdefitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "src/test/resources/Features",
	glue = "com.fdmgroup.stepdefitions",
	plugin = {
			"pretty",
			"json:Reports/cucumber.json",
			"junit:Reports/cucumber.junit",
			"html:Reports/cucumber.html"
	},
	publish = true
)
public class TestRunner {

}
