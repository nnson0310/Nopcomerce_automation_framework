package pageobjects.user;

import commons.UserBasePage;
import org.openqa.selenium.WebDriver;
import pageinterfaces.user.SearchPageUI;

public class SearchPage extends UserBasePage {
    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToSearchTextbox(WebDriver driver, String value) {
        waitForElementVisible(driver, SearchPageUI.SEARCH_TEXTBOX);
        sendKeyToElement(driver, SearchPageUI.SEARCH_TEXTBOX, value);
    }

    public void clickToSearchButton(WebDriver driver) {
        waitForElementClickable(driver, SearchPageUI.SEARCH_BUTTON);
        clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
    }

    public boolean isDynamicSearchErrorDisplayed(WebDriver driver, String message) {
        waitForElementVisible(driver, SearchPageUI.DYNAMIC_SEARCH_ERROR, message);
        return isElementDisplayed(driver, SearchPageUI.DYNAMIC_SEARCH_ERROR, message);
    }

    public boolean isSearchResultCorrect(WebDriver driver, int results, String keyword) {
        waitForAllElementVisible(driver, SearchPageUI.SEARCH_RESULT_TITLE);
        int searchResults = getElementSize(driver, SearchPageUI.SEARCH_RESULT_TITLE);
        return searchResults == results && isSearchResultDisplayedCorrect(driver, keyword);
    }

    public void selectToCategoryDropdown(WebDriver driver, String categoryName) {
        waitForElementClickable(driver, SearchPageUI.CATEGORY_SELECT_DROPDOWN, categoryName);
        selectItemInDropDown(driver, SearchPageUI.CATEGORY_SELECT_DROPDOWN, categoryName);
    }

    public void clickToAdvancedSearchCheckbox(WebDriver driver) {
        waitForElementClickable(driver, SearchPageUI.ADVANCED_SEARCH_CHECKBOX);
        checkCheckboxOrRadio(driver, SearchPageUI.ADVANCED_SEARCH_CHECKBOX);
    }

    public void clickToSearchWithSubCategoryCheckbox(WebDriver driver) {
        waitForElementClickable(driver, SearchPageUI.SEARCH_WITH_SUB_CATEGORY_CHECKBOX);
        checkCheckboxOrRadio(driver, SearchPageUI.SEARCH_WITH_SUB_CATEGORY_CHECKBOX);
    }
}
