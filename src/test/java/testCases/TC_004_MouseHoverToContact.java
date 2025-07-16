package testCases;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.ScreenShot;
import com.aventstack.extentreports.ExtentTest;

public class TC_004_MouseHoverToContact extends BaseClass {

    ExtentTest test;

    @Test
    public void mouseHover() throws InterruptedException {
        // Start the test report
        test = extent.createTest("Mouse Hover to Contact - " + browserName);

        HomePage hp = new HomePage(driver);
        
        Actions act = new Actions(driver);

        // Perform mouse hover to 'More' and then to 'Contact'
        test.info("Performing mouse hover to 'More' and then to 'Contact'");
        act.moveToElement(hp.moveToMore()).moveToElement(hp.moveToContact()).perform();

        // Capture screenshot
        String projectPath = System.getProperty("user.dir") + "\\screenshots";
        String screenshotPath = ScreenShot.captureScreenshot(driver, "mouse_hover_contact", projectPath);
        test.addScreenCaptureFromPath(screenshotPath);

        // Click on Contact
        hp.clickContact();

        test.pass("Mouse hover and click on Contact completed successfully");
    }
}
