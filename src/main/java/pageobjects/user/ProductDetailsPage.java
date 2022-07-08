package pageobjects.user;

import commons.UserBasePage;
import org.openqa.selenium.WebDriver;
import pageinterfaces.user.ProductDetailsPageUI;
import pageobjects.PageGeneratorManager;

public class ProductDetailsPage extends UserBasePage {

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

    public String getProductQuantity(WebDriver driver) {
        waitForElementVisible(driver, ProductDetailsPageUI.QUANTITY_TEXTBOX);
        return getAttributeValue(driver, ProductDetailsPageUI.QUANTITY_TEXTBOX, "value");
    }
}
