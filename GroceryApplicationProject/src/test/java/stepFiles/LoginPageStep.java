package stepFiles;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageFiles.HomePage;
import pageFiles.LoginPage;

public class LoginPageStep extends BaseClassStep {

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

	@Test(dataProvider = "dp")
	public void inValidDataLogin(String userName, String password) 
	{
		loginpage = new LoginPage(driver);
		loginpage.sendUsername(userName);
		loginpage.sendPassword(password);
		loginpage.signIn();
		String actual = loginpage.getErrorMessage();
		System.out.println("Login Error Message: "+actual);
		String expected = "Alert!";
		Assert.assertEquals(actual, expected, "The login message is not as expected.");
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] {
			{"admin", "apple" }, {"efd", "admin"}, {"admi","admi"}};
	}


}
