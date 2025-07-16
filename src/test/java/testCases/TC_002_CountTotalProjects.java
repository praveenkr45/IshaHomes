package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.ScreenShot;

import com.aventstack.extentreports.ExtentTest;

public class TC_002_CountTotalProjects extends BaseClass {

    ExtentTest test;

    @Test
    public void count_project() throws InterruptedException {
        // Start the test report
        test = extent.createTest("Count Total Completed Projects - " + browserName);

        HomePage hp = new HomePage(driver);

        // Scroll down to the completed projects section
        test.info("Scrolling to completed projects section");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,4300)", "");
        
        //Slowing down the process
        Thread.sleep(1000);

        // Count total completed projects
        int totalProjects = hp.countTotalProject().size();
        test.pass("Total Completed Projects: " + totalProjects);
        System.out.println("Total Completed Projects: " + totalProjects);

        // Log and print first 5 project names
        test.info("Listing first 5 completed projects:");
        for (int i = 0; i < Math.min(5, totalProjects); i++) {
            String projectName = hp.countTotalProject().get(i).getText();
            test.info((i + 1) + ". " + projectName);
            System.out.println((i + 1) + ". " + projectName);
        }

        // Capture screenshot
        String projectPath = System.getProperty("user.dir") + "\\screenshots";
        String screenshotPath = ScreenShot.captureScreenshot(driver, "completed_projects_list", projectPath);
        test.addScreenCaptureFromPath(screenshotPath);
    }
}
