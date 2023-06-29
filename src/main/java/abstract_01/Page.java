/**
 * 
 */
package abstract_01;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Hello friends ,here we see how use OOPs concept in java
 * =======================================================
 * There are fore pillar of OOPs concept
 * 1.Abstraction
 * 2.Polymorphism
 *   a)Overriding
 *   b)Overloading
 * 3.Encapsulation
 * 4.Inheritance
 * @author MUKESH
 *
 */
public abstract class Page {
	WebDriver driver;
	WebDriverWait wait;

	public Page(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver , 15);		
	}
	//abstract method:

	public abstract WebElement getPageHeader(By locator);

	public abstract WebElement getElement(By locator);
	
	public abstract List<WebElement> getElements(By locator);

	public abstract void waitForElementPresent(By locator);

	public abstract void waitForPageTitle(String title);

	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass)  {

		try {
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
}