package pageobjects;

import org.openqa.selenium.WebDriver;
import pageobjects.user.*;

public class PageGeneratorManager {

    private static PageGeneratorManager pageGeneratorManager;

    private PageGeneratorManager() {

    }

    public synchronized static PageGeneratorManager getPageGeneratorManager() {
        if (pageGeneratorManager == null) {
            return new PageGeneratorManager();
        }
        return pageGeneratorManager;
    }

    public UserHomePage getUserHomePage(WebDriver driver) {
        return new UserHomePage(driver);
    }

    public UserLoginPage getUserLoginPage(WebDriver driver) {
        return new UserLoginPage(driver);
    }

    public UserRegisterPage getUserRegisterPage(WebDriver driver) {
        return new UserRegisterPage(driver);
    }

    public UserRegisterResultPage getUserRegisterResultPage(WebDriver driver) {
        return new UserRegisterResultPage(driver);
    }

    public MyAccountPage getMyAccountPage(WebDriver driver) {
        return new MyAccountPage(driver);
    }

    public DesktopsPage getDesktopsPage(WebDriver driver) {
        return new DesktopsPage(driver);
    }

    public ProductDetailsPage getProductDetailsPage(WebDriver driver) {
        return new ProductDetailsPage(driver);
    }

    public ProductReviewsPage getProductReviewsPage(WebDriver driver) {
        return new ProductReviewsPage(driver);
    }

    public MyProductReviewsPage getMyProductReviewsPage(WebDriver driver) {
        return new MyProductReviewsPage(driver);
    }

    public SearchPage getSearchPage(WebDriver driver) {
        return new SearchPage(driver);
    }

    public NotebookPage getNotebookPage(WebDriver driver) {
        return new NotebookPage(driver);
    }

    public WishlistPage getWishlistPage(WebDriver driver) {
        return new WishlistPage(driver);
    }

    public ShoppingCartPage getShoppingCartPage(WebDriver driver) {
        return new ShoppingCartPage(driver);
    }

    public CompareListPage getCompareListPage(WebDriver driver) {
        return new CompareListPage(driver);
    }

    public CheckoutPage getCheckoutPage(WebDriver driver) {
        return new CheckoutPage(driver);
    }

    public OrderCompletePage getOrderCompletePage(WebDriver driver) {
        return new OrderCompletePage(driver);
    }

    public OrderDetailPage getOrderDetailPage(WebDriver driver) {
        return new OrderDetailPage(driver);
    }

}
