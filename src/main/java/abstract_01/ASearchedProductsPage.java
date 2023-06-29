package abstract_01;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class ASearchedProductsPage extends BasePage {


	//Page locators(variables)
	private By productPrices = By.xpath("//span[@class='a-price']");
	private By Aproduct = By.xpath("(//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal'])[2]");
	private By productsName=By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']");
	private By header=By.xpath("//span[@class='a-color-state a-text-bold']");
	private By productTitle=By.xpath("//span[@id='productTitle']");
	
	
	public ASearchedProductsPage(WebDriver driver) {
		super(driver);
		
	}
	public WebElement getShoesPageHeader() {
		return getElement(header);	
	}
	public String getTitle() {
		return driver.getTitle();	
	}
	public WebElement getAproduct() {
		return getElement(Aproduct);	
	}
	public WebElement getAproductTitle() {
		return getElement(productTitle);	
	}
	
	public List<WebElement> getPeoducsName() {
		return getElements(productsName);
		
	}
	public List<WebElement> getPeoducsPrice() {
		return getElements(productPrices);
		
	}
	
	public void searchedPro() {
		String header =    getShoesPageHeader().getText();
		String title  =    getTitle();
		String ClickedProduct = getAproduct().getText();
		
		
		for (int i = 0; i < getPeoducsName().size(); i++) {
			
		    System.out.println(getPeoducsName().get(i).getText()+"  \t             \n\tRs"+getPeoducsPrice().get(i).getText());
			
		}
		getAproduct().click();
		ArrayList<String> brow=new ArrayList<String>(driver.getWindowHandles());
		
		String parent=brow.get(0);
		String child1=brow.get(1);
		
		
		driver.switchTo().window(child1);
		
		String productTitle=getAproductTitle().getText();
		
		if (productTitle.toLowerCase().contains(ClickedProduct.toLowerCase())) {
			
			Reporter.log("All searched product loaded and Clicked Product verified:: "+ClickedProduct+"  "+ClickedProduct,true);
			
		} else {
			Reporter.log("All searched product loaded But Clicked Product Not verified::  "+ClickedProduct+"  "+ClickedProduct,true);
            
		}

		
	}
}
