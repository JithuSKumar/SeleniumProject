package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {
	
	public String getTextElement(WebElement element)
	{
		return element.getText();
	}
	
	public String selectValueFromDropdown(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByValue(value);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}
	
	public void selectDropdownbyText(WebElement element, String text)
	{
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	public void alertHandlingaccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public boolean elementIsSelected(WebElement element) {
		element.click();
		boolean b = element.isSelected();
		return b;
	}
	
	public void mouseRightClick(WebDriver driver, WebElement element) {
		Actions actObject = new Actions(driver);
		actObject.contextClick(element).perform();
	}
	
	public void dragAnddrop(WebElement dragableItem, WebElement dropItem, WebDriver driver) 
	{
		Actions actions = new Actions(driver);
		actions.clickAndHold(dragableItem).moveToElement(dropItem).release(dropItem).build().perform();
	}

	
	public static final String TESTDATAFILE = System.getProperty("user.dir")+ "\\src\\main\\java\\resources\\TestData.xlsx";
	//public static final String CONFIGfILE = System.getProperty("user.dir")+ "\\src\\main\\java\\resources\\config.properties";
	public static final String IMAGEFILEFORMANAGECATEGORYCATEGORYPAGE = System.getProperty("user.dir")+ "\\src\\main\\java\\resources\\gift.png";

}
