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
}
