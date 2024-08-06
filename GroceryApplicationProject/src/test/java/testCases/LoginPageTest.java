package testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import elementRepository.LoginPage;

public class LoginPageTest extends BaseClass {

	LoginPage login;


	@Test
	public void validDataLogin() 
	{
		login = new LoginPage(driver);
		login.sendUsername();
		login.sendPassword();
		login.signIn();
		System.out.println("ValidDataLogin Method");
	}

	public void inValidDataLogin()
	{
		login = new LoginPage(driver);
		login.inValidSignIn("test", "test");
		System.out.println("inValidDataLogin Method");
	}


	
	@Test(dataProvider = "dp")
	public void inValidUsernameLogin(String username, String password)
	{
		login = new LoginPage(driver);
		login.inValidUserSign(username,password);
		System.out.println("inValidUsernameLogin Method with username: " + username + " and password: " + password);
	}
	@DataProvider
	public Object[][] dp() {
		return new Object[][] {
			{"abc", "apple" }, {"efd", "ball"}, {"cat", "cat"}, {"admin","admin"}};
	}
}
