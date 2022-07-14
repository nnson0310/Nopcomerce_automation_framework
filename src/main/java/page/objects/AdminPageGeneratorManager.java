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

    public EditProductPage getEditProductPage(WebDriver driver) {
        return new EditProductPage(driver);
    }

    public ManufacturerListPage getManufacturerListPage(WebDriver driver) {
        return new ManufacturerListPage(driver);
    }

    public CreateManufacturerPage getCreateManufacturerPage(WebDriver driver) {
        return new CreateManufacturerPage(driver);
    }
}
