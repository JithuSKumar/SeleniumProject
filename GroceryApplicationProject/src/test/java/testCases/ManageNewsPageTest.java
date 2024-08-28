package testCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageFiles.LoginPage;
import pageFiles.ManageNewsPage;

public class ManageNewsPageTest extends BaseClassTest {

	LoginPage loginpage;
	ManageNewsPage manageNewsPage;

	@Test(priority = 1)
	public void verifyVManageFooterPageLoad() throws InterruptedException, IOException
	{
		loginpage = new LoginPage(driver);
		manageNewsPage = new ManageNewsPage(driver);
		loginpage.sendUsername(userName);
		loginpage.sendPassword(password);
		loginpage.signIn();
		boolean isNavigatedToHomePage = loginpage.isHomePageDisplayed();
		assertTrue(isNavigatedToHomePage,"After entering valid credentials in Login page user is not navigated to the home page");
		manageNewsPage.pageVisibilityCheck();
		String actualValueString = manageNewsPage.getBreadCrumbText();
		String expectedValue = "News"; 
		Assert.assertTrue(actualValueString.contains(expectedValue), "The breadcrumb text does not contain the expected value: " + expectedValue);
		manageNewsPage.saveDataTofile();
	}
}
