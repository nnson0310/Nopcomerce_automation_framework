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
    public static final String MOD_SWITCH_BUTTON = "css=span.onoffswitch-switch";
}
