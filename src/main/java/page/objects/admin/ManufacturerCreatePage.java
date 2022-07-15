package page.objects.admin;

import commons.AdminBasePage;
import commons.GlobalConstants;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.interfaces.admin.ManufacturerCreatePageUI;

public class ManufacturerCreatePage extends AdminBasePage {
    WebDriver driver;

    WebDriverWait explicitWait;
    JavascriptExecutor jsExecutor;

    public ManufacturerCreatePage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToDescriptionIframe(WebDriver driver, String description, String fieldName) {
       senKeyToIframe(driver, description, ManufacturerCreatePageUI.DESCRIPTION_TEXTBOX_IFRAME, fieldName);
    }

    public void uploadManufacturerPicture(WebDriver driver, String fileName) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('style', 'font-size: 10px !important')", getElement(driver, ManufacturerCreatePageUI.PICTURE_UPLOAD_INPUT));
        sendKeyToElement(driver, ManufacturerCreatePageUI.PICTURE_UPLOAD_INPUT, GlobalConstants.getGlobalConstants().getUploadFilePath() + fileName);
    }

    public boolean isUploadPictureDisplayed(WebDriver driver, String pictureName) {
        waitForElementVisible(driver, ManufacturerCreatePageUI.PICTURE_UPLOAD_LABEL_SPAN, pictureName);
        waitForElementVisible(driver, ManufacturerCreatePageUI.PICTURE_UPLOAD_IMG);
        return isElementDisplayed(driver, ManufacturerCreatePageUI.PICTURE_UPLOAD_LABEL_SPAN, pictureName)
                && isElementDisplayed(driver, ManufacturerCreatePageUI.PICTURE_UPLOAD_IMG);
    }

    public void clickToModSwitchButton(WebDriver driver) {
        if (!isElementDisplayed(driver, ManufacturerCreatePageUI.PICTURE_UPLOAD_FORM_DIV)) {
            waitForElementClickable(driver, ManufacturerCreatePageUI.MOD_SWITCH_BUTTON);
            clickToElement(driver, ManufacturerCreatePageUI.MOD_SWITCH_BUTTON);
        }
    }
}
