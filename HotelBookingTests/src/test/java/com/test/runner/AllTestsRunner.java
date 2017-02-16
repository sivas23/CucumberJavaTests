package com.test.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(format = { "pretty", "html:target/cucumber-html-report","json:target/basicreport.json" }, 
		glue = { "com.test.steps" },
		//dryRun=true,
		features = { "classpath:stories/"}
		//,tags ={"@DeleteEntry"}
        ,monochrome=true
)


public class AllTestsRunner {
	//This is just a runner
	
}
