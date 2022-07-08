package pageobjects.user;

import commons.UserBasePage;
import org.openqa.selenium.WebDriver;
import pageinterfaces.user.ProductReviewsPageUI;

public class ProductReviewsPage extends UserBasePage {
    WebDriver driver;

    public ProductReviewsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToReviewTitleTextbox(WebDriver driver, String reviewTitle) {
        waitForElementVisible(driver, ProductReviewsPageUI.REVIEW_TITLE_TEXTBOX);
        sendKeyToElement(driver, ProductReviewsPageUI.REVIEW_TITLE_TEXTBOX, reviewTitle);
    }

    public void inputToReviewTextTextarea(WebDriver driver, String reviewText) {
        waitForElementVisible(driver, ProductReviewsPageUI.REVIEW_TEXT_TEXTAREA);
        sendKeyToElement(driver, ProductReviewsPageUI.REVIEW_TEXT_TEXTAREA, reviewText);
    }

    public void clickToRatingRadioButton(WebDriver driver, String rating) {
        waitForElementClickable(driver, ProductReviewsPageUI.RATING_RATIO_BUTTON, rating);
        checkCheckboxOrRadio(driver, ProductReviewsPageUI.RATING_RATIO_BUTTON, rating);
    }

    public void clickToSubmitReviewButton(WebDriver driver) {
        waitForElementClickable(driver, ProductReviewsPageUI.SUBMIT_REVIEW_BUTTON);
        clickToElement(driver, ProductReviewsPageUI.SUBMIT_REVIEW_BUTTON);
    }

    public boolean isResultMessageDisplayed(WebDriver driver, String message) {
        waitForElementVisible(driver, ProductReviewsPageUI.DYNAMIC_RESULT_MESSAGE, message);
        return isElementDisplayed(driver, ProductReviewsPageUI.DYNAMIC_RESULT_MESSAGE, message);
    }
}
