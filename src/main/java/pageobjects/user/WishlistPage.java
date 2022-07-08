package pageobjects.user;

import commons.UserBasePage;
import org.openqa.selenium.WebDriver;
import pageinterfaces.user.WishlistPageUI;

public class WishlistPage extends UserBasePage {
    WebDriver driver;

    public WishlistPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductAddedToWishlist(WebDriver driver, String productName) {
        waitForAllElementVisible(driver, WishlistPageUI.PRODUCT_ITEM_TABLE_ROW, productName);
        return isElementDisplayed(driver, WishlistPageUI.PRODUCT_ITEM_TABLE_ROW, productName);
    }

    public void clickToSharingLink(WebDriver driver) {
        waitForElementClickable(driver, WishlistPageUI.SHARE_WISHLIST_LINK);
        clickToElement(driver, WishlistPageUI.SHARE_WISHLIST_LINK);
    }

    public void clickToAddToCartCheckbox(WebDriver driver, String productName) {
        waitForElementClickable(driver, WishlistPageUI.ADD_TO_CART_CHECKBOX, productName);
        clickToElement(driver, WishlistPageUI.ADD_TO_CART_CHECKBOX, productName);
    }

    public void clickToAddToCartButton(WebDriver driver) {
        waitForElementClickable(driver, WishlistPageUI.ADD_TO_CART_BUTTON);
        clickToElement(driver, WishlistPageUI.ADD_TO_CART_BUTTON);
    }
}
