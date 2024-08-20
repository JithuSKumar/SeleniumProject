package stepFiles;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import pageFiles.HomePage;
import pageFiles.LoginPage;
import utilities.ScreenShotUtilities;

public class LoginPageStep extends BaseClassStep {

	LoginPage loginpage;
	HomePage homePage;
	ScreenShotUtilities screenShotUtilities;

	@Test
	public void validDataLogin() throws IOException
	{
		loginpage = new LoginPage(driver);
		homePage = new HomePage(driver);
		loginpage.sendUsername("admin");
		loginpage.sendPassword("admin");
		screenShotUtilities.captureScreenShot(driver, userName);
		loginpage.signIn();
		String actual = homePage.getDashboardText();
		System.out.println("Successful Login: " + actual);
		String expected = "Dashboard";
		Assert.assertEquals(actual, expected, Constant.loginPageStep_validDataLogin);
	}

	@Test(dataProvider = "dp")
	public void inValidDataLogin(String userName, String password) throws IOException 
	{
		loginpage = new LoginPage(driver);
		loginpage.sendUsername(userName);
		loginpage.sendPassword(password);
		loginpage.signIn();
		screenShotUtilities.captureFailureScreenShot(driver, userName);
		String actual = loginpage.getErrorMessage();
		System.out.println("Login Error Message: "+actual);
		String expected = "Alert!";
		Assert.assertEquals(actual, expected, Constant.loginPageStep_inValidDataLogin);
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] {
			{"admin", "apple" }, {"efd", "admin"}, {"admi","admi"}};
	}


}
