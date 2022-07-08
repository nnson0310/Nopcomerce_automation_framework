package pageinterfaces.user;

public abstract class ProductDetailsPageUI {
    public static final String ADD_YOUR_REVIEW_LINK = "xpath=//div[@class='product-review-links']//a[text()='Add your review']";
    public static final String ADD_TO_WISHLIST_BUTTON = "css=div.add-to-wishlist button";
    public static final String DYNAMIC_BAR_NOTIFICATION = "//div[@id='bar-notification']//p[@class='content' and contains(text(), '%s')]";
    public static final String SUCCESS_NOTIFICATION = "css=div#bar-notification p.content";
    public static final String CLOSE_NOTIFICATION_BUTTON = "css=div#bar-notification span.close";
    public static final String QUANTITY_TEXTBOX = "css=input.qty-input";
}
