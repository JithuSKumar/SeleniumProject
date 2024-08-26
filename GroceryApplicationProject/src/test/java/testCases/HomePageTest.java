package testCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageFiles.HomePage;
import pageFiles.LoginPage;

public class HomePageTest extends BaseClassTest {
	
	
	LoginPage loginpage;
	HomePage homePage;
	
	@Test
	public void verifyTheUserAbleToLoginWithValidCredentials() throws IOException
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
