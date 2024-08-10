package stepFiles;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageFiles.LoginPage;
import pageFiles.ManageCategoryPage;
import utilities.ExcelUtility;

public class ManageCategoryPageStep extends BaseClassStep {

	LoginPage loginpage;
	ManageCategoryPage manageCategoryPage;

	@Test
	public void verifyIfCategoryListisLoaded()
	{
		String userName = ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 1,"LoginPage");
		loginpage = new LoginPage(driver);
		manageCategoryPage = new ManageCategoryPage(driver);
		loginpage.sendUsername(userName);
		loginpage.sendPassword(password);
		loginpage.signIn();
		
		manageCategoryPage.categoryPageSelection();
		boolean actualTableStatus = manageCategoryPage.categoryPageSelection();
		Assert.assertEquals(actualTableStatus, true, "Category table list is not displayed.");
	}
	@Test
	public void VerifyNewCategoryCreation() throws AWTException
	{
		String userName = ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 1,"LoginPage");
		loginpage = new LoginPage(driver);
		manageCategoryPage = new ManageCategoryPage(driver);
		loginpage.sendUsername(userName);
		loginpage.sendPassword(password);
		loginpage.signIn();
		manageCategoryPage.categoryPageSelection();
		String categoryName = ExcelUtility.getString(1, 0,"ManageCategory&Subcategory");
		manageCategoryPage.newCategoryCreation(categoryName);
	}
}
