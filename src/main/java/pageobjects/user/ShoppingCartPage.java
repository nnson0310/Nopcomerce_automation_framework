package pageobjects.user;

import commons.UserBasePage;
import org.openqa.selenium.WebDriver;
import pageinterfaces.user.ShoppingCartPageUI;

public class ShoppingCartPage extends UserBasePage {
    WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductAddedToCart(WebDriver driver, String productName) {
        waitForElementVisible(driver, ShoppingCartPageUI.PRODUCT_ROW, productName, productName);
        return isElementDisplayed(driver, ShoppingCartPageUI.PRODUCT_ROW, productName, productName);
    }

    public String getProductQuantity(WebDriver driver, String productName) {
        waitForElementVisible(driver, ShoppingCartPageUI.PRODUCT_QUANTITY_INPUT, productName);
        return getAttributeValue(driver, ShoppingCartPageUI.PRODUCT_QUANTITY_INPUT, "value", productName);
    }

    public void clickToAgreeWithTermOfService(WebDriver driver) {
        waitForElementClickable(driver, ShoppingCartPageUI.AGREE_WITH_TERM_OF_SERVICE_CHECKBOX);
        clickToElement(driver, ShoppingCartPageUI.AGREE_WITH_TERM_OF_SERVICE_CHECKBOX);
    }

    public void clickToCheckoutButton(WebDriver driver) {
        waitForElementClickable(driver, ShoppingCartPageUI.CHECKOUT_BUTTON);
        clickToElement(driver, ShoppingCartPageUI.CHECKOUT_BUTTON);
    }

    public String getSubTotal(WebDriver driver) {
        waitForElementVisible(driver, ShoppingCartPageUI.SUB_TOTAL_INFO);
        return getElementText(driver, ShoppingCartPageUI.SUB_TOTAL_INFO);
    }
}
