package Step_Definitions;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import Utils.Drivers;
import Utils.ScreenShots;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Hooks {
    WebDriver driver = Drivers.getDriver();

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotPath = ScreenShots.captureScreenshot(driver, scenario.getName());

            // Attach to Cucumber report
            try {
                scenario.attach(
                        Files.readAllBytes(new File(screenshotPath).toPath()),
                        "image/png",
                        "Failure Screenshot"
                );
            } catch (IOException e) {
                e.printStackTrace();
            }

            // For ExtentReports (automatically picked up if using their adapter)
            System.setProperty("extent.reporter.spark.logScreenshotOnFail", "true");
        }

        Drivers.quitDriver();
    }
}
