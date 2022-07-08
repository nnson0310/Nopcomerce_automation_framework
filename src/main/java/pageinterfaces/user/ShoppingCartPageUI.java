package pageinterfaces.user;

public abstract class ShoppingCartPageUI {
    public static final String PRODUCT_ROW = "xpath=//a[@class='product-name' and contains(text(), '%s')]//parent::td//preceding-sibling::td[@class='product-picture']//img[contains(@alt, '%s')]//ancestor::tr";
    public static final String PRODUCT_QUANTITY_INPUT = "xpath=//a[@class='product-name' and contains(text(), '%s')]//parent::td//following-sibling::td[@class='quantity']//input";
}
