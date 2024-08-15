package stepFiles;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageFiles.LoginPage;
import pageFiles.ManageMenuPage;
import utilities.ExcelUtility;

public class ManageMenuPageSteps extends BaseClassStep{
	
	LoginPage loginpage;
	ManageMenuPage manageMenuPage;
	
	String userName = ExcelUtility.getString(1, 0,"LoginPage");
	String password = ExcelUtility.getString(1, 1,"LoginPage");
	String menuName = ExcelUtility.getString(1, 0,"ManageMenu");
	String parentMenu = ExcelUtility.getString(1, 1,"ManageMenu");
	String url =  ExcelUtility.getString(1, 2,"ManageMenu");
	String favIcon =  ExcelUtility.getString(1, 3,"ManageMenu"); 
	String tableValue =  ExcelUtility.getString(1, 4,"ManageMenu");
	String fileValue =  ExcelUtility.getString(1, 5,"ManageMenu");
	String colourValue =  ExcelUtility.getString(1, 6,"ManageMenu");
  @Test
  public void verifyIfManageMenuListIsLoaded() {
	  
	  	loginpage = new LoginPage(driver);
	  	manageMenuPage = new ManageMenuPage(driver);
		loginpage.sendUsername(userName);
		loginpage.sendPassword(password);
		loginpage.signIn();
		manageMenuPage.managePageSelection();
		manageMenuPage.managePageListVisibility();
		boolean actualTableStatus = manageMenuPage.managePageListVisibility();
		Assert.assertEquals(actualTableStatus, true, "Manage Menu table list is not displayed.");
  }
  
  @Test
  public void createNewMenuItem()
  {
	  	loginpage = new LoginPage(driver);
	  	manageMenuPage = new ManageMenuPage(driver);
		loginpage.sendUsername(userName);
		loginpage.sendPassword(password);
		loginpage.signIn();
		manageMenuPage.managePageSelection();
		manageMenuPage.creatingNewMenu(menuName, parentMenu, url, favIcon, tableValue, fileValue, colourValue);
  }
}
