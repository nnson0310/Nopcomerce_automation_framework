package page.interfaces.user;

public abstract class CompareListPageUI {
    public static final String COMPARED_PRODUCT_PRICE_TABLE_ROW = "xpath=//table[@class='compare-products-table']//a[text()='%s']//ancestor::tr[@class='product-name']//following-sibling::tr[@class='product-price']//td[%s]";
    public static final String PRODUCT_NAME_PRECEDING_SIBLING_ROW = "xpath=//table[@class='compare-products-table']//a[contains(text(), '%s')]//parent::td//preceding-sibling::td";
    public static final String CLEAR_LIST_BUTTON = "css=a.clear-list";
    public static final String CLEAR_LIST_MESSAGE = "xpath=//div[@class='no-data' and text()='%s']";
}
