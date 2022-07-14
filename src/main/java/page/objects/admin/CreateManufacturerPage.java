package page.objects.admin;

import commons.AdminBasePage;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.interfaces.admin.CreateManufacturerPageUI;

public class CreateManufacturerPage extends AdminBasePage {
    WebDriver driver;

    WebDriverWait explicitWait;

    public CreateManufacturerPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToDescriptionIframe(WebDriver driver, String description, String fieldName) {
       senKeyToIframe(driver, description, CreateManufacturerPageUI.DESCRIPTION_TEXTBOX_IFRAME, fieldName);
    }

    public void uploadManufacturerPicture(WebDriver driver, String fileName) {
        waitForElementClickable(driver, CreateManufacturerPageUI.PICTURE_UPLOAD_BUTTON);
        clickToElement(driver, CreateManufacturerPageUI.PICTURE_UPLOAD_BUTTON);

        sendKeyToElement(driver, CreateManufacturerPageUI.PICTURE_UPLOAD_INPUT, GlobalConstants.getGlobalConstants().getUploadFilePath() + fileName);
    }
}
