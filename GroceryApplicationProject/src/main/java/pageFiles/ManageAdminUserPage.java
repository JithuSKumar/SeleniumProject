package pageFiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class ManageAdminUserPage {
	
WebDriver driver;
GeneralUtilities generaUtility = new GeneralUtilities();
WaitUtilities waitUtility = new WaitUtilities();
	
	public ManageAdminUserPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath = "//section[@class='content']//div//div//div[1]//div//a") WebElement moreInfoOfAdminUserElement;
	@FindBy(xpath = "//h4[text()=\"Admin Users\"]") WebElement adminUserListTablElement;
	@FindBy(xpath ="//tbody//tr[1]//td[1]") WebElement firstElementinUserListElement;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']") WebElement newButtonElement;
	@FindBy(id = "username") WebElement newUserNamElement;
	@FindBy(id= "password") WebElement newUserPasswordElement;
	@FindBy(id = "user_type") WebElement newUserTypElement;
	@FindBy(xpath = "//button[@name='Create']") WebElement newUserSubmitElement;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']") WebElement searchButtonElement;
	@FindBy(id ="un") WebElement userNameSearchElement;
	@FindBy(xpath = "//button[@value='sr']") WebElement subSearchElement;
	@FindBy(xpath = "//tbody//tr[1]//td[5]//i[@class='fas fa-trash-alt']") WebElement firstUserDeletElement;
	@FindBy(xpath = "//a[1][@data-toggle='dropdown']") WebElement userIconElement;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']") WebElement logoutElement;
	
	public boolean isAdminUserTabVisible()
	{
		return moreInfoOfAdminUserElement.isDisplayed();
	}
	
	public void adminUserListSelection()
	{
		moreInfoOfAdminUserElement.click();
	}
	
	public boolean isAdminExistingUserListVisible() throws InterruptedException 
	{
		moreInfoOfAdminUserElement.click();
		waitUtility.wait(20);
		return newButtonElement.isDisplayed();
	}
	
	public String fetchingTheFirstEntryinTable()
	{
		String firstElementValueString = firstElementinUserListElement.getText();
		return firstElementValueString;
	}
	
	public void newAdmineUserCreation(String userName, String password, String userType)
	{
		newButtonElement.click();
		newUserNamElement.sendKeys(userName);
		newUserPasswordElement.sendKeys(password);
		generaUtility.selectDropdownbyText(newUserTypElement, userType);
		newUserSubmitElement.click();
	}
	
	public void searchNewUser(String userName) throws InterruptedException
	{
		searchButtonElement.click();
		userNameSearchElement.sendKeys(userName);
		waitUtility.fluentwaitForElement(driver, subSearchElement);
		subSearchElement.click();
	}
	
	public void deletingTheFirstUser()
	{
		firstUserDeletElement.click();
		waitUtility.waitForAlterIsPresent(driver);
		generaUtility.alertHandlingaccept(driver);
	}
	
	public void userLogout()
	{
		userIconElement.click();
		logoutElement.click();
	}
}