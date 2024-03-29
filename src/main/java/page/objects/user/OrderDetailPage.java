package page.objects.user;

import commons.UserBasePage;
import custom.exception.NoPDFContentException;
import org.openqa.selenium.WebDriver;
import page.interfaces.user.OrderDetailPageUI;
import utilities.FunctionHelper;

public class OrderDetailPage extends UserBasePage {
    WebDriver driver;

    public OrderDetailPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOrderNumberDisplayed(WebDriver driver, String orderNumber) {
        waitForElementVisible(driver, OrderDetailPageUI.ORDER_NUMBER_INFO, orderNumber);
        return isElementDisplayed(driver, OrderDetailPageUI.ORDER_NUMBER_INFO, orderNumber);
    }

    public void clickToPDFInvoiceButton(WebDriver driver) {
        waitForElementClickable(driver, OrderDetailPageUI.PDF_INVOICE_BUTTON);
        clickToElement(driver, OrderDetailPageUI.PDF_INVOICE_BUTTON);
    }

    public boolean verifyPdfContent(String pdfName, String pathToFile, String requestText) {
        String pdfContent = FunctionHelper.readPdfContent(pathToFile);
        if (pdfContent == null || pdfContent.isEmpty()) {
            throw new NoPDFContentException(pdfName, pathToFile);
        }
        if (!pdfContent.contains(requestText)) {
            return false;
        }
        return true;
    }
}
