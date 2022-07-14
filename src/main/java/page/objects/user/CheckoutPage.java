package page.objects.user;

import commons.UserBasePage;
import org.openqa.selenium.WebDriver;
import page.interfaces.user.CheckoutPageUI;
import page.objects.UserPageGeneratorManager;
import utilities.FunctionHelper;

public class CheckoutPage extends UserBasePage {
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectCountryOfBillingAddress(WebDriver driver, String country) {
        waitForElementClickable(driver, CheckoutPageUI.COUNTRY_SELECT_DROPDOWN);
        selectItemInDropDown(driver, CheckoutPageUI.COUNTRY_SELECT_DROPDOWN, country);
    }

    public void selectStateOfBillingAddress(WebDriver driver, String state) {
        waitForElementClickable(driver, CheckoutPageUI.STATE_SELECT_DROPDOWN);
        selectItemInDropDown(driver, CheckoutPageUI.STATE_SELECT_DROPDOWN, state);
    }

    public void clickToDynamicContinueButton(WebDriver driver, String fieldName) {
        waitForElementClickable(driver, CheckoutPageUI.CONTINUE_BUTTON, fieldName);
        clickToElement(driver, CheckoutPageUI.CONTINUE_BUTTON, fieldName);
    }

    public void clickToShippingMethodRadioButton(WebDriver driver, String shippingMethod) {
        waitForElementClickable(driver, CheckoutPageUI.SHIPPING_METHOD_RADIO_BUTTON, shippingMethod);
        checkCheckboxOrRadio(driver, CheckoutPageUI.SHIPPING_METHOD_RADIO_BUTTON, shippingMethod);
    }

    public void clickToPaymentMethodRadioButton(WebDriver driver, String paymentMethod) {
        waitForElementClickable(driver, CheckoutPageUI.PAYMENT_METHOD_RADIO_BUTTON, paymentMethod);
        checkCheckboxOrRadio(driver, CheckoutPageUI.PAYMENT_METHOD_RADIO_BUTTON, paymentMethod);
    }

    /**
     * Verify that all info of billing address is correct (confirm-order step)
     * @param driver
     * @param fullName
     * @param email
     * @param phoneNumber
     * @param company
     * @param address1
     * @param cityStateZip
     * @param country
     */
    public boolean isBillingAddressInfoCorrect(
            WebDriver driver,
            String fullName,
            String email,
            String phoneNumber,
            String company,
            String address1,
            String cityStateZip,
            String country
    ) {
        waitForElementVisible(driver, CheckoutPageUI.CHECKOUT_DATA);
        return isElementDisplayed(driver, CheckoutPageUI.DYNAMIC_BILLING_CONFIRM_ORDER_INFO, "name", fullName)
                && isElementDisplayed(driver, CheckoutPageUI.DYNAMIC_BILLING_CONFIRM_ORDER_INFO, "phone", phoneNumber)
                && isElementDisplayed(driver, CheckoutPageUI.DYNAMIC_BILLING_CONFIRM_ORDER_INFO, "company", company)
                && isElementDisplayed(driver, CheckoutPageUI.DYNAMIC_BILLING_CONFIRM_ORDER_INFO, "email", email)
                && isElementDisplayed(driver, CheckoutPageUI.DYNAMIC_BILLING_CONFIRM_ORDER_INFO, "address1", address1)
                && isElementDisplayed(driver, CheckoutPageUI.DYNAMIC_BILLING_CONFIRM_ORDER_INFO, "city-state-zip", cityStateZip)
                && isElementDisplayed(driver, CheckoutPageUI.DYNAMIC_BILLING_CONFIRM_ORDER_INFO, "country", country);
    }

    /**
     * Verify that all info of shipping address is correct (confirm-order step)
     * @param driver
     * @param fullName
     * @param email
     * @param phoneNumber
     * @param company
     * @param address1
     * @param cityStateZip
     * @param country
     */
    public boolean isShippingAddressInfoCorrect(
            WebDriver driver,
            String fullName,
            String email,
            String phoneNumber,
            String company,
            String address1,
            String cityStateZip,
            String country
    ) {
        waitForElementVisible(driver, CheckoutPageUI.CHECKOUT_DATA);
        return isElementDisplayed(driver, CheckoutPageUI.DYNAMIC_SHIPPING_ADDRESS_CONFIRM_ORDER_INFO, "name", fullName)
                && isElementDisplayed(driver, CheckoutPageUI.DYNAMIC_SHIPPING_ADDRESS_CONFIRM_ORDER_INFO, "phone", phoneNumber)
                && isElementDisplayed(driver, CheckoutPageUI.DYNAMIC_SHIPPING_ADDRESS_CONFIRM_ORDER_INFO, "company", company)
                && isElementDisplayed(driver, CheckoutPageUI.DYNAMIC_SHIPPING_ADDRESS_CONFIRM_ORDER_INFO, "email", email)
                && isElementDisplayed(driver, CheckoutPageUI.DYNAMIC_SHIPPING_ADDRESS_CONFIRM_ORDER_INFO, "address1", address1)
                && isElementDisplayed(driver, CheckoutPageUI.DYNAMIC_SHIPPING_ADDRESS_CONFIRM_ORDER_INFO, "city-state-zip", cityStateZip)
                && isElementDisplayed(driver, CheckoutPageUI.DYNAMIC_SHIPPING_ADDRESS_CONFIRM_ORDER_INFO, "country", country);
    }

    public String getPaymentMethodOfConfirmOrder(WebDriver driver) {
        waitForElementVisible(driver, CheckoutPageUI.PAYMENT_METHOD_CONFIRM_ORDER_INFO);
        return getElementText(driver, CheckoutPageUI.PAYMENT_METHOD_CONFIRM_ORDER_INFO);
    }

    public String getShippingMethodOfConfirmOrder(WebDriver driver) {
        waitForElementVisible(driver, CheckoutPageUI.SHIPPING_METHOD_CONFIRM_ORDER_INFO);
        return FunctionHelper.getOnlyCharacterFromString(getElementText(driver, CheckoutPageUI.SHIPPING_METHOD_CONFIRM_ORDER_INFO));
    }

    public boolean isCartInfoCorrect(
            WebDriver driver,
            String sku,
            String productName,
            String unitPrice,
            String quantity,
            String subTotal
    ) {
        waitForElementVisible(driver, CheckoutPageUI.CART_TABLE);
        return isElementDisplayed(driver, CheckoutPageUI.SKU_NUMBER_TABLE_ROW, sku)
                && isElementDisplayed(driver, CheckoutPageUI.PRODUCT_NAME_TABLE_ROW, productName)
                && isElementDisplayed(driver, CheckoutPageUI.UNIT_PRICE_TABLE_ROW, unitPrice)
                && isElementDisplayed(driver, CheckoutPageUI.QUANTITY_TABLE_ROW, quantity)
                && isElementDisplayed(driver, CheckoutPageUI.SUB_TOTAL_TABLE_ROW, subTotal);
    }

    public OrderCompletePage clickToConfirmButton(WebDriver driver) {
        waitForElementClickable(driver, CheckoutPageUI.CONFIRM_BUTTON);
        clickToElement(driver, CheckoutPageUI.CONFIRM_BUTTON);
        return UserPageGeneratorManager.getUserPageGeneratorManager().getOrderCompletePage(driver);
    }
}
