package page.interfaces.admin;

public abstract class AdminCommonUI {
    public static final String CONTENT_HEADER = "xpath=//div[@class='content-header']//h1[contains(text(), '%s')]";
    public static final String DYNAMIC_INPUT_BY_NAME = "xpath=//input[@name='%s']";
    public static final String DYNAMIC_BUTTON_BY_ID = "xpath=//button[@id='%s']";
    public static final String SEARCH_RESULT_NAME_LABEL_TABLE_ROW = "xpath=//table[@id='%s']//td[contains(text(), '%s')]";
    public static final String TABLE_ROW = "xpath=//table[@id='%s']//tbody/tr";
    public static final String DYNAMIC_SELECT_BY_NAME = "xpath=//select[@name='%s']";
    public static final String NO_DATA_AVAILABLE_MESSAGE_TABLE_ROW = "xpath=//td[@class='dataTables_empty' and contains(text(), '%s')]";
    public static final String DYNAMIC_MULTI_SELECT_DELETE_BUTTON = "xpath=//ul[@id='%s']//span[@class='k-select']";
    public static final String DYNAMIC_MULTI_SELECT = "xpath=//ul[@id='%s']//parent::div";
    public static final String DYNAMIC_MULTI_SELECT_ITEM = "xpath=//ul[@id='%s']//li[@class='k-item' and text()='%s']";
    public static final String DYNAMIC_BUTTON_BY_NAME = "xpath=//button[@name='%s']";
    public static final String SUCCESS_ALERT = "xpath=//div[contains(@class, 'alert-success')]";
    public static final String TABLE_BUTTON_COLUMN_HEADER = "xpath=//table//th[text()='%s']//preceding-sibling::th";
    public static final String ITEM_LABEL_TABLE_ROW = "xpath=//table//td[text()='%s']//parent::tr//preceding-sibling::tr";
    public static final String TABLE_ROW_EDIT_BUTTON = "xpath=//tr[%s]//td[%s]//a";
    public static final String CARD_TITLE_LABEL_DIV = "xpath=//nop-cards[@id='%s']//div[@id='%s']";
    public static final String BACK_TO_PREV_PAGE_LINK = "xpath=//i[contains(@class, 'fa-arrow-circle-left')]//following-sibling::a[text()='%s']";
    public static final String ALERT_CLOSE_BUTTON = "css=div.alert button.close";
    public static final String ADD_NEW_BUTTON = "xpath=//i[contains(@class, 'fa-plus-square')]//parent::a";
    public static final String NO_DATA_IN_TABLE_MESSAGE = "xpath=//table[@id='%s']//td[@class='dataTables_empty' and text()='No data available in table']";
}
