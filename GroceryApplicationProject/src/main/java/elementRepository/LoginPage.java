package elementRepository;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//WebElement + functions in this page
	WebDriver driver;

	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);//with pageFactory
	}

	public void loginPage()
	{
		WebElement userNamElement = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		userNamElement.sendKeys("admin");
	}
	

}
