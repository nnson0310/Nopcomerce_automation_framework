package pageobjects.user;

import commons.UserBasePage;
import org.openqa.selenium.WebDriver;
import pageinterfaces.user.OrderCompletePageUI;
import pageobjects.PageGeneratorManager;

public class OrderCompletePage extends UserBasePage {
    WebDriver driver;

    public OrderCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOrderSuccessMessageDisplayed(WebDriver driver, String message) {
        waitForElementVisible(driver, OrderCompletePageUI.ORDER_SUCCESS_MESSAGE, message);
        return isElementDisplayed(driver, OrderCompletePageUI.ORDER_SUCCESS_MESSAGE, message);
    }

    public String getOrderNumberInfo(WebDriver driver) {
        waitForElementVisible(driver, OrderCompletePageUI.ORDER_NUMBER_INFO);
        return getElementText(driver, OrderCompletePageUI.ORDER_NUMBER_INFO).replaceAll("[^0-9]","");
    }

    public OrderDetailPage clickToOrderDetailLink(WebDriver driver) {
        waitForElementClickable(driver, OrderCompletePageUI.ORDER_DETAIL_LINK);
        clickToElement(driver, OrderCompletePageUI.ORDER_DETAIL_LINK);
        return PageGeneratorManager.getPageGeneratorManager().getOrderDetailPage(driver);
    }
}
