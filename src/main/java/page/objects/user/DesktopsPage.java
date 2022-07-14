package page.objects.user;

import commons.UserBasePage;
import org.openqa.selenium.WebDriver;
import page.interfaces.user.DesktopsPageUI;
import page.objects.UserPageGeneratorManager;

public class DesktopsPage extends UserBasePage {
    WebDriver driver;

    public DesktopsPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductDetailsPage clickToProductTitle(WebDriver driver, String productTitle) {
        waitForElementVisible(driver, DesktopsPageUI.DYNAMIC_PRODUCT_TITLE, productTitle);
        clickToElement(driver, DesktopsPageUI.DYNAMIC_PRODUCT_TITLE, productTitle);
        return UserPageGeneratorManager.getUserPageGeneratorManager().getProductDetailsPage(driver);
    }
}
