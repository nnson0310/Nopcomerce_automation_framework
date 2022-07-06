package pageobjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageinterfaces.user.UserHomePageUI;
import pageobjects.PageGeneratorManager;

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

    public boolean isMyAccountHeaderLinkDisplayed(WebDriver driver) {
        waitForElementVisible(driver, UserHomePageUI.MY_ACCOUNT_HEADER_LINK);
        return isElementDisplayed(driver, UserHomePageUI.MY_ACCOUNT_HEADER_LINK);
    }

    public MyAccountPage clickToMyAccountLink(WebDriver driver) {
        waitForElementClickable(driver, UserHomePageUI.MY_ACCOUNT_HEADER_LINK);
        clickToElement(driver, UserHomePageUI.MY_ACCOUNT_HEADER_LINK);
        return PageGeneratorManager.getPageGeneratorManager().getMyAccountPage(driver);
    }
}
