package pageobjects;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

    private static PageGeneratorManager pageGeneratorManager;

    private PageGeneratorManager() {

    }

    public synchronized static PageGeneratorManager getPageGeneratorManager() {
        if (pageGeneratorManager == null) {
            return new PageGeneratorManager();
        }
        return pageGeneratorManager;
    }

    public UserHomePage getUserHomePage(WebDriver driver) {
        return new UserHomePage(driver);
    }

    public UserLoginPage getLoginHomePage(WebDriver driver) {
        return new UserLoginPage(driver);
    }

    public UserRegisterPage getUserRegisterPage(WebDriver driver) {
        return new UserRegisterPage(driver);
    }

    public UserRegisterResultPage getUserRegisterResultPage(WebDriver driver) {
        return new UserRegisterResultPage(driver);
    }
}
