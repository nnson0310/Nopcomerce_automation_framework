package page.interfaces.admin;

public abstract class CreateManufacturerPageUI {
    public static final String DESCRIPTION_TEXTBOX_IFRAME = "xpath=//iframe[@id='Description_ifr']";
    public static final String PICTURE_UPLOAD_BUTTON = "css=div.qq-upload-button-selector";
    public static final String PICTURE_UPLOAD_INPUT = "css=div.qq-upload-button-selector input";
    public static final String PICTURE_UPLOAD_LABEL_SPAN = "xpath=//span[contains(@class, 'qq-upload-file') and text()='%s']";
    public static final String MOD_SWITCH_BUTTON = "css=span.onoffswitch-switch";
    public static final String PICTURE_UPLOAD_FORM_DIV = "xpath=//div[contains(@class, 'advanced-setting')]//label[text()='Picture']";
    public static final String PICTURE_UPLOAD_IMG = "css=div.uploaded-image img";
}
