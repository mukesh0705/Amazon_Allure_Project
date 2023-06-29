package abstract_01;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Page {

	public BasePage(WebDriver driver) {
		super(driver);
	}

	@Override
	public WebElement getPageHeader(By locator) {
		
		return getElement(locator);
	}

	@Override
	public WebElement getElement(By locator) {
		
		WebElement element=driver.findElement(locator);
		
		return element;
	}

	@Override
	public void waitForElementPresent(By locator) {
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		
	}

	@Override
	public void waitForPageTitle(String title) {
		wait.until(ExpectedConditions.titleContains(title));
		
	}

	@Override
	public List<WebElement> getElements(By locator) {
		List<WebElement> elements=driver.findElements(locator);
		return elements;
	}

}
