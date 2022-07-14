package page.objects.user;

import commons.UserBasePage;
import org.openqa.selenium.WebDriver;
import page.interfaces.user.ProductDetailsPageUI;
import page.objects.UserPageGeneratorManager;
import utilities.FunctionHelper;

public class ProductDetailsPage extends UserBasePage {

    WebDriver driver;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductReviewsPage clickToAddReviewLink(WebDriver driver) {
        waitForElementClickable(driver, ProductDetailsPageUI.ADD_YOUR_REVIEW_LINK);
        clickToElement(driver, ProductDetailsPageUI.ADD_YOUR_REVIEW_LINK);
        return UserPageGeneratorManager.getUserPageGeneratorManager().getProductReviewsPage(driver);
    }

    public void clickToAddToWishlistButton(WebDriver driver) {
        waitForElementVisible(driver, ProductDetailsPageUI.ADD_TO_WISHLIST_BUTTON);
        clickToElement(driver, ProductDetailsPageUI.ADD_TO_WISHLIST_BUTTON);
    }

    public String getProductQuantity(WebDriver driver) {
        waitForElementVisible(driver, ProductDetailsPageUI.QUANTITY_TEXTBOX);
        return getAttributeValue(driver, ProductDetailsPageUI.QUANTITY_TEXTBOX, "value");
    }

    public void selectProcessorDropdown(WebDriver driver, String processor) {
        waitForElementClickable(driver, ProductDetailsPageUI.PROCESSOR_SELECT_DROPDOWN);
        selectItemInDropDown(driver, ProductDetailsPageUI.PROCESSOR_SELECT_DROPDOWN, processor);
    }

    public void selectRamDropdown(WebDriver driver, String ram) {
        waitForElementClickable(driver, ProductDetailsPageUI.RAM_SELECT_DROPDOWN);
        selectItemInDropDown(driver, ProductDetailsPageUI.RAM_SELECT_DROPDOWN, ram);
    }

    public void clickToHddRadioButton(WebDriver driver, String hdd) {
        waitForElementClickable(driver, ProductDetailsPageUI.HDD_RADIO_BUTTON, hdd);
        checkCheckboxOrRadio(driver, ProductDetailsPageUI.HDD_RADIO_BUTTON, hdd);
    }

    public void clickToOsRadioButton(WebDriver driver, String os) {
        waitForElementClickable(driver, ProductDetailsPageUI.OS_RADIO_BUTTON, os);
        checkCheckboxOrRadio(driver, ProductDetailsPageUI.OS_RADIO_BUTTON, os);
    }

    public void clickToSoftwareCheckbox(WebDriver driver, String software) {
        waitForElementClickable(driver, ProductDetailsPageUI.SOFTWARE_CHECKBOX, software);
        checkCheckboxOrRadio(driver, ProductDetailsPageUI.SOFTWARE_CHECKBOX, software);
    }

    public void enterToProductQuantityTextbox(WebDriver driver, String qty) {
        waitForElementVisible(driver, ProductDetailsPageUI.QUANTITY_TEXTBOX);
        sendKeyToElement(driver, ProductDetailsPageUI.QUANTITY_TEXTBOX, qty);
    }

    public void clickToAddToCartButton(WebDriver driver) {
        waitForElementClickable(driver, ProductDetailsPageUI.ADD_TO_CART_BUTTON);
        clickToElement(driver, ProductDetailsPageUI.ADD_TO_CART_BUTTON);
    }

    public String getProductUnitPrice(WebDriver driver) {
        waitForElementVisible(driver, ProductDetailsPageUI.PRODUCT_DETAILS_UNIT_PRICE);
        return getElementText(driver, ProductDetailsPageUI.PRODUCT_DETAILS_UNIT_PRICE);
    }

    public String getProductQuantityFromMiniCart(WebDriver driver) {
        waitForElementVisible(driver, ProductDetailsPageUI.MINI_CART_PRODUCT_ITEM_NUMBER);
        return getElementText(driver, ProductDetailsPageUI.MINI_CART_PRODUCT_ITEM_NUMBER).replaceAll("[^0-9]","");
    }

    public boolean isMiniCartProductNameDisplayed(WebDriver driver, String productName) {
        waitForElementVisible(driver, ProductDetailsPageUI.MINI_CART_PRODUCT_NAME, productName);
        return isElementDisplayed(driver, ProductDetailsPageUI.MINI_CART_PRODUCT_NAME, productName);
    }

    public String getMiniCartProductInfo(WebDriver driver) {
        waitForElementVisible(driver, ProductDetailsPageUI.MINI_CART_PRODUCT_ATTRIBUTES);
        return getElementText(driver, ProductDetailsPageUI.MINI_CART_PRODUCT_ATTRIBUTES);
    }

    public String getMiniCartProductUnitPrice(WebDriver driver) {
        waitForElementVisible(driver, ProductDetailsPageUI.MINI_CART_PRODUCT_UNIT_PRICE);
        return getElementText(driver, ProductDetailsPageUI.MINI_CART_PRODUCT_UNIT_PRICE);
    }

    public String getMiniCartProductQuantity(WebDriver driver) {
        waitForElementVisible(driver, ProductDetailsPageUI.MINI_CART_PRODUCT_QTY);
        return getElementText(driver, ProductDetailsPageUI.MINI_CART_PRODUCT_QTY);
    }

    public String getMiniCartProductSubTotal(WebDriver driver) {
        waitForElementVisible(driver, ProductDetailsPageUI.MINI_CART_PRODUCT_SUBTOTAL);
        String subTotal = getElementText(driver, ProductDetailsPageUI.MINI_CART_PRODUCT_SUBTOTAL);
        return FunctionHelper.getProductPriceByText(subTotal);
    }

    public String getSkuCode(WebDriver driver) {
        waitForElementVisible(driver, ProductDetailsPageUI.SKU_CODE_INFO);
        return getElementText(driver, ProductDetailsPageUI.SKU_CODE_INFO);
    }
}
