package driverFactory;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import abstract_01.AfrontPage;
import abstract_01.ASearchedProductsPage;
import config.AppUtil;
import io.qameta.allure.AllureResultsWriter;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.FileSystemResultsWriter;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class TestScript extends AppUtil {
	
		
	ExtentTest test;
	ExtentReports report=new ExtentReports("./Extentreport/Result.html");
	AllureResultsWriter writer=new FileSystemResultsWriter(null);
	@Test(priority = 0)
    @Epic("AmzE024")
    @Story("AmzS120")
    @Severity(SeverityLevel.MINOR)
    @Description("verify front page title")
    @Step("verify 'Amazon' fron page title")
	public void verifyFrontPageTitle() {
		
		test=report.startTest("Verification of Amazon front page Title");
		test.assignAuthor("MUKESH");
		String title=page.getInstance(AfrontPage.class).getFrontPageTitle();
		Assert.assertEquals(title,"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		Reporter.log("Front page title verified"+" ::  "+title,true);
		test.log(LogStatus.PASS,"Test Success");
		report.endTest(test);
		report.flush();
		
		
	}
	@Test(priority = 1)
    @Epic("AmzE024")
    @Story("AmzS121")
    @Severity(SeverityLevel.MINOR)
    @Description("verify front page Header")
    @Step("verify 'Amazon' fron page Header")
	public void verifyFrontPageHeader() {
		test=report.startTest("Verification of Amazon front page Header");
		test.assignAuthor("MUKESH");
		WebElement Aheader=page.getInstance(AfrontPage.class).getFrontPageHeader();
		String header=Aheader.getText();
		Assert.assertEquals(header,"Amazon miniTV");
		Reporter.log("Front page header verified"+" ::  "+header,true);
		test.log(LogStatus.PASS,"Test Success");
		report.endTest(test);
		report.flush();
		
	}

	@Test(priority = 2)
    @Epic("AmzE024")
    @Story("AmzS122")
    @Severity(SeverityLevel.CRITICAL)
    @Description("verify Search Functionality")
    @Step("verify 'Amazon' Search Functionality ")
	public void search() {
		test=report.startTest("Verification of Amazon search Functionality");
		test.assignAuthor("MUKESH");
	    page.getInstance(AfrontPage.class).search("a sport shoe for men");
	    String AshoesPageHeader=page.getInstance(ASearchedProductsPage.class).getShoesPageHeader().getText();
	    String ExpectedHeader="a sport shoe for men";
	    if (AshoesPageHeader.toLowerCase().contains(ExpectedHeader.toLowerCase())) {
	    	Reporter.log("Search Functionality of this app verified"+" ::  "+AshoesPageHeader,true);	
	        test.log(LogStatus.PASS,"Test Success");
			report.endTest(test);
			report.flush();
			
		} else {
			Reporter.log("Search Functionality verification Fail"+" ::  "+AshoesPageHeader,true);	
	        test.log(LogStatus.FAIL,"Test Success");
			report.endTest(test);
			report.flush();

		}
        
	}
	@Test(priority = 3)
	@Epic("AmzE024")
    @Story("AmzS123")
    @Severity(SeverityLevel.CRITICAL)
    @Description("verify Search string matched with result string")
    @Step("verify 'Amazon' Searched products ")
	public void ASearchedProducts() {
		test=report.startTest("verify Search string matched with result string");
		test.assignAuthor("MUKESH");
		page.getInstance(ASearchedProductsPage.class).searchedPro();
		test.log(LogStatus.PASS,"Test Success");
		report.endTest(test);
		report.flush();
		
		
	}
}
