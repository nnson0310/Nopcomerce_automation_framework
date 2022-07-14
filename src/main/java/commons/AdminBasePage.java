package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.interfaces.admin.AdminCommonUI;
import utilities.FunctionHelper;

public class AdminBasePage extends BasePage {

    public boolean isContentHeaderDisplayed(WebDriver driver, String fieldName) {
        waitForElementVisible(driver, AdminCommonUI.CONTENT_HEADER, fieldName);
        return isElementDisplayed(driver, AdminCommonUI.CONTENT_HEADER, fieldName);
    }

    public void inputToDynamicTextboxByNameAttribute(WebDriver driver, String value, String nameAttribute) {
        waitForElementVisible(driver, AdminCommonUI.DYNAMIC_INPUT_BY_NAME, nameAttribute);
        sendKeyToElement(driver, AdminCommonUI.DYNAMIC_INPUT_BY_NAME, value, nameAttribute);
    }

    public void clickToDynamicButtonById(WebDriver driver, String id) {
        waitForElementClickable(driver, AdminCommonUI.DYNAMIC_BUTTON_BY_ID, id);
        clickToElement(driver, AdminCommonUI.DYNAMIC_BUTTON_BY_ID, id);
    }

    public boolean isSearchResultDisplayedCorrect(WebDriver driver, String tableId, String searchResult, int expectedResult) {
        waitForElementVisible(driver, AdminCommonUI.SEARCH_RESULT_NAME_LABEL_TABLE_ROW, tableId, searchResult);
        return isElementDisplayed(driver, AdminCommonUI.SEARCH_RESULT_NAME_LABEL_TABLE_ROW, tableId, searchResult) &&
                (getElementSize(driver, AdminCommonUI.TABLE_ROW, tableId) == expectedResult);
    }

    public void clickToDynamicSelectByNameAttribute(WebDriver driver, String selectValue, String fieldName) {
        waitForElementClickable(driver, AdminCommonUI.DYNAMIC_SELECT_BY_NAME, fieldName);
        selectItemInDropDown(driver, AdminCommonUI.DYNAMIC_SELECT_BY_NAME, selectValue, fieldName);
    }

    public void uncheckDynamicCheckboxOrRadioByName(WebDriver driver, String fieldName) {
        waitForElementClickable(driver, AdminCommonUI.DYNAMIC_INPUT_BY_NAME, fieldName);
        uncheckCheckboxOrRadio(driver, AdminCommonUI.DYNAMIC_INPUT_BY_NAME, fieldName);
    }

    public boolean isNoSearchResultMessageDisplayed(WebDriver driver, String message) {
        waitForElementVisible(driver, AdminCommonUI.NO_DATA_AVAILABLE_MESSAGE_TABLE_ROW, message);
        return isElementDisplayed(driver, AdminCommonUI.NO_DATA_AVAILABLE_MESSAGE_TABLE_ROW, message);
    }

    public void clickToMultiSelectDeleteButton(WebDriver driver, String fieldName) {
        waitForAllElementVisible(driver, AdminCommonUI.DYNAMIC_MULTI_SELECT_DELETE_BUTTON, fieldName);
        clickToMultiElement(driver, AdminCommonUI.DYNAMIC_MULTI_SELECT_DELETE_BUTTON, fieldName);
    }

    public void clickToHiddenMultiSelect(WebDriver driver, String selectValue, String selectName, String listItemName) {
       waitForElementClickable(driver, AdminCommonUI.DYNAMIC_MULTI_SELECT, selectName);
       clickToElement(driver, AdminCommonUI.DYNAMIC_MULTI_SELECT, selectName);

       waitForElementClickable(driver, AdminCommonUI.DYNAMIC_MULTI_SELECT_ITEM, listItemName, selectValue);
       clickToElement(driver, AdminCommonUI.DYNAMIC_MULTI_SELECT_ITEM, listItemName, selectValue);
    }

    public void clickToDynamicButtonByName(WebDriver driver, String buttonName) {
        waitForElementClickable(driver, AdminCommonUI.DYNAMIC_BUTTON_BY_NAME, buttonName);
        clickToElement(driver, AdminCommonUI.DYNAMIC_BUTTON_BY_NAME, buttonName);
    }

    public boolean isSuccessAlertDisplayed(WebDriver driver) {
        waitForElementVisible(driver, AdminCommonUI.SUCCESS_ALERT);
        return isElementDisplayed(driver, AdminCommonUI.SUCCESS_ALERT);
    }

    public void clickToModSwitchButton(WebDriver driver) {
        waitForElementClickable(driver, AdminCommonUI.MOD_SWITCH_BUTTON);
        clickToElement(driver, AdminCommonUI.MOD_SWITCH_BUTTON);
    }
}
