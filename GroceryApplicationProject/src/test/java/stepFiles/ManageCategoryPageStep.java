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
	String userName = ExcelUtility.getString(1, 0,"LoginPage");
	String password = ExcelUtility.getString(1, 1,"LoginPage");

	@Test (priority = 1)
	public void verifyIfCategoryListisLoaded()
	{
		loginpage = new LoginPage(driver);
		manageCategoryPage = new ManageCategoryPage(driver);
		loginpage.sendUsername(userName);
		loginpage.sendPassword(password);
		loginpage.signIn();
		manageCategoryPage.categoryPageSelection();
		boolean actualTableStatus = manageCategoryPage.categoryPageSelection();
		Assert.assertEquals(actualTableStatus, true, "Category table list is not displayed.");
	}
	
	@Test (priority = 2)
	public void VerifyNewCategoryCreation() throws AWTException
	{
		loginpage = new LoginPage(driver);
		manageCategoryPage = new ManageCategoryPage(driver);
		loginpage.sendUsername(userName);
		loginpage.sendPassword(password);
		loginpage.signIn();
		manageCategoryPage.categoryPageSelection();
		manageCategoryPage.fetchingTheFirstEntryinTable();
		String categoryName = ExcelUtility.getString(1, 0,"ManageCategory&Subcategory");
		manageCategoryPage.newCategoryCreation(categoryName);
		manageCategoryPage.categoryPageSelection();	
		String actualValueString = manageCategoryPage.fetchingTheFirstEntryinTable();
		String expectedValue = manageCategoryPage.readRandomCategoryNameString();
		Assert.assertEquals(actualValueString, expectedValue, "New Category creation wasn't success.");
	}
	
	@Test (priority = 3)
	public void searchNewlyAddedCategory()
	{
		loginpage = new LoginPage(driver);
		manageCategoryPage = new ManageCategoryPage(driver);
		loginpage.sendUsername(userName);
		loginpage.sendPassword(password);
		loginpage.signIn();
		manageCategoryPage.categoryPageSelection();		
		String categoryName = manageCategoryPage.fetchingTheFirstEntryinTable();
		manageCategoryPage.searchNewlyAddedCategoryVisibility(categoryName);
	}
	
	@Test(priority = 4, enabled =false)
	public void VerifyDeleteofNewlyAddedCategory()
	{
		loginpage = new LoginPage(driver);
		manageCategoryPage = new ManageCategoryPage(driver);
		loginpage.sendUsername(userName);
		loginpage.sendPassword(password);
		loginpage.signIn();
		manageCategoryPage.categoryPageSelection();	
		manageCategoryPage.fetchingTheFirstEntryinTable();
		manageCategoryPage.deleteNewlyAddedCategory();
		manageCategoryPage.fetchingTheFirstEntryinTable();
		String actualValueString = manageCategoryPage.fetchingTheFirstEntryinTable();
		String expectedValue = ExcelUtility.getString(1, 0,"ManageCategory&Subcategory");
		Assert.assertNotEquals(actualValueString, expectedValue, "New Category deletion wasn't success.");
	}
}
