package page.objects.admin;

import commons.AdminBasePage;
import commons.GlobalConstants;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.interfaces.admin.CreateManufacturerPageUI;

public class CreateManufacturerPage extends AdminBasePage {
    WebDriver driver;

    WebDriverWait explicitWait;
    JavascriptExecutor jsExecutor;

    public CreateManufacturerPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToDescriptionIframe(WebDriver driver, String description, String fieldName) {
       senKeyToIframe(driver, description, CreateManufacturerPageUI.DESCRIPTION_TEXTBOX_IFRAME, fieldName);
    }

    public void uploadManufacturerPicture(WebDriver driver, String fileName) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('style', 'font-size: 10px !important')", getElement(driver, CreateManufacturerPageUI.PICTURE_UPLOAD_INPUT));
        sendKeyToElement(driver, CreateManufacturerPageUI.PICTURE_UPLOAD_INPUT, GlobalConstants.getGlobalConstants().getUploadFilePath() + fileName);
    }

    public boolean isUploadPictureDisplayed(WebDriver driver, String pictureName) {
        waitForElementVisible(driver, CreateManufacturerPageUI.PICTURE_UPLOAD_LABEL_SPAN, pictureName);
        waitForElementVisible(driver, CreateManufacturerPageUI.PICTURE_UPLOAD_IMG);
        return isElementDisplayed(driver, CreateManufacturerPageUI.PICTURE_UPLOAD_LABEL_SPAN, pictureName)
                && isElementDisplayed(driver, CreateManufacturerPageUI.PICTURE_UPLOAD_IMG);
    }

    public void clickToModSwitchButton(WebDriver driver) {
        if (!isElementDisplayed(driver, CreateManufacturerPageUI.PICTURE_UPLOAD_FORM_DIV)) {
            waitForElementClickable(driver, CreateManufacturerPageUI.MOD_SWITCH_BUTTON);
            clickToElement(driver, CreateManufacturerPageUI.MOD_SWITCH_BUTTON);
        }
    }
}
