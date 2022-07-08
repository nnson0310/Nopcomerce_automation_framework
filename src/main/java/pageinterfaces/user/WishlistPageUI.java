package pageinterfaces.user;

public abstract class WishlistPageUI {
    public static final String PRODUCT_ITEM_TABLE_ROW = "xpath=//table//td[@class='product']//a[@class='product-name' and contains(text(), '%s')]";
    public static final String SHARE_WISHLIST_LINK = "css=div.share-info a.share-link";
    public static final String ADD_TO_CART_CHECKBOX = "xpath=//a[@class='product-name' and contains(text(), '%s')]//parent::td//preceding-sibling::td[@class='add-to-cart']//input";
    public static final String ADD_TO_CART_BUTTON = "css=button[name='addtocartbutton']";
}
