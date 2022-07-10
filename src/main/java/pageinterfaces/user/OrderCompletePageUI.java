package pageinterfaces.user;

public abstract class OrderCompletePageUI {
    public static final String ORDER_SUCCESS_MESSAGE = "xpath=//div[contains(@class, 'order-completed')]//div[@class='title']//strong[contains(text(), '%s')]";
    public static final String ORDER_NUMBER_INFO = "css=div.order-number strong";
    public static final String ORDER_DETAIL_LINK = "css=div.details-link a";
}
