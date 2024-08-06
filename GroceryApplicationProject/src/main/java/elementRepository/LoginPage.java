package elementRepository;


import java.time.Duration;

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

	//@FindBy(name ="password")
	//WebElement passwordElement;

	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signInElement;

	//Locating element without page factory
	By passwordElement =By.name("password");

	public void sendUsername()
	{
		userNameElement.sendKeys("admin");
	}

	public void sendPassword()
	{
		driver.findElement(passwordElement).sendKeys("admin");
	}

	public void signIn()
	{
		signInElement.click();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		//System.out.println("Wait period completed after login");
	}

	public void inValidSignIn(String userNmaeString, String passwordString)
	{
		userNameElement.sendKeys(userNmaeString);
		driver.findElement(passwordElement).sendKeys(passwordString);
		signInElement.click();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		//System.out.println("Wait period completed after login");
	}

	public void inValidUserSign(String userName, String password)
	{
		userNameElement.sendKeys(userName);
		driver.findElement(passwordElement).sendKeys(password);
		signInElement.click();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		//System.out.println("Wait period completed after login");
	}


}
