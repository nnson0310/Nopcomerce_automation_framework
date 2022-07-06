package pageinterfaces.user;

public abstract class SearchPageUI {
    public static final String SEARCH_TEXTBOX = "css=input.search-text";
    public static final String SEARCH_BUTTON = "css=button.search-button";
    public static final String DYNAMIC_SEARCH_ERROR = "xpath=//div[@class='products-wrapper']//div[text()='%s']";
    public static final String SEARCH_RESULT_TITLE = "css=div.product-item h2.product-title";
    public static final String CATEGORY_SELECT_DROPDOWN = "css=select#cid";
    public static final String ADVANCED_SEARCH_CHECKBOX = "css=input#advs";
    public static final String SEARCH_WITH_SUB_CATEGORY_CHECKBOX = "css=input#isc";
}
