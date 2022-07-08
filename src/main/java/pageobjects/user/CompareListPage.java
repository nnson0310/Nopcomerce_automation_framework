package pageobjects.user;

import commons.UserBasePage;
import org.openqa.selenium.WebDriver;
import pageinterfaces.user.CompareListPageUI;

public class CompareListPage extends UserBasePage {

    WebDriver driver;

    public CompareListPage(WebDriver driver) {
        this.driver = driver;
    }

    private int getRowIndexByProductName(WebDriver driver, String locator, String productName) {
        waitForElementVisible(driver, locator, productName);
        return getElementSize(driver, locator, productName);
    }

    /**
     * Verify product name is displayed correctly and get product price in table
     * @param driver instance Webdriver
     * @param productName name of compared product
     * @return price of corresponding product in compared-list table
     */
    public String getComparedProductPrice(WebDriver driver, String productName) {
        int index = getRowIndexByProductName(driver, CompareListPageUI.PRODUCT_NAME_PRECEDING_SIBLING_ROW, productName);
        String indexRow = String.valueOf(++index);
        waitForElementVisible(driver, CompareListPageUI.COMPARED_PRODUCT_PRICE_TABLE_ROW, productName, indexRow);
        return getElementText(driver, CompareListPageUI.COMPARED_PRODUCT_PRICE_TABLE_ROW, productName, indexRow);
    }

    public void clickToClearListButton(WebDriver driver) {
        waitForElementClickable(driver, CompareListPageUI.CLEAR_LIST_BUTTON);
        clickToElement(driver, CompareListPageUI.CLEAR_LIST_BUTTON);
    }

    public boolean isClearListMessageDisplayed(WebDriver driver, String message) {
        waitForElementVisible(driver, CompareListPageUI.CLEAR_LIST_MESSAGE, message);
        return isElementDisplayed(driver, CompareListPageUI.CLEAR_LIST_MESSAGE, message);
    }
}
