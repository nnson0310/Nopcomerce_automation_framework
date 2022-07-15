package commons;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import page.interfaces.admin.AdminCommonUI;
import page.interfaces.admin.CustomerListPageUI;

public class AdminBasePage extends BasePage {

    JavascriptExecutor jsExecutor;

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

    public boolean isSuccessAlertDisplayed(WebDriver driver, String message) {
        waitForElementVisible(driver, AdminCommonUI.SUCCESS_ALERT);
        String alertMessage = getElement(driver, AdminCommonUI.SUCCESS_ALERT).getText().replaceAll("[^A-Za-z.\\s]","").trim();
        return isElementDisplayed(driver, AdminCommonUI.SUCCESS_ALERT) && alertMessage.equals(message);
    }

    public boolean isNewItemDisplayedInTable(WebDriver driver, String tableId, String itemName) {
        waitForElementVisible(driver, AdminCommonUI.SEARCH_RESULT_NAME_LABEL_TABLE_ROW, tableId, itemName);
        return isElementDisplayed(driver, AdminCommonUI.SEARCH_RESULT_NAME_LABEL_TABLE_ROW, tableId, itemName);
    }

    public void clickToTableButton(WebDriver driver, String tableCellData, String buttonName) {
        String columnIndex = String.valueOf(getElementSize(driver, AdminCommonUI.TABLE_BUTTON_COLUMN_HEADER, buttonName) + 1);
        String rowIndex = String.valueOf(getElementSize(driver, AdminCommonUI.ITEM_LABEL_TABLE_ROW, tableCellData) + 1);
        waitForElementClickable(driver, AdminCommonUI.TABLE_ROW_EDIT_BUTTON, rowIndex, columnIndex);
        scrollToElement(driver, AdminCommonUI.TABLE_ROW_EDIT_BUTTON, rowIndex, columnIndex);
        clickToElement(driver, AdminCommonUI.TABLE_ROW_EDIT_BUTTON, rowIndex, columnIndex);
    }

    public void clickToCardTitle(WebDriver driver, String card, String cardTitle) {
        waitForElementClickable(driver, AdminCommonUI.CARD_TITLE_LABEL_DIV, card, cardTitle);
        clickToElement(driver, AdminCommonUI.CARD_TITLE_LABEL_DIV, card, cardTitle);
    }

    public void clickToBackLink(WebDriver driver, String backLinkFieldName) {
        waitForElementClickable(driver, AdminCommonUI.BACK_TO_PREV_PAGE_LINK, backLinkFieldName);
        clickToElement(driver, AdminCommonUI.BACK_TO_PREV_PAGE_LINK, backLinkFieldName);
    }

    public void clickToAlertCloseButton(WebDriver driver) {
        waitForElementClickable(driver, AdminCommonUI.ALERT_CLOSE_BUTTON);
        clickToElement(driver, AdminCommonUI.ALERT_CLOSE_BUTTON);
    }

    public void clickToPopupDeleteButton(WebDriver driver) {
        acceptAlert(driver);
    }

    public void clickToAddNewButton(WebDriver driver) {
        waitForElementClickable(driver, AdminCommonUI.ADD_NEW_BUTTON);
        clickToElement(driver, AdminCommonUI.ADD_NEW_BUTTON);
    }

    public boolean isNoDataInTableMessageDisplayed(WebDriver driver, String tableId) {
        waitForElementVisible(driver, AdminCommonUI.NO_DATA_IN_TABLE_MESSAGE, tableId);
        return isElementDisplayed(driver, AdminCommonUI.NO_DATA_IN_TABLE_MESSAGE, tableId);
    }
}
