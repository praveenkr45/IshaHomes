package testCases;

import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.ScreenShot;

public class TC_001_NavigateToCompletedProject extends BaseClass {

    ExtentTest test;

    @Test
    public void navigate() throws InterruptedException {

        // Start the test report
        test = extent.createTest("Navigate to Completed Projects - " + browserName);

        HomePage hp = new HomePage(driver);

        // Wait for page to load
        Thread.sleep(2000);

        // Close any pop-ups
        test.info("Closing pop-ups");
        hp.closePopUp1();
        hp.closePopUp2();

        // Click on Completed Projects
        test.info("Clicking on Completed Projects");
        hp.clickComProj();
        
        // Waiting for page to load and Again Closing PopUp
        Thread.sleep(1000);
        hp.closePopUp2();
        
        // Take screenshot
        String projectPath = System.getProperty("user.dir") + "\\screenshots";
        ScreenShot.captureScreenshot(driver, "navigate_completed_projects", projectPath);

        // Log success and attach screenshot
        test.pass("Navigation successful");
        test.addScreenCaptureFromPath(projectPath + "/navigate_completed_projects_" + ScreenShot.getTimestamp() + ".png");
    }
}
