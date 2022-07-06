package pageobjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageinterfaces.user.UserRegisterPageUI;

public class UserRegisterPage extends BasePage {
    WebDriver driver;

    public UserRegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToRegisterButton(WebDriver driver) {
        waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
    }

    public boolean isErrorValidationMsgDisplayed(WebDriver driver, String fieldName, String message) {
        waitForElementVisible(driver, UserRegisterPageUI.DYNAMIC_VALIDATE_ERROR_MSG, fieldName, message);
        return isElementDisplayed(driver, UserRegisterPageUI.DYNAMIC_VALIDATE_ERROR_MSG, fieldName, message);
    }

    public void inputToDynamicTextbox(WebDriver driver, String value, String fieldName) {
        waitForElementVisible(driver, UserRegisterPageUI.DYNAMIC_TEXTBOX, fieldName);
        sendKeyToElement(driver, UserRegisterPageUI.DYNAMIC_TEXTBOX, value, fieldName);
    }

    public boolean isValidationSummaryErrorsDisplayed(WebDriver driver, String message) {
        waitForElementVisible(driver, UserRegisterPageUI.DYNAMIC_SUMMARY_ERROR, message);
        return isElementDisplayed(driver, UserRegisterPageUI.DYNAMIC_SUMMARY_ERROR, message);
    }

    public void clickToGenderRadioButton(WebDriver driver, String gender) {
        waitForElementClickable(driver, UserRegisterPageUI.GENDER_RADIO_BUTTON, gender);
        checkCheckboxOrRadio(driver, UserRegisterPageUI.GENDER_RADIO_BUTTON, gender);
    }

    public void clickToDynamicSelect(WebDriver driver, String selectValue, String selectFieldName) {
        waitForElementClickable(driver, UserRegisterPageUI.DYNAMIC_BIRTHDAY_SELECT, selectFieldName);
        selectItemInDropDown(driver, UserRegisterPageUI.DYNAMIC_BIRTHDAY_SELECT, selectValue, selectFieldName);
    }
}
