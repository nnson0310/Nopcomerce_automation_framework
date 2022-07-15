package page.objects.admin;

import commons.AdminBasePage;
import org.openqa.selenium.WebDriver;
import page.interfaces.admin.AdminLoginPageUI;
import page.objects.AdminPageGeneratorManager;

public class LoginPage extends AdminBasePage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public AdminDashboardPage clickToLoginButton(WebDriver driver) {
        waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
        return AdminPageGeneratorManager.getAdminPageGeneratorManager().getAdminDashboardPage(driver);
    }

    public ProductListPage redirectToProductListPage(WebDriver driver, String url) {
        redirectToPage(driver, url);
        return AdminPageGeneratorManager.getAdminPageGeneratorManager().getProductListPage(driver);
    }

    public ManufacturerListPage redirectToManufacturerListPage(WebDriver driver, String url) {
        redirectToPage(driver, url);
        return AdminPageGeneratorManager.getAdminPageGeneratorManager().getManufacturerListPage(driver);
    }

    public CustomerListPage redirectToCustomersListPage(WebDriver driver, String url) {
        redirectToPage(driver, url);
        return AdminPageGeneratorManager.getAdminPageGeneratorManager().getCustomerListPage(driver);
    }
}
