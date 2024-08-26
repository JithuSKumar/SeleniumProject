package testCases;

import static org.testng.Assert.assertTrue;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageFiles.LoginPage;
import pageFiles.ManageContactPage;

public class ManageContactPageTest extends BaseClassTest {

	LoginPage loginpage;
	ManageContactPage manageContactPage;

	@Test(priority = 1)
	public void verifyVManageContactPageLoad() throws InterruptedException, IOException
	{
		loginpage = new LoginPage(driver);
		manageContactPage = new ManageContactPage(driver);
		loginpage.sendUsername(userName);
		loginpage.sendPassword(password);
		loginpage.signIn();
		boolean isNavigatedToHomePage = loginpage.isHomePageDisplayed();
		assertTrue(isNavigatedToHomePage,"After entering valid credentials in Login page user is not navigated to the home page");
		manageContactPage.pageVisibilityCheck();
		manageContactPage.getBreadCrumbText();
		String actualValueString = manageContactPage.getBreadCrumbText();
		String expectedValue = "Contact";
		Assert.assertTrue(actualValueString.contains(expectedValue), "The breadcrumb text does not contain the expected value: " + expectedValue);
		manageContactPage.saveDataTofile();
	}
	
}