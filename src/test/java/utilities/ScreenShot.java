package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShot {

    // Generates a timestamp string for unique file naming
    public static String getTimestamp() {
        return new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
    }

    // Captures a screenshot and saves it to the specified folder
    public static String captureScreenshot(WebDriver driver, String baseFileName, String folderPath) {
       
    	// Take screenshot and store it as a file
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);

        // Create folder if it doesn't exist
        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        // Build the destination file path with timestamp
        String timestamp = getTimestamp();
        String fileName = baseFileName + "_" + timestamp + ".png";
        File dest = new File(folderPath + File.separator + fileName);

        // Copy screenshot file to destination
        try {
            Files.copy(src.toPath(), dest.toPath());
            return dest.getAbsolutePath(); // Return full path of saved screenshot
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Return null if saving fails
        }
    }
}
