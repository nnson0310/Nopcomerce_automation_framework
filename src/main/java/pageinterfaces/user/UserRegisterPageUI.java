package pageinterfaces.user;

public abstract class UserRegisterPageUI {
    public static final String REGISTER_BUTTON = "css=button#register-button";
    public static final String DYNAMIC_VALIDATE_ERROR_MSG = "xpath=//label[@for='%s']//following-sibling::span[@class='field-validation-error']/span[text()='%s']";
    public static final String DYNAMIC_TEXTBOX = "xpath=//div[@class='page-body']//input[@name='%s']";
    public static final String DYNAMIC_SUMMARY_ERROR = "xpath=//div[contains(@class, 'validation-summary-errors')]//li[text()='%s']";
    public static final String GENDER_RADIO_BUTTON = "xpath=//input[@name='Gender' and @id='%s']";
    public static final String DYNAMIC_BIRTHDAY_SELECT = "xpath=//div[@class='date-picker-wrapper']//select[@name='%s']";
}
