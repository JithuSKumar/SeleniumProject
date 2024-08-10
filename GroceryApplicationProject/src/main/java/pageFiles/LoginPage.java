package pageFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class LoginPage {

	//WebElement + functions in this page
	WebDriver driver;
	GeneralUtilities generalUtilities = new GeneralUtilities();

	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);//with pageFactory
	}

	//Locating element using page factory
	@FindBy(name="username")WebElement userNameElement;
	@FindBy(xpath = "//button[text()='Sign In']")WebElement signInElement;
	@FindBy(xpath = "//a[@data-toggle='dropdown']")WebElement userIconElement;
	@FindBy(xpath="//h5[text()=\" Alert!\"]")WebElement loginErrorMessagElement;
	@FindBy(xpath = "//li[text()='Dashboard']") WebElement homePage;

	//Locating element without page factory
	By passwordElement =By.name("password");

	public void sendUsername(String userName)
	{
		userNameElement.sendKeys(userName);
	}

	public void sendPassword(String password)
	{
		driver.findElement(passwordElement).sendKeys(password);
	}

	public void signIn() 
	{
		signInElement.click();
	}


	public String getErrorMessage()
	{
		return generalUtilities.getTextElement(loginErrorMessagElement);
	}

	public boolean isHomePageDisplayed() {
		return homePage.isDisplayed();
	}
}
