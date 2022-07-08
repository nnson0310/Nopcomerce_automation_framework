package pageobjects.user;

import commons.UserBasePage;
import org.openqa.selenium.WebDriver;
import pageinterfaces.user.MyProductReviewsPageUI;
import utilities.FunctionHelper;

public class MyProductReviewsPage extends UserBasePage {
    WebDriver driver;

    public MyProductReviewsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductReviewTitle(WebDriver driver) {
        waitForElementVisible(driver, MyProductReviewsPageUI.PRODUCT_REVIEW_TITLE);
        return getElementText(driver, MyProductReviewsPageUI.PRODUCT_REVIEW_TITLE);
    }

    public String getProductReviewText(WebDriver driver) {
        waitForElementVisible(driver, MyProductReviewsPageUI.PRODUCT_REVIEW_TEXT);
        return getElementText(driver, MyProductReviewsPageUI.PRODUCT_REVIEW_TEXT);
    }

    public int getProductRating(WebDriver driver) {
        return FunctionHelper.getProductReviewRatingByWidthValue(getAttributeValue(driver, MyProductReviewsPageUI.PRODUCT_REVIEW_RATING, "style"));
    }
}
