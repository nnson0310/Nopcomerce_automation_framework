package pageobjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageinterfaces.user.DesktopsPageUI;
import pageobjects.PageGeneratorManager;

public class DesktopsPage extends BasePage {
    WebDriver driver;

    public DesktopsPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductDetailsPage clickToProductTitle(WebDriver driver, String productTitle) {
        waitForElementVisible(driver, DesktopsPageUI.DYNAMIC_PRODUCT_TITLE, productTitle);
        clickToElement(driver, DesktopsPageUI.DYNAMIC_PRODUCT_TITLE, productTitle);
        return PageGeneratorManager.getPageGeneratorManager().getProductDetailsPage(driver);
    }
}
