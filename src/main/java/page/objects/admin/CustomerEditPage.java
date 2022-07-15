package page.objects.admin;

import commons.AdminBasePage;
import org.openqa.selenium.WebDriver;
import page.interfaces.admin.AdminCommonUI;
import page.interfaces.admin.CustomerEditPageUI;
import page.objects.AdminPageGeneratorManager;

public class CustomerEditPage extends AdminBasePage {
    WebDriver driver;

    public CustomerEditPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToAddressesCardTitle(WebDriver driver, String card, String cardTitle) {
        if (!isElementDisplayed(driver, CustomerEditPageUI.ADD_NEW_ADDRESS_BUTTON)) {
            clickToCardTitle(driver, card, cardTitle);
        }
        scrollToElement(driver, CustomerEditPageUI.ADD_NEW_ADDRESS_BUTTON);
    }

    public CustomerAddressCreatePage clickToAddNewAddressButton(WebDriver driver) {
        waitForElementClickable(driver, CustomerEditPageUI.ADD_NEW_ADDRESS_BUTTON);
        clickToElement(driver, CustomerEditPageUI.ADD_NEW_ADDRESS_BUTTON);
        return AdminPageGeneratorManager.getAdminPageGeneratorManager().getCustomerAddressCreatePage(driver);
    }
}
