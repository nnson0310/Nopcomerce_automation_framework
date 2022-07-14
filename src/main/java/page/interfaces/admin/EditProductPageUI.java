package page.interfaces.admin;

public abstract class EditProductPageUI {
    public static final String TAG_ITEM_DELETE_BUTTON = "css=ul.tag-editor div.tag-editor-delete i";
    public static final String PRODUCT_TAG_TEXTBOX = "css=input#ProductTags";
    public static final String SELECTED_CATEGORY_BUTTON = "xpath=//li[@class='k-button']//span[text()='%s']";
    public static final String AVAILABLE_START_DATE_TEXTBOX = "css=input#AvailableStartDateTimeUtc";
    public static final String AVAILABLE_END_DATE_TEXTBOX = "css=input#AvailableEndDateTimeUtc";
}
