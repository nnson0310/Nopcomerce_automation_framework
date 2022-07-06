package user;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import dataprovider.UserLogin;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobjects.PageGeneratorManager;
import pageobjects.user.UserHomePage;
import pageobjects.user.UserLoginPage;
import java.lang.reflect.Method;

import static reportconfig.ExtentTestManager.getTest;
import static reportconfig.ExtentTestManager.startTest;

public class Login extends BaseTest {
    WebDriver driver;

    UserHomePage userHomePage;
    UserLoginPage userLoginPage;

    @Parameters({"userSiteUrl", "browserName", "browserVersion", "environmentName", "ipAddress", "port", "platform"})
    @BeforeTest
    public void setUp(
            String userSiteUrl,
            @Optional("firefox") String browserName,
            @Optional("latest") String browserVersion,
            @Optional("local") String environmentName,
            @Optional("localhost") String ipAddress,
            @Optional("4444") String port,
            @Optional("Windows 10") String platform
    ) {
        driver = getBrowserDriver(userSiteUrl, browserName, browserVersion, environmentName, ipAddress, port, platform);
        userHomePage = PageGeneratorManager.getPageGeneratorManager().getUserHomePage(driver);
        userLoginPage = userHomePage.clickToLoginLink(driver);
    }

    @Test(description = "TC_01_Empty_Email - Verify that user can not login with empty email")
    public void TC_01_Empty_Email(Method method) {
        startTest(method.getName(), "TC_01_Empty_Email - Start Test");
        getTest().log(Status.INFO, "TC_01_Empty_Email - Step 01: Do not enter any value into email field");
        userLoginPage.inputToEmailField(driver, "");

        getTest().log(Status.INFO, "TC_01_Empty_Email - Step 02: Click to login button");
        userLoginPage.clickToLoginButton(driver);

        getTest().log(Status.INFO, "TC_01_Empty_Email - Step 03: Verify that 'Please enter your email' is displayed");
        userLoginPage.isDynamicEmailErrorDisplayed(driver, "Please enter your email");
    }

    @Test(
            description = "TC_02_Invalid_Email - Verify that user can not login with invalid email",
            dataProvider = "user-login",
            dataProviderClass = UserLogin.class
    )
    public void TC_02_Invalid_Email(String invalidEmail, Method method) {
        startTest(method.getName(), "TC_02_Invalid_Email - Start Test");
        getTest().log(Status.INFO, "TC_02_Invalid_Email - Step 01: Enter invalid email = " + invalidEmail);
        userLoginPage.inputToEmailField(driver, invalidEmail);

        getTest().log(Status.INFO, "TC_02_Invalid_Email - Step 02: Click to login button");
        userLoginPage.clickToLoginButton(driver);

        getTest().log(Status.INFO, "TC_02_Invalid_Email - Step 03: Verify that 'Wrong email' is displayed");
        userLoginPage.isDynamicEmailErrorDisplayed(driver, "Wrong email");
    }

    @Test(
            description = "TC_03_Valid_Credentials - Verify that user can login with valid credentials (email + password)",
            dataProvider = "user-login",
            dataProviderClass = UserLogin.class
    )
    public void TC_03_Valid_Credentials(String email, String password, Method method) {
        startTest(method.getName(), "TC_03_Valid_Credentials - Start Test");
        getTest().log(Status.INFO, "TC_03_Valid_Credentials - Step 01: Enter valid email = " + email);
        userLoginPage.inputToEmailField(driver, email);

        getTest().log(Status.INFO, "TC_03_Valid_Credentials - Step 02: Enter valid password = " + password);
        userLoginPage.inputToPasswordField(driver, password);

        getTest().log(Status.INFO, "TC_03_Valid_Credentials - Step 03: Click to login button");
        userLoginPage.clickToLoginButton(driver);
        userHomePage = PageGeneratorManager.getPageGeneratorManager().getUserHomePage(driver);

        getTest().log(Status.INFO, "TC_03_Valid_Credentials - Step 04: Verify that user can login successfully and be navigated to user's homepage");
        Assert.assertTrue(userHomePage.isMyAccountHeaderLinkDisplayed(driver));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        closeBrowserAndKillProcess();
    }
}
