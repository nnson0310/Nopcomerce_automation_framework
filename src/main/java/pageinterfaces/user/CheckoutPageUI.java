package pageinterfaces.user;

public abstract class CheckoutPageUI {

    public static final String COUNTRY_SELECT_DROPDOWN = "css=select#BillingNewAddress_CountryId";
    public static final String STATE_SELECT_DROPDOWN = "css=select#BillingNewAddress_StateProvinceId";
    public static final String CONTINUE_BUTTON = "xpath=//button[contains(@class, '%s') and text()='Continue']";
    public static final String SHIPPING_METHOD_RADIO_BUTTON = "xpath=//div[@id='shipping-methods-form']//label[contains(text(), '%s')]//preceding-sibling::input";
    public static final String PAYMENT_METHOD_RADIO_BUTTON = "xpath=//div[@id='checkout-payment-method-load']//label[contains(text(), '%s')]//preceding-sibling::input";
    public static final String CHECKOUT_DATA = "css=li#opc-confirm_order";
    public static final String DYNAMIC_BILLING_CONFIRM_ORDER_INFO = "xpath=//div[@class='billing-info']//li[@class='%s' and contains(text(), '%s')]";
    public static final String PAYMENT_METHOD_CONFIRM_ORDER_INFO = "css=li#opc-confirm_order li.payment-method span.value";
    public static final String SHIPPING_METHOD_CONFIRM_ORDER_INFO = "css=li#opc-confirm_order li.shipping-method span.value";
    public static final String DYNAMIC_SHIPPING_ADDRESS_CONFIRM_ORDER_INFO = "xpath=//div[@class='shipping-info']//li[@class='%s' and contains(text(), '%s')]";
    public static final String CART_TABLE = "css=table.cart";
    public static final String SKU_NUMBER_TABLE_ROW = "xpath=//table[@class='cart']//span[@class='sku-number' and text()='%s']";
    public static final String PRODUCT_NAME_TABLE_ROW = "xpath=//table[@class='cart']//a[@class='product-name' and text()='%s']";
    public static final String UNIT_PRICE_TABLE_ROW = "xpath=//table[@class='cart']//span[@class='product-unit-price' and text()='%s']";
    public static final String QUANTITY_TABLE_ROW = "xpath=//table[@class='cart']//span[@class='product-quantity' and text()='%s']";
    public static final String SUB_TOTAL_TABLE_ROW = "xpath=//table[@class='cart']//span[@class='product-subtotal' and text()='%s']";
    public static final String CONFIRM_BUTTON = "css=div#confirm-order-buttons-container button";
}
