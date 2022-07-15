package page.objects.admin;

import commons.AdminBasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import page.interfaces.admin.ProductEditPageUI;

public class ProductEditPage extends AdminBasePage  {
    WebDriver driver;
    JavascriptExecutor jsExecutor;

    public ProductEditPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isSelectedCategoryItemDisplayed(WebDriver driver, String selectedValue) {
        waitForElementVisible(driver, ProductEditPageUI.SELECTED_CATEGORY_BUTTON, selectedValue);
        return isElementDisplayed(driver, ProductEditPageUI.SELECTED_CATEGORY_BUTTON, selectedValue);
    }

    public String getValueOfAvailableStartDateTextbox(WebDriver driver) {
        waitForElementVisible(driver, ProductEditPageUI.AVAILABLE_START_DATE_TEXTBOX);
        return getAttributeValue(driver, ProductEditPageUI.AVAILABLE_START_DATE_TEXTBOX, "value");
    }

    public String getValueOfAvailableEndDateTextbox(WebDriver driver) {
        waitForElementVisible(driver, ProductEditPageUI.AVAILABLE_END_DATE_TEXTBOX);
        return getAttributeValue(driver, ProductEditPageUI.AVAILABLE_END_DATE_TEXTBOX, "value");
    }
}
