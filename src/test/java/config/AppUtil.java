package config;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import abstract_01.BasePage;
import abstract_01.Page;

public class AppUtil implements WebDriver {
	
	public WebDriver driver;
	public Properties pro;
	public Page page;
	
	@BeforeSuite
	public void setUp() throws Throwable {
		pro = new Properties();
		pro.load(new FileInputStream("./propertyFile/Amazon.properties"));
		if (pro.getProperty("Browser").equalsIgnoreCase("chrome")) {
			driver =new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(pro.getProperty("Url"));
			
		} 
		else if (pro.getProperty("Browser").equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(pro.getProperty("Url"));
			
		}
		page=new BasePage(driver);
		
	}
	
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
		
	}


	@Override
	public void get(String url) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public String getCurrentUrl() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<WebElement> findElements(By by) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public WebElement findElement(By by) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getPageSource() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void quit() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Set<String> getWindowHandles() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getWindowHandle() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public TargetLocator switchTo() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Navigation navigate() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Options manage() {
		// TODO Auto-generated method stub
		return null;
	}
/*
 * TestNG BaseTest class or AppUtil class Annotations.
 * 1.@BeforeTest and @AfterTest  :-This annotation use if we have only one test case
 * 2.@BeforeMethod and @AfterMethod :-This annotation test execution Chronological view is like bellow
 * Steps                                              Time taken 
 *     =======                                       ============
 *      setUp                                          0 ms
             verifyFrontPageTitle                      11139 ms
        tearDown                                       23646 ms     
        setUp                                          0 ms     
             verifyFrontPageHeader                     12698 ms
        tearDown                                       23646 ms
        setUp                                          0 ms
             search                                    13038 ms
        tearDown                                       23646 ms
 * 3.@BeforeSuite and @AfterSuite :-This annotation test execution Chronological view is like bellow
 *      Steps                                         Time taken 
 *     =======                                       ============
 *      setUp                                          0 ms
                   verifyFrontPageTitle                11139 ms
                   verifyFrontPageHeader               12698 ms
                   search                              13038 ms
        tearDown                                       23646 ms
  Note:-In this case execution directly start from suite      
   4.@BeforeClass and @AfterClass :-This annotation test execution Chronological view is like bellow
 *      Steps                                         Time taken 
 *     =======                                       ============
 *    class   setUp                                    0 ms
                   verifyFrontPageTitle                11139 ms
                   verifyFrontPageHeader               12698 ms
                   search                              13038 ms
      class   tearDown                                 23646 ms
 Note:-In this case first execute class then your suites are executed    
 */

	


}
