package driverFactory;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import abstract_01.BasePage;
import config.AppUtil;
import io.qameta.allure.Attachment;

public class TestExcutionListener implements ITestListener {
	
	public static String getTestMethodName(ITestResult iTestResult) {
		
		return iTestResult.getMethod().getConstructorOrMethod().getName();
		
	}
	
	@Attachment
	public byte[] saveFailureScreenShot(WebDriver driver) {
		
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		
	}
	@Attachment(value = "{0}", type = "text/plain")
	public static String saveTextLog(String message) {
		return message; 
	}
	
	public void onTestFailure(ITestResult iTestResult) {
		System.out.println("I am in onTestFailure method"+getTestMethodName(iTestResult)+"failed");
		WebDriver driver =new AppUtil();
		 if (driver instanceof WebDriver) {
			 System.out.println("Screendhot capture for test case:" +getTestMethodName(iTestResult));
			 saveFailureScreenShot(driver);
			
		}
		 saveTextLog(getTestMethodName(iTestResult)+"failed and screenshot taken");
		
	}

}
