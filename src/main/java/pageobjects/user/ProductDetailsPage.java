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
}
