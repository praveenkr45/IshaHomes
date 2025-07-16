package testBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import utilities.ExtentReportManager;

public class BaseClass {

	public static WebDriver driver;
	public static ExtentReports extent;
	public static String browserName;
	

	// Setup method runs before tests start

	@BeforeTest
	@Parameters({"browser"})
	public void setup(String br)
	{

		// Initialize Extent Report
		extent = ExtentReportManager.getInstance(br);

		browserName=br;

		// Launch browser based on parameter

		switch(br.toLowerCase())
		{
		case "chrome": 
			driver=new ChromeDriver(); 
			break;
		case "edge" : 
			driver=new EdgeDriver();
			break;
		default: 
			System.out.println("Invalid browser");
			return;
		}
		

		// Basic browser setup

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://ishahomes.com/");
		driver.manage().window().maximize();

	}
	

	// Tear down method runs after all tests
	@AfterTest
	public void tearDown()
	{
		// Flush Extent Report and close browser
		if (extent != null) extent.flush();
		if (driver != null) driver.quit();

	}
	

}
