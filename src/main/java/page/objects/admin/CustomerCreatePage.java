package page.objects.admin;

import commons.AdminBasePage;
import org.openqa.selenium.WebDriver;
import page.interfaces.admin.CustomerCreatePageUI;

public class CustomerCreatePage extends AdminBasePage {
    WebDriver driver;

    public CustomerCreatePage(WebDriver driver) {
        this.driver = driver;
    }
}
