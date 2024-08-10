package pageFiles;


import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUploadUtilities;
import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class ManageCategoryPage {

	WebDriver driver;
	GeneralUtilities generaUtility = new GeneralUtilities();
	WaitUtilities waitUtility = new WaitUtilities();
	FileUploadUtilities fileUploadUtility = new FileUploadUtilities();

	public ManageCategoryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='nav-icon fas fa-list-alt']") WebElement manageCategoryIconElement;
	@FindBy(xpath = "//a//p[text()='Category']") WebElement categoryElement;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']") WebElement listCategoryTablElement;
	@FindBy(xpath= "//a[@class='btn btn-rounded btn-danger']") WebElement newCategoryCreationElement;
	@FindBy(id = "category") WebElement categoryNameElement;	
	@FindBy(xpath = "//li[@class='ms-elem-selectable ms-hover']") WebElement draggingElement;
	@FindBy(xpath = "//li[@class='ms-elem-selection']") WebElement droppingElement;
	@FindBy(xpath = "//input[@type='file']") WebElement uploadImagElement;
	@FindBy(xpath = "//button[@type='submit']") WebElement categorySaveElement;

	public boolean categoryPageSelection()
	{
		manageCategoryIconElement.click();
		categoryElement.click();
		return listCategoryTablElement.isDisplayed();
	}
	public void newCategoryCreation(String categoryName) throws AWTException
	{
		newCategoryCreationElement.click();
		categoryNameElement.sendKeys(categoryName);
		//generaUtility.dragAnddrop(draggingElement, droppingElement, driver);
		fileUploadUtility.fileUploadUsingSendKeys(uploadImagElement, generaUtility.IMAGEFILEFORMANAGECATEGORYCATEGORYPAGE);
		categorySaveElement.click();
		
	}

}
