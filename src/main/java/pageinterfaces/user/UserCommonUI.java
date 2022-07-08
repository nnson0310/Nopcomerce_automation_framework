package pageinterfaces.user;

public abstract class UserCommonUI {
    public static final String DYNAMIC_HEADER_LINK = "xpath=//div[@class='header-links']//a[@class='%s']";
    public static final String DYNAMIC_FOOTER_LINK = "xpath=//div[@class='footer']//a[text()='%s']";
    public static final String DYNAMIC_TOP_MENU = "xpath=//div[@class='header-menu']//ul[contains(@class, 'notmobile')]//a[contains(text(), '%s')]";
    public static final String DYNAMIC_PRODUCT_IMAGE_LINK = "xpath=//a[contains(text(), '%s')]//ancestor::div[@class='details']//preceding-sibling::div[@class='picture']//a";
    public static final String HEADER_LOGO_LINK = "css=div.header-logo a";
    public static final String WISHLIST_HEADER_QUANTITY = "css=div.header-links a.ico-wishlist span.wishlist-qty";
    public static final String ADD_TO_COMPARE_LIST_BUTTON = "xpath=//a[contains(text(), '%s')]//parent::h2//following-sibling::div[@class='add-info']//div[@class='buttons']//button[contains(@class, 'add-to-compare-list-button')]";
    public static final String SUCCESS_NOTIFICATION = "css=div#bar-notification p.content";
    public static final String CLOSE_NOTIFICATION_BUTTON = "css=div#bar-notification span.close";
    public static final String PRODUCT_PRICE_INFO = "xpath=//a[contains(text(), '%s')]//parent::h2//following-sibling::div[@class='add-info']//span[contains(@class, 'actual-price')]";
}
