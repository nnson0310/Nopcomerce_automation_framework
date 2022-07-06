package pageinterfaces.user;

public abstract class MyAccountPageUI {

    public static final String DYNAMIC_TEXTBOX = "xpath=//div[contains(@class, 'customer-info-page')]//input[@id='%s']";
    public static final String SAVE_BUTTON = "css=button#save-info-button";
    public static final String DYNAMIC_BLOCK_ACCOUNT_NAVIGATION = "xpath=//div[contains(@class, 'block-account-navigation')]//a[text()='%s']";
    public static final String DYNAMIC_TOP_MENU = "xpath=//div[@class='header-menu']//ul[contains(@class, 'notmobile')]//a[contains(text(), '%s')]";
}
