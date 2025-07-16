package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager {

    private static ExtentReports extent;

    // Returns the ExtentReports instance, creates one if not already created
    public static ExtentReports getInstance(String browserName) {
        if (extent == null) {
            createInstance(browserName);
        }
        return extent;
    }

    // Creates and configures the ExtentReports instance
    private static void createInstance(String browserName) {
    	
        // Generate timestamp for unique report file name
        String timestamp = new SimpleDateFormat("ddMMyyyy_HHmm").format(new Date());
        String reportPath = System.getProperty("user.dir") + "\\reports\\ExtentReport_" + timestamp + ".html";

        // Create and configure the Spark reporter
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
        sparkReporter.config().setReportName("Isha Homes Automation Report");
        sparkReporter.config().setDocumentTitle("Automation Test Results");

        // Attach reporter and set system info
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Tester", "Praveen Kumar");
        extent.setSystemInfo("Tested URL", "https://ishahomes.com/");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Browser", "Chrome and Edge");
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Java version", System.getProperty("java.version"));
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
    }
}
