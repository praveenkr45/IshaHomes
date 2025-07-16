package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.ScreenShot;
import com.aventstack.extentreports.ExtentTest;

public class TC_006_ReadAndDisplayEmail extends BaseClass {

    ExtentTest test;

    @Test
    public void displayEmail() throws InterruptedException {
        // Start the test report
        test = extent.createTest("Read and Display Email Address - " + browserName);

        HomePage hp = new HomePage(driver);

        // Scroll down to bring the email element into view
        test.info("Scrolling to email element");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)", "");
        
        Thread.sleep(1000); // Wait for scroll to complete

        // Fetch and display the email address
        String email = hp.fetchEmail();
        System.out.println("Email Address for Contact: " + email);
        test.pass("Email Address for Contact: " + email);

        // Capture screenshot for reference
        String projectPath = System.getProperty("user.dir") + "\\screenshots";
        String screenshotPath = ScreenShot.captureScreenshot(driver, "email_visible", projectPath);
        test.addScreenCaptureFromPath(screenshotPath);
    }
}
