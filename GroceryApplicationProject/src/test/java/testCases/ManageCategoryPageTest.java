package testCases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageFiles.LoginPage;
import pageFiles.ManageCategoryPage;
import utilities.ExcelUtilities;

public class ManageCategoryPageTest extends BaseClassTest {

	LoginPage loginpage;
	ManageCategoryPage manageCategoryPage;
	
	public String getCreatedCategoryNameString()
	{	
		return createdCategoryNameString;
	}

	public void setCreatedCategoryNameString(String createdCategoryNameString)
	{
		this.createdCategoryNameString = createdCategoryNameString;
	}

	String createdCategoryNameString;
	
	@Test (priority = 1)
	public void verifyIfCategoryListisLoaded() throws IOException
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
	public void VerifyNewCategoryCreation() throws AWTException, IOException
	{
		loginpage = new LoginPage(driver);
		manageCategoryPage = new ManageCategoryPage(driver);
		loginpage.sendUsername(userName);
		loginpage.sendPassword(password);
		loginpage.signIn();
		manageCategoryPage.categoryPageSelection();
		manageCategoryPage.fetchingTheFirstEntryinTable();
		manageCategoryPage.newCategoryCreation(ExcelUtilities.getString(1, 0,"ManageCategory&Subcategory"));
		setCreatedCategoryNameString(manageCategoryPage.getCategoryNameString());
		manageCategoryPage.categoryPageSelection();	
		String actualValueString = manageCategoryPage.fetchingTheFirstEntryinTable();
		String expectedValue = manageCategoryPage.getCategoryNameString();
		Assert.assertEquals(actualValueString, expectedValue, "New Category creation wasn't success.");
	}
	
	@Test (priority = 3)
	public void searchNewlyAddedCategory() throws IOException
	{
		loginpage = new LoginPage(driver);
		manageCategoryPage = new ManageCategoryPage(driver);
		loginpage.sendUsername(userName);
		loginpage.sendPassword(password);
		loginpage.signIn();
		manageCategoryPage.categoryPageSelection();	
		System.out.println(getCreatedCategoryNameString());
		manageCategoryPage.searchNewlyAddedCategoryVisibility(getCreatedCategoryNameString());
		String actualValueString = manageCategoryPage.fetchingTheFirstEntryinTable();
		System.out.println(actualValueString);
		String expectedValueString = getCreatedCategoryNameString();
		Assert.assertEquals(actualValueString, expectedValueString, "The filtered results do not match.");
		
	}
	
	@Test(priority = 4)
	public void VerifyDeleteofNewlyAddedCategory() throws IOException
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
		String expectedValue = ExcelUtilities.getString(1, 0,"ManageCategory&Subcategory");
		Assert.assertNotEquals(actualValueString, expectedValue, "New Category deletion wasn't success.");
	}
}
