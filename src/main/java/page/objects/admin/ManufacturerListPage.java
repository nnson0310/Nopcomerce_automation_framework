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
}
