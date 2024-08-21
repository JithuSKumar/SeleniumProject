/*
 * package pageFiles;
 * 
 * import java.io.IOException;
 * 
 * import org.openqa.selenium.By; import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.WebElement; import org.openqa.selenium.support.FindBy;
 * import org.openqa.selenium.support.PageFactory;
 * 
 * import utilities.GeneralUtilities; import utilities.ScreenShotUtilities;
 * 
 * public class LoginPage {
 * 
 * //WebElement + functions in this page WebDriver driver; GeneralUtilities
 * generalUtilities = new GeneralUtilities(); ScreenShotUtilities
 * screenShotUtilities = new ScreenShotUtilities(); String pageTitle;
 * 
 * public LoginPage(WebDriver driver) { this.driver = driver;
 * PageFactory.initElements(driver, this);//with pageFactory this.pageTitle =
 * driver.getTitle(); }
 * 
 * //Locating element using page factory
 * 
 * @FindBy(name="username")WebElement userNameElement;
 * 
 * @FindBy(xpath = "//button[text()='Sign In']")WebElement signInElement;
 * 
 * @FindBy(xpath = "//a[@data-toggle='dropdown']")WebElement userIconElement;
 * 
 * @FindBy(xpath="//h5[text()=\" Alert!\"]")WebElement loginErrorMessagElement;
 * 
 * @FindBy(xpath = "//li[text()='Dashboard']") WebElement homePage;
 * 
 * //Locating element without page factory By passwordElement
 * =By.name("password");
 * 
 * public void sendUsername(String userName) {
 * userNameElement.sendKeys(userName); }
 * 
 * public void sendPassword(String password) throws IOException {
 * driver.findElement(passwordElement).sendKeys(password);
 * screenShotUtilities.captureScreenShot(driver, pageTitle); }
 * 
 * public void signIn() throws IOException { signInElement.click();
 * screenShotUtilities.captureScreenShot(driver, "pageTitle"); }
 * 
 * 
 * public String getErrorMessage() { return
 * generalUtilities.getTextElement(loginErrorMessagElement); }
 * 
 * public boolean isHomePageDisplayed() { return homePage.isDisplayed(); } }
 */

package pageFiles;

import java.io.IOException;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.ScreenShotUtilities;

public class LoginPage {

    WebDriver driver;
    GeneralUtilities generalUtilities = new GeneralUtilities();
    ScreenShotUtilities screenShotUtilities = new ScreenShotUtilities();
    String pageTitle;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        
    }
    
    public void pageTitle()
    {
    	this.pageTitle = driver.getTitle().replaceAll("[^a-zA-Z0-9\\.\\-]", "_");
    }

    // Locating elements using PageFactory
    @FindBy(name = "username") WebElement userNameElement;
    @FindBy(name = "password") WebElement passwordElement; // Changed to use PageFactory
    @FindBy(xpath = "//button[text()='Sign In']") WebElement signInElement;
    @FindBy(xpath = "//a[@data-toggle='dropdown']") WebElement userIconElement;
    @FindBy(xpath = "//h5[text()=' Alert!']") WebElement loginErrorMessagElement;
    @FindBy(xpath = "//li[text()='Dashboard']") WebElement homePage;

    public void sendUsername(String userName) {
        userNameElement.sendKeys(userName);
    }

    public void sendPassword(String password) {
        passwordElement.sendKeys(password);
    }

    public void signIn() {
        signInElement.click();
        try {
            screenShotUtilities.captureScreenShot(driver, pageTitle);
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    public String getErrorMessage() {
        return generalUtilities.getTextElement(loginErrorMessagElement);
    }

    public boolean isHomePageDisplayed() {
        return homePage.isDisplayed();
    }
}
