package pageobjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageinterfaces.user.MyAccountPageUI;

public class MyAccountPage extends BasePage {
    WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToDynamicTextbox(WebDriver driver, String value, String fieldName) {
        waitForElementVisible(driver, MyAccountPageUI.DYNAMIC_TEXTBOX, fieldName);
        sendKeyToElement(driver, MyAccountPageUI.DYNAMIC_TEXTBOX, value, fieldName);
    }

    public void clickToSaveButton(WebDriver driver) {
        waitForElementClickable(driver, MyAccountPageUI.SAVE_BUTTON);
        clickToElement(driver, MyAccountPageUI.SAVE_BUTTON);
    }

    public String getAccountInfo(WebDriver driver, String fieldName) {
        waitForElementVisible(driver, MyAccountPageUI.DYNAMIC_TEXTBOX, fieldName);
        return getAttributeValue(driver, MyAccountPageUI.DYNAMIC_TEXTBOX, "value" ,fieldName);
    }

    public void clickToDynamicBlockAccountNavigation(WebDriver driver, String fieldName) {
        waitForElementClickable(driver, MyAccountPageUI.DYNAMIC_BLOCK_ACCOUNT_NAVIGATION, fieldName);
        clickToElement(driver, MyAccountPageUI.DYNAMIC_BLOCK_ACCOUNT_NAVIGATION, fieldName);
    }
}
