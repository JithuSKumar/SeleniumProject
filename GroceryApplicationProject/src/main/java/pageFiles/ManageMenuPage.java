package pageFiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUploadUtilities;
import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class ManageMenuPage {
	
	WebDriver driver;
	GeneralUtilities generaUtility = new GeneralUtilities();
	WaitUtilities waitUtility = new WaitUtilities();
	FileUploadUtilities fileUploadUtility = new FileUploadUtilities();

	public ManageMenuPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//i[@class='nav-icon sidebar-item-icon fa fa-cog']") WebElement settingsIconElement;
	@FindBy(xpath = "//p[text()='Manage Menu']") WebElement manageMenuElement;
	@FindBy(xpath = "//table[@class='table table-bordered']") WebElement tableElement;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']") WebElement newManageElement;
	@FindBy(xpath = "//input[@id='name']") WebElement newMenuNameElement;
	@FindBy(id = "menu_id") WebElement parentMenuElement;
	@FindBy(id = "url") WebElement urlElement;
	@FindBy(id = "icon") WebElement favIconElement;
	@FindBy(id = "menu_table") WebElement menuTableElement;
	@FindBy(id = "active_file") WebElement activeFileElement;
	@FindBy(id = "menu_color") WebElement colourElement;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-danger']") WebElement saveElement;
	@FindBy(xpath ="//div[@class='alert alert-success alert-dismissible']") WebElement successMessageElement;
	
	public void managePageSelection()
	{
		waitUtility.waitForElementClickable(driver, settingsIconElement);
		settingsIconElement.click();
		manageMenuElement.click();
	}
	
	public boolean managePageListVisibility()
	{
		return tableElement.isDisplayed();
	}

	public void creatingNewMenu(String menuName, String parentMenu, String url, String favIcon, String tableValue, String fileValue, String colourValue)
	{
		newManageElement.click();
		newManageElement.sendKeys(menuName);
		//waitUtility.waitForElement(driver, parentMenu);
		generaUtility.selectDropdownbyText(parentMenuElement, parentMenu);
		urlElement.sendKeys(url);
		favIconElement.sendKeys(favIcon);
		menuTableElement.sendKeys(tableValue);
		activeFileElement.sendKeys(fileValue);
		colourElement.sendKeys(colourValue);
		saveElement.click();
		waitUtility.waitForElement(driver, successMessageElement);
	}
}
