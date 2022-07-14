package page.objects.admin;

import commons.AdminBasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import page.interfaces.admin.EditProductPageUI;

public class EditProductPage extends AdminBasePage  {
    WebDriver driver;
    JavascriptExecutor jsExecutor;

    public EditProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isSelectedCategoryItemDisplayed(WebDriver driver, String selectedValue) {
        waitForElementVisible(driver, EditProductPageUI.SELECTED_CATEGORY_BUTTON, selectedValue);
        return isElementDisplayed(driver, EditProductPageUI.SELECTED_CATEGORY_BUTTON, selectedValue);
    }

    public String getValueOfAvailableStartDateTextbox(WebDriver driver) {
        waitForElementVisible(driver, EditProductPageUI.AVAILABLE_START_DATE_TEXTBOX);
        return getAttributeValue(driver, EditProductPageUI.AVAILABLE_START_DATE_TEXTBOX, "value");
    }

    public String getValueOfAvailableEndDateTextbox(WebDriver driver) {
        waitForElementVisible(driver, EditProductPageUI.AVAILABLE_END_DATE_TEXTBOX);
        return getAttributeValue(driver, EditProductPageUI.AVAILABLE_END_DATE_TEXTBOX, "value");
    }
}
