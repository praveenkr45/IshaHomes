package testCases;

import org.testng.annotations.Test;
import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.ScreenShot;
import com.aventstack.extentreports.ExtentTest;

public class TC_003_DisplayEnquirePage extends BaseClass {

    ExtentTest test;

    @Test
    public void displayEnquireNow() throws InterruptedException {
        // Start the test report
        test = extent.createTest("Display Enquire Now Page - " + browserName);

        HomePage hp = new HomePage(driver);
        Thread.sleep(2000); // Wait for page to load

        // Click on Enquire Now button
        test.info("Clicking on Enquire Now button");
        hp.clickEnquireNow();
              
        // Capture screenshot
        String projectPath = System.getProperty("user.dir") + "\\screenshots";
        String screenshotPath = ScreenShot.captureScreenshot(driver, "enquire_now_display", projectPath);
        test.addScreenCaptureFromPath(screenshotPath);

        Thread.sleep(2000); // Wait before closing popup

        // Close Enquire Now popup
        test.info("Closing Enquire Now popup");
        
        hp.closeEnquireNow();
        
        test.pass("Enquire Now popup displayed and closed successfully");
    }
}
