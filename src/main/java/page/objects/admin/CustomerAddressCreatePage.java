package page.objects.admin;

import commons.AdminBasePage;
import org.openqa.selenium.WebDriver;
import page.interfaces.admin.CustomerAddressCreatePageUI;

public class CustomerAddressCreatePage extends AdminBasePage {
    WebDriver driver;

    public CustomerAddressCreatePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToSaveButton(WebDriver driver) {
        waitForElementVisible(driver, CustomerAddressCreatePageUI.SAVE_BUTTON);
        clickToElement(driver, CustomerAddressCreatePageUI.SAVE_BUTTON);
    }
}
