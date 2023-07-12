package driverFactory;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import config.AppUtil;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import scenario02.AfrontPage01;

public class TestScript02 extends AppUtil {
	@Test
    @Epic("AmzE024")
    @Story("AmzS120")
    @Severity(SeverityLevel.MINOR)
    @Description("verify front page title")
    @Step("verify 'Amazon' fron page title")
	public void startSearch() {
		AfrontPage01 search=PageFactory.initElements(driver, AfrontPage01.class);
		search.fPage();
	}

}
