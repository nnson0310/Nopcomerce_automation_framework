package pageinterfaces.user;

public abstract class OrderDetailPageUI {
    public static final String ORDER_NUMBER_INFO = "xpath=//div[@class='order-number']//strong[contains(text(), '%s')]";
    public static final String PDF_INVOICE_BUTTON = "css=a.pdf-invoice-button";
}
