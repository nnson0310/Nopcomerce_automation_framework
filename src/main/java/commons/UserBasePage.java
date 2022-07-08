package commons;

import org.openqa.selenium.WebDriver;
import pageinterfaces.user.SearchPageUI;
import pageinterfaces.user.UserCommonUI;
import pageobjects.PageGeneratorManager;
import pageobjects.user.UserHomePage;

import java.util.List;

public class UserBasePage extends BasePage {

    public void clickToDynamicHeaderLink(WebDriver driver, String fieldName) {
        waitForElementClickable(driver, UserCommonUI.DYNAMIC_HEADER_LINK, fieldName);
        clickToElement(driver, UserCommonUI.DYNAMIC_HEADER_LINK, fieldName);
    }

    public void clickToDynamicFooterLink(WebDriver driver, String fieldName) {
        waitForElementClickable(driver, UserCommonUI.DYNAMIC_FOOTER_LINK, fieldName);
        clickToElement(driver, UserCommonUI.DYNAMIC_FOOTER_LINK, fieldName);
    }

    public void clickToTopMenuSubList(WebDriver driver, String topMenu, String topMenuSubList) {
        //hover to top menu
        waitForElementClickable(driver, UserCommonUI.DYNAMIC_TOP_MENU, topMenu);
        hoverToElement(driver, UserCommonUI.DYNAMIC_TOP_MENU, topMenu);

        //click to choose top menu sublist
        waitForElementClickable(driver, UserCommonUI.DYNAMIC_TOP_MENU, topMenuSubList);
        clickToElement(driver, UserCommonUI.DYNAMIC_TOP_MENU, topMenuSubList);
    }

    /**
     * Check if search result contains corresponding product names
     * @param driver Webdriver instance
     * @param productName name of product name as search keyword
     * @return boolean value
     */
    public boolean isSearchResultDisplayedCorrect(WebDriver driver, String productName) {
        List<String> productTitles = getElementsText(driver, SearchPageUI.SEARCH_RESULT_TITLE);
        boolean result = true;
        for(String productTitle : productTitles) {
            if (!productTitle.contains(productName)) {
                result = false;
            }
        }
        return result;
    }

    public void clickToDynamicProductImageLink(WebDriver driver, String productName) {
        waitForElementClickable(driver, UserCommonUI.DYNAMIC_PRODUCT_IMAGE_LINK, productName);
        clickToElement(driver, UserCommonUI.DYNAMIC_PRODUCT_IMAGE_LINK, productName);
    }

    public UserHomePage clickToHeaderLogoLink(WebDriver driver) {
        waitForElementClickable(driver, UserCommonUI.HEADER_LOGO_LINK);
        clickToElement(driver, UserCommonUI.HEADER_LOGO_LINK);
        return PageGeneratorManager.getPageGeneratorManager().getUserHomePage(driver);
    }

    public String getProductQuantityOfWishlistHeaderLink(WebDriver driver) {
        waitForElementVisible(driver, UserCommonUI.WISHLIST_HEADER_LINK_QTY);
        return getElementText(driver, UserCommonUI.WISHLIST_HEADER_LINK_QTY).replaceAll("[()]","");
    }

    public String getProductQuantityOfShoppingCartHeaderLink(WebDriver driver) {
        waitForElementVisible(driver, UserCommonUI.SHOPPING_CART_HEADER_LINK_QTY);
        return getElementText(driver, UserCommonUI.SHOPPING_CART_HEADER_LINK_QTY).replaceAll("[()]","");
    }

    public void clickToAddToCompareListButton(WebDriver driver, String productName) {
        waitForElementClickable(driver, UserCommonUI.ADD_TO_COMPARE_LIST_BUTTON, productName);
        clickToElement(driver, UserCommonUI.ADD_TO_COMPARE_LIST_BUTTON, productName);
    }

    public String getSuccessNotificationContent(WebDriver driver) {
        waitForElementVisible(driver, UserCommonUI.SUCCESS_NOTIFICATION);
        return getElementText(driver, UserCommonUI.SUCCESS_NOTIFICATION);
    }

    public void clickToCloseBarNotificationButton(WebDriver driver) {
        waitForElementClickable(driver, UserCommonUI.CLOSE_NOTIFICATION_BUTTON);
        clickToElement(driver, UserCommonUI.CLOSE_NOTIFICATION_BUTTON);
    }

    public String getProductPrice(WebDriver driver, String productName) {
        waitForElementVisible(driver, UserCommonUI.PRODUCT_PRICE_INFO, productName);
        return getElementText(driver, UserCommonUI.PRODUCT_PRICE_INFO, productName);
    }

    public void hoverToShoppingCartHeaderLink(WebDriver driver, String fieldName) {
        waitForElementClickable(driver, UserCommonUI.DYNAMIC_HEADER_LINK, fieldName);
        scrollToElement(driver, UserCommonUI.DYNAMIC_HEADER_LINK, fieldName);
        hoverToElement(driver, UserCommonUI.DYNAMIC_HEADER_LINK, fieldName);
    }
}
