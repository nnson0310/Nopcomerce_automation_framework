package pageinterfaces.user;

public abstract class ShoppingCartPageUI {
    public static final String PRODUCT_ROW = "xpath=//a[@class='product-name' and contains(text(), '%s')]//parent::td//preceding-sibling::td[@class='product-picture']//img[contains(@alt, '%s')]//ancestor::tr";
    public static final String PRODUCT_QUANTITY_INPUT = "xpath=//a[@class='product-name' and contains(text(), '%s')]//parent::td//following-sibling::td[@class='quantity']//input";
    public static final String AGREE_WITH_TERM_OF_SERVICE_CHECKBOX = "css=input#termsofservice";
    public static final String CHECKOUT_BUTTON = "css=button#checkout";
    public static final String SUB_TOTAL_INFO = "css=table.cart-total tr.order-subtotal span.value-summary";
}
