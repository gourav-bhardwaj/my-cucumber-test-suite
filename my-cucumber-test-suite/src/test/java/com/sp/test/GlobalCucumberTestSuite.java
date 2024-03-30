package com.sp.test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.sp.test",
        dryRun = false,
        plugin = {
                "pretty",
                "html:target/cucumber-reports/greeting.html",
                "json:target/cucumber-reports/greeting.json"
        },
        monochrome = true
)
public class GlobalCucumberTestSuite {

}
