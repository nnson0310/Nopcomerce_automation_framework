package pageinterfaces;

public abstract class CommonUI {

    public static final String DYNAMIC_HEADER_LINK = "xpath=//div[@class='header-links']//a[text()='%s']";
    public static final String DYNAMIC_FOOTER_LINK = "xpath=//div[@class='footer']//a[text()='%s']";
    public static final String DYNAMIC_TOP_MENU = "xpath=//div[@class='header-menu']//ul[contains(@class, 'notmobile')]//a[contains(text(), '%s')]";
}
