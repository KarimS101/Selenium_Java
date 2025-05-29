package Utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

public class ScreenShots {
    public static String captureScreenshot(WebDriver driver, String scenarioName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destPath = "target/screenshots/" + scenarioName + "_" + UUID.randomUUID() + ".png";
        File dest = new File(destPath);

        try {
            Files.createDirectories(dest.getParentFile().toPath());
            Files.copy(src.toPath(), dest.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destPath;
    }
}
