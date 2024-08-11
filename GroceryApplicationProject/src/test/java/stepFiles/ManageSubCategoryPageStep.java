package stepFiles;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageFiles.LoginPage;
import pageFiles.ManageSubCategoryPage;
import utilities.ExcelUtility;

public class ManageSubCategoryPageStep extends BaseClassStep {
	
	LoginPage loginpage;
	ManageSubCategoryPage manageSubCategoryPage;
	
	@Test (priority = 1)
	public void verifyIfCategoryListisLoaded()
	{
		String userName = ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 1,"LoginPage");
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
	public void verifyCreationofNewSubCategor() 
	{
		String userName = ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 1,"LoginPage");
		loginpage = new LoginPage(driver);
		manageSubCategoryPage = new ManageSubCategoryPage(driver);
		loginpage.sendUsername(userName);
		loginpage.sendPassword(password);
		loginpage.signIn();
		manageSubCategoryPage.subCategoryPageSelection();
		String CategoryType = ExcelUtility.getString(1, 0,"ManageCategory&Subcategory");
		String subCategoryName = ExcelUtility.getString(1, 1,"ManageCategory&Subcategory");
		manageSubCategoryPage.creationOfNewSubCategory(subCategoryName, CategoryType);
	}
}
