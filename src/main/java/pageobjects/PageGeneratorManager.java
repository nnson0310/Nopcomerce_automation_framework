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
}
