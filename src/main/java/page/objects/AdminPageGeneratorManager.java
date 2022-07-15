package page.objects;

import org.openqa.selenium.WebDriver;
import page.objects.admin.*;

public class AdminPageGeneratorManager {

    private static AdminPageGeneratorManager adminPageGeneratorManager;

    private AdminPageGeneratorManager() {

    }

    public synchronized static AdminPageGeneratorManager getAdminPageGeneratorManager() {
        if (adminPageGeneratorManager == null) {
            return new AdminPageGeneratorManager();
        }
        return adminPageGeneratorManager;
    }

    public LoginPage getLoginPage(WebDriver driver) {
        return new LoginPage(driver);
    }

    public AdminDashboardPage getAdminDashboardPage(WebDriver driver) {
        return new AdminDashboardPage(driver);
    }

    public ProductListPage getProductListPage(WebDriver driver) {
        return new ProductListPage(driver);
    }

    public ProductEditPage getProductEditPage(WebDriver driver) {
        return new ProductEditPage(driver);
    }

    public ManufacturerListPage getManufacturerListPage(WebDriver driver) {
        return new ManufacturerListPage(driver);
    }

    public ManufacturerCreatePage getManufacturerCreatePage(WebDriver driver) {
        return new ManufacturerCreatePage(driver);
    }

    public CustomerListPage getCustomerListPage(WebDriver driver) {
        return new CustomerListPage(driver);
    }

    public CustomerEditPage getCustomerEditPage(WebDriver driver) {
        return new CustomerEditPage(driver);
    }

    public CustomerAddressCreatePage getCustomerAddressCreatePage(WebDriver driver) {
        return new CustomerAddressCreatePage(driver);
    }

    public CustomerCreatePage getCustomerCreatePage(WebDriver driver) {
        return new CustomerCreatePage(driver);
    }
}
