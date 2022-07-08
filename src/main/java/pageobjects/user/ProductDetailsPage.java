package pageobjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageinterfaces.user.ProductDetailsPageUI;
import pageobjects.PageGeneratorManager;

public class ProductDetailsPage extends BasePage {

    WebDriver driver;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductReviewsPage clickToAddReviewLink(WebDriver driver) {
        waitForElementClickable(driver, ProductDetailsPageUI.ADD_YOUR_REVIEW_LINK);
        clickToElement(driver, ProductDetailsPageUI.ADD_YOUR_REVIEW_LINK);
        return PageGeneratorManager.getPageGeneratorManager().getProductReviewsPage(driver);
    }

    public void clickToAddToWishlistButton(WebDriver driver) {
        waitForElementVisible(driver, ProductDetailsPageUI.ADD_TO_WISHLIST_BUTTON);
        clickToElement(driver, ProductDetailsPageUI.ADD_TO_WISHLIST_BUTTON);
    }

    public String getSuccessNotificationContent(WebDriver driver) {
        waitForElementVisible(driver, ProductDetailsPageUI.SUCCESS_NOTIFICATION);
        return getElementText(driver, ProductDetailsPageUI.SUCCESS_NOTIFICATION);
    }

    public void clickToCloseBarNotificationButton(WebDriver driver) {
        waitForElementClickable(driver, ProductDetailsPageUI.CLOSE_NOTIFICATION_BUTTON);
        clickToElement(driver, ProductDetailsPageUI.CLOSE_NOTIFICATION_BUTTON);
    }

    public String getProductQuantity(WebDriver driver) {
        waitForElementVisible(driver, ProductDetailsPageUI.QUANTITY_TEXTBOX);
        return getAttributeValue(driver, ProductDetailsPageUI.QUANTITY_TEXTBOX, "value");
    }
}
