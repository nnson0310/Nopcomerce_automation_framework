package pageobjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageinterfaces.UserHomePageUI;

public class UserHomePage extends BasePage {

    WebDriver driver;

    public UserHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public UserLoginPage clickToLoginLink(WebDriver driver) {
        waitForElementClickable(driver, UserHomePageUI.LOGIN_HEADER_LINK);
        clickToElement(driver, UserHomePageUI.LOGIN_HEADER_LINK);
        return PageGeneratorManager.getPageGeneratorManager().getLoginHomePage(driver);
    }

    public UserRegisterPage clickToRegisterLink(WebDriver driver) {
        waitForElementClickable(driver, UserHomePageUI.REGISTER_HEADER_LINK);
        clickToElement(driver, UserHomePageUI.REGISTER_HEADER_LINK);
        return PageGeneratorManager.getPageGeneratorManager().getUserRegisterPage(driver);
    }
}
