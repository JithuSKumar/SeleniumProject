package stepFiles;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.ExcelUtility;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class BaseClassStep {
	
	WebDriver driver;
	
	String userName = ExcelUtility.getString(1, 0,"LoginPage");
	String password = ExcelUtility.getString(1, 1,"LoginPage");
	
  @BeforeMethod
  @Parameters("Browser")
  public void beforeMethod(String browserName)
  {
	  if (browserName.equals("chrome"))
	  {
		  driver = new ChromeDriver();
	  }
	  else if (browserName.equals("firefox"))
	  {
		  driver = new FirefoxDriver();
	  }
	  driver.get("https://groceryapp.uniqassosiates.com/admin/login");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
  }

  @AfterMethod
  public void afterMethod() 
  {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
	  driver.close();
  }

}
