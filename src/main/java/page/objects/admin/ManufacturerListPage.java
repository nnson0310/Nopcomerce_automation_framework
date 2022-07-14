package page.objects.admin;

import commons.AdminBasePage;
import org.openqa.selenium.WebDriver;
import page.interfaces.admin.ManufacturerListPageUI;
import page.objects.AdminPageGeneratorManager;

public class ManufacturerListPage extends AdminBasePage {

    WebDriver driver;

    public ManufacturerListPage(WebDriver driver) {
        this.driver = driver;
    }

    public CreateManufacturerPage clickToAddNewButton(WebDriver driver) {
        waitForElementClickable(driver, ManufacturerListPageUI.ADD_NEW_BUTTON);
        clickToElement(driver, ManufacturerListPageUI.ADD_NEW_BUTTON);
        return AdminPageGeneratorManager.getAdminPageGeneratorManager().getCreateManufacturerPage(driver);
    }
}
