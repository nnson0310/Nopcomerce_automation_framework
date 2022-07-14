package page.objects.user;

import commons.UserBasePage;
import org.openqa.selenium.WebDriver;
import page.interfaces.user.OrderCompletePageUI;
import page.objects.UserPageGeneratorManager;

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
        return UserPageGeneratorManager.getUserPageGeneratorManager().getOrderDetailPage(driver);
    }
}
