package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import elementRepository.HomePage;
import elementRepository.LoginPage;

public class HomePageTest extends BaseClass {
	
	
	LoginPage loginpage;
	HomePage homePage;


	@Test
	public void validDataLogin()
	{
		loginpage = new LoginPage(driver);
		homePage = new HomePage(driver);
		loginpage.sendUsername("admin");
		loginpage.sendPassword("admin");
		loginpage.signIn();
		String actual = homePage.getDashboardText();
		System.out.println("Successful Login: " + actual);
		String expected = "Dashboard";
		Assert.assertEquals(actual, expected, "Home Page text displayed upon successful login.");
	}
	
	
}
