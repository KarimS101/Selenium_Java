package Runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/Test/resources/Features",   // Path to your .feature files
        glue = "Step_Definitions",                   // Package containing step definitions
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",    // HTML report
                "json:target/cucumber.json",             // JSON report
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true,                          // Better console output
        tags = "@Smoke_Test_1",
        publish = false                             // Set to true if you want to publish reports to cucumber.io
)
public class TestRunner {
}
