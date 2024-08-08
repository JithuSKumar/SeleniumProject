package elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//WebElement + functions in this page
	WebDriver driver;

	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);//with pageFactory
	}

	//Locating element using page factory
	@FindBy(name="username")
	WebElement userNameElement;

	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signInElement;

	//Locating element without page factory
	By passwordElement =By.name("password");
	
	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement userIconElement;
	
	@FindBy(xpath="//h5[text()=\" Alert!\"]")
	WebElement loginErrorMessagElement;
	
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
		return loginErrorMessagElement.getText();
	}
}
