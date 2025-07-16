package pageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Pop-up elements
    @FindBy(id = "livprop_popup")
    WebElement popUp;

    @FindBy(id = "livchat_close")
    WebElement btnPopUp1;

    @FindBy(xpath="(//*[name()='svg'])[1]")
    WebElement btnPopUp2;

    // Navigation menu - Completed Projects
    @FindBy(xpath = "//li[@id='menu-item-25810']//a[contains(@class,'nav-link')][normalize-space()='Completed Projects']")
    WebElement menuComProj;

    // List of completed projects
    @FindBy(xpath = "//div[@id='boosted-tab-0']//div[@id='module_properties']/div//h2/a")
    List<WebElement> projects;

    // Enquire Now button and close icon
    @FindBy(xpath = "//a[normalize-space()='Enquire Now']")
    WebElement enquireNow;

    @FindBy(xpath = "//div[@id='elementor-popup-modal-32248']//i[@class='eicon-close']")
    WebElement closeEnquire;

    // Menu navigation - More > Contact Us
    @FindBy(xpath = "//a[@class='nav-link dropdown-toggle'][normalize-space()='More']")
    WebElement menuMore;

    @FindBy(xpath = "//li[@id='menu-item-24517']//a[contains(@class,'dropdown-item')][normalize-space()='Contact Us']")
    WebElement MenuContact;

    // Contact Us page heading
    @FindBy(xpath = "//div[@class='elementor-widget-container']/h1")
    WebElement contactUs;

    // Email address element
    @FindBy(xpath = "//a[normalize-space()='marketing@ishahomes.com']")
    WebElement email;

    // Close first pop-up if visible
    public void closePopUp1() {
        if (popUp.isDisplayed())
            btnPopUp1.click();
    }

    // Close second pop-up
    public void closePopUp2() {
        btnPopUp2.click();
    }

    // Click on Completed Projects menu
    public void clickComProj() {
        menuComProj.click();
    }

    // Return list of completed project elements
    public List<WebElement> countTotalProject() {
        return projects;
    }

    // Click on Enquire Now button
    public void clickEnquireNow() {
        enquireNow.click();
    }

    // Close Enquire Now popup
    public void closeEnquireNow() {
        closeEnquire.click();
    }

    // Return WebElement for 'More' menu (used for hover)
    public WebElement moveToMore() {
        return menuMore;
    }

    // Return WebElement for 'Contact Us' submenu
    public WebElement moveToContact() {
        return MenuContact;
    }

    // Click on Contact Us menu item
    public void clickContact() {
        MenuContact.click();
    }

    // Get the text of the Contact Us heading
    public String checkTextContact() {
        return contactUs.getText();
    }

    // Get the email address text
    public String fetchEmail() {
        return email.getText();
    }
}
