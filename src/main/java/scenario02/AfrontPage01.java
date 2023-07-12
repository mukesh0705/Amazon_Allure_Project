package scenario02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AfrontPage01 {
	WebDriver driver;
	public AfrontPage01(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(xpath = "//select[@id='searchDropdownBox']")
	WebElement clickAll;
	
	public void fPage() {
		this.clickAll.click();
	}
	

}
