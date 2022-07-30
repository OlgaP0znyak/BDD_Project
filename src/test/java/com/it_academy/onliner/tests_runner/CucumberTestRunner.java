package com.it_academy.onliner.tests_runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "pretty",
        monochrome = true,
        glue = "com.it_academy.onliner.steps",
        features = "classpath:com.it_academy.onliner.features"
)

public class CucumberTestRunner {

}
