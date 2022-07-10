package pageinterfaces.user;

public abstract class UserLoginPageUI {

    public static final String EMAIL_FIELD = "css=input#Email";
    public static final String PASSWORD_FIELD = "css=input#Password";
    public static final String LOGIN_BUTTON = "xpath=//button[text()='Log in']";
    public static final String DYNAMIC_EMAIL_ERROR = "xpath=//span[@id='Email-error' and text()='%s']";
    public static final String CHECKOUT_AS_GUEST_BUTTON = "css=button.checkout-as-guest-button";
}
