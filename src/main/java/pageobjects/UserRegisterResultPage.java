package pageobjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageinterfaces.UserRegisterResultPageUI;

public class UserRegisterResultPage extends BasePage {
    WebDriver driver;

    public UserRegisterResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isRegisterSuccessMessageDisplayed(WebDriver driver, String message) {
        waitForElementVisible(driver, UserRegisterResultPageUI.DYNAMIC_RESULT_MESSAGE, message);
        return isElementDisplayed(driver, UserRegisterResultPageUI.DYNAMIC_RESULT_MESSAGE, message);
    }
}
