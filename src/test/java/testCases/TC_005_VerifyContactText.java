package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.ScreenShot;
import com.aventstack.extentreports.ExtentTest;

public class TC_005_VerifyContactText extends BaseClass {

    ExtentTest test;

    @Test
    public void verify_ContactUs() throws InterruptedException {
        // Start the test report
        test = extent.createTest("Verify 'CONTACT US' Text - " + browserName);

        HomePage hp = new HomePage(driver);
        Thread.sleep(2000); // Wait for page to load

        // Close pop-up if present
        test.info("Closing pop-up");
        hp.closePopUp2();

        // Verify the 'CONTACT US' text on the page
        test.info("Verifying 'CONTACT US' text on the page");
        String actualText = hp.checkTextContact();
        Assert.assertEquals(actualText, "CONTACT US", "Text does not match");

        // Log success message
        test.pass("Verified 'CONTACT US' text successfully: " + actualText);

        // Capture screenshot for evidence
        String projectPath = System.getProperty("user.dir") + "\\screenshots";
        String screenshotPath = ScreenShot.captureScreenshot(driver, "verify_contact_text", projectPath);
        test.addScreenCaptureFromPath(screenshotPath);
    }
}
