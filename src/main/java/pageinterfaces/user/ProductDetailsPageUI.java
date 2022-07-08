package pageinterfaces.user;

public abstract class ProductDetailsPageUI {
    public static final String ADD_YOUR_REVIEW_LINK = "xpath=//div[@class='product-review-links']//a[text()='Add your review']";
    public static final String ADD_TO_WISHLIST_BUTTON = "css=div.add-to-wishlist button";
    public static final String QUANTITY_TEXTBOX = "css=input.qty-input";
    public static final String PROCESSOR_SELECT_DROPDOWN = "css=select#product_attribute_1";
    public static final String RAM_SELECT_DROPDOWN = "css=select#product_attribute_2";
    public static final String HDD_RADIO_BUTTON = "xpath=//label[contains(text(), '%s')]//preceding-sibling::input[@name='product_attribute_3']";
    public static final String OS_RADIO_BUTTON = "xpath=//label[contains(text(), '%s')]//preceding-sibling::input[@name='product_attribute_4']";
    public static final String SOFTWARE_CHECKBOX = "xpath=//label[contains(text(), '%s')]//preceding-sibling::input[@name='product_attribute_5']";
    public static final String ADD_TO_CART_BUTTON = "css=button.add-to-cart-button";
    public static final String PRODUCT_DETAILS_UNIT_PRICE = "css=div.product-price span";
    public static final String MINI_CART_PRODUCT_ITEM_NUMBER = "css=div.mini-shopping-cart div.count a";
    public static final String MINI_CART_PRODUCT_NAME = "xpath=//div[@class='mini-shopping-cart']//div[@class='name']//a[text()='%s']";
    public static final String MINI_CART_PRODUCT_ATTRIBUTES = "css=div.mini-shopping-cart div.attributes";
    public static final String MINI_CART_PRODUCT_UNIT_PRICE = "css=div.mini-shopping-cart div.price span";
    public static final String MINI_CART_PRODUCT_QTY = "css=div.mini-shopping-cart div.quantity span";
    public static final String MINI_CART_PRODUCT_SUBTOTAL = "css=div.mini-shopping-cart div.totals strong";
}
