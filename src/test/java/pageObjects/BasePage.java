package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	WebDriver driver;

    // Constructor to initialize WebDriver and page elements

	public BasePage(WebDriver driver)
	{
		this.driver=driver;

		// Initialize all WebElements in the page using PageFactory
		PageFactory.initElements(driver,this);
	}
}

