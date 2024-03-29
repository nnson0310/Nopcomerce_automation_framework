package page.objects.user;

import commons.UserBasePage;
import org.openqa.selenium.WebDriver;
import page.interfaces.user.UserLoginPageUI;
import page.objects.UserPageGeneratorManager;

public class UserLoginPage extends UserBasePage {
    WebDriver driver;

    public UserLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToEmailField(WebDriver driver, String value) {
        waitForElementVisible(driver, UserLoginPageUI.EMAIL_FIELD);
        sendKeyToElement(driver, UserLoginPageUI.EMAIL_FIELD, value);
    }

    public void clickToLoginButton(WebDriver driver) {
        waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
    }

    public boolean isDynamicEmailErrorDisplayed(WebDriver driver, String message) {
        waitForElementVisible(driver, UserLoginPageUI.DYNAMIC_EMAIL_ERROR, message);
        return isElementDisplayed(driver, UserLoginPageUI.DYNAMIC_EMAIL_ERROR, message);
    }

    public void inputToPasswordField(WebDriver driver, String password) {
        waitForElementVisible(driver, UserLoginPageUI.PASSWORD_FIELD);
        sendKeyToElement(driver, UserLoginPageUI.PASSWORD_FIELD, password);
    }

    public CheckoutPage clickToCheckoutAsGuestButton(WebDriver driver) {
        waitForElementClickable(driver, UserLoginPageUI.CHECKOUT_AS_GUEST_BUTTON);
        clickToElement(driver, UserLoginPageUI.CHECKOUT_AS_GUEST_BUTTON);
        return UserPageGeneratorManager.getUserPageGeneratorManager().getCheckoutPage(driver);
    }
}
