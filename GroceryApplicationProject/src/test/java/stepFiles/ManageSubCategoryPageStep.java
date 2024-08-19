package stepFiles;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageFiles.LoginPage;
import pageFiles.ManageCategoryPage;
import pageFiles.ManageSubCategoryPage;
import utilities.ExcelUtility;

public class ManageSubCategoryPageStep extends BaseClassStep {
	
	LoginPage loginpage;
	ManageSubCategoryPage manageSubCategoryPage;
	ManageCategoryPage manageCategoryPage;
	
	@Test (priority = 1)
	public void verifyIfCategoryListisLoaded()
	{
		loginpage = new LoginPage(driver);
		manageSubCategoryPage = new ManageSubCategoryPage(driver);
		loginpage.sendUsername(userName);
		loginpage.sendPassword(password);
		loginpage.signIn();
		manageSubCategoryPage.subCategoryPageSelection();
		boolean actualTableStatus = manageSubCategoryPage.subCategoryPageSelection();
		Assert.assertEquals(actualTableStatus, true, "Sub Category table list is not displayed.");
	}
 
	@Test (priority = 2)
	public void verifyCreationofNewSubCategory() 
	{
		loginpage = new LoginPage(driver);
		manageCategoryPage = new ManageCategoryPage(driver);
		manageSubCategoryPage = new ManageSubCategoryPage(driver);
		loginpage.sendUsername(userName);
		loginpage.sendPassword(password);
		loginpage.signIn();
		manageCategoryPage.categoryPageSelection();	
		String CategoryType = manageCategoryPage.fetchingTheFirstEntryinTable();
		manageSubCategoryPage.subCategoryPageSelection();
		String subCategoryName = ExcelUtility.getString(1, 0,"ManageCategory&Subcategory");
		manageSubCategoryPage.creationOfNewSubCategory(subCategoryName, CategoryType);
	}
}
