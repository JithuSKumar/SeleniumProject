package stepFiles;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageFiles.HomePage;
import pageFiles.LoginPage;
import utilities.ExcelUtility;

public class HomePageStep extends BaseClassStep {
	
	
	LoginPage loginpage;
	HomePage homePage;
	
	String userName = ExcelUtility.getString(1, 0,"LoginPage");
	String password = ExcelUtility.getString(1, 1,"LoginPage");

	@Test
	public void verifyTheUserAbleToLoginWithValidCredentials()
	{
		loginpage = new LoginPage(driver);
		homePage = new HomePage(driver);
		
		loginpage.sendUsername(userName);
		loginpage.sendPassword(password);
		loginpage.signIn();
		boolean isNavigatedToHomePage = loginpage.isHomePageDisplayed();
		assertTrue(isNavigatedToHomePage,"After entering valid credentials in Login page user is not navigated to the home page");
		
		String actual = homePage.getDashboardText();
		String expected = "Dashboard";
		Assert.assertEquals(actual, expected, "Home Page text displayed upon successful login.");
		
		homePage.manageProdcutStatus();
		boolean actualProductStatus = homePage.manageProdcutStatus();
		Assert.assertEquals(actualProductStatus, false, "Element selection status: ");
	}
	
	
}
