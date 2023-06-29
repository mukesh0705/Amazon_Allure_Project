package abstract_01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AfrontPage extends BasePage {
	
	//Page locators(variables)
	private By keysInSearchBox = By.xpath("//input[@id='twotabsearchtextbox']");
	private By searchBtn = By.xpath("//input[@id='nav-search-submit-button']");
	private By header=By.xpath("//a[normalize-space()='Amazon miniTV']");
	
	public AfrontPage(WebDriver driver) {
		super(driver);
		
	}
	public WebElement getFrontPageHeader() {
		return getPageHeader(header);	
	}
	public String getFrontPageTitle() {
		return driver.getTitle();	
	}
	public WebElement getSearchbtn() {
		return getElement(searchBtn);	
	}
	public WebElement getSearchBox() {
		return getElement(keysInSearchBox);	
	}
	
	public void search(String searchKey) {
		getSearchBox().sendKeys(searchKey);
		System.out.println(getFrontPageHeader().getText());
		getSearchbtn().click();
		
		
	}

}
