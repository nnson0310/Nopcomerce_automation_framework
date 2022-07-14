package page.objects.user;

import commons.UserBasePage;
import org.openqa.selenium.WebDriver;
import page.interfaces.user.UserRegisterResultPageUI;
import page.objects.UserPageGeneratorManager;

public class UserRegisterResultPage extends UserBasePage {
    WebDriver driver;

    public UserRegisterResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isRegisterSuccessMessageDisplayed(WebDriver driver, String message) {
        waitForElementVisible(driver, UserRegisterResultPageUI.DYNAMIC_RESULT_MESSAGE, message);
        return isElementDisplayed(driver, UserRegisterResultPageUI.DYNAMIC_RESULT_MESSAGE, message);
    }

    public UserHomePage clickToContinueButton(WebDriver driver) {
        waitForElementClickable(driver, UserRegisterResultPageUI.CONTINUE_BUTTON);
        clickToElement(driver, UserRegisterResultPageUI.CONTINUE_BUTTON);
        return UserPageGeneratorManager.getUserPageGeneratorManager().getUserHomePage(driver);
    }
}
