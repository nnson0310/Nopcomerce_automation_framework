package pageinterfaces.user;

public abstract class UserCommonUI {
    public static final String DYNAMIC_HEADER_LINK = "xpath=//div[@class='header-links']//a[@class='%s']";
    public static final String DYNAMIC_FOOTER_LINK = "xpath=//div[@class='footer']//a[text()='%s']";
    public static final String DYNAMIC_TOP_MENU = "xpath=//div[@class='header-menu']//ul[contains(@class, 'notmobile')]//a[contains(text(), '%s')]";
    public static final String DYNAMIC_PRODUCT_IMAGE_LINK = "xpath=//a[contains(text(), '%s')]//ancestor::div[@class='details']//preceding-sibling::div[@class='picture']//a";
    public static final String HEADER_LOGO_LINK = "css=div.header-logo a";
    public static final String WISHLIST_HEADER_QUANTITY = "css=div.header-links a.ico-wishlist span.wishlist-qty";
}
