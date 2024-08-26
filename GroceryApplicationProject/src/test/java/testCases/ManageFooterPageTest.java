package testCases;

import static org.testng.Assert.assertTrue;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageFiles.LoginPage;
import pageFiles.ManageFooterPage;

public class ManageFooterPageTest extends BaseClassTest {

	LoginPage loginpage;
	ManageFooterPage manageFooterPage;

	@Test(priority = 1)
	public void verifyVManageFooterPageLoad() throws InterruptedException, IOException
	{
		loginpage = new LoginPage(driver);
		manageFooterPage = new ManageFooterPage(driver);
		loginpage.sendUsername(userName);
		loginpage.sendPassword(password);
		loginpage.signIn();
		boolean isNavigatedToHomePage = loginpage.isHomePageDisplayed();
		assertTrue(isNavigatedToHomePage,"After entering valid credentials in Login page user is not navigated to the home page");
		manageFooterPage.pageVisibilityCheck();
		String actualValueString = manageFooterPage.getBreadCrumbText();
		String expectedValue = "Footer"; 
		Assert.assertTrue(actualValueString.contains(expectedValue), "The breadcrumb text does not contain the expected value: " + expectedValue);
		
		manageFooterPage.saveDataTofile();
	}
	
}