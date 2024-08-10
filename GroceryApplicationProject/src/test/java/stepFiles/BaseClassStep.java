package stepFiles;

import org.testng.annotations.BeforeMethod;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BaseClassStep {
	
	WebDriver driver;
	
  @BeforeMethod
  public void beforeMethod() {
	  
	  driver = new ChromeDriver();
	  driver.get("https://groceryapp.uniqassosiates.com/admin/login");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
  }

  @AfterMethod
  public void afterMethod() {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
	  driver.close();
  }

}
