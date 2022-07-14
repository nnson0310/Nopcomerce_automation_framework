package admin;

import commons.BaseTest;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import page.objects.AdminPageGeneratorManager;
import page.objects.admin.AdminDashboardPage;
import page.objects.admin.LoginPage;

import java.util.HashSet;
import java.util.Set;

public class PreCondition_Login extends BaseTest {
    WebDriver driver;

    LoginPage loginPage;
    AdminDashboardPage adminDashboardPage;

    public static Set<Cookie> adminLoginCookies;

    @Parameters({"adminSiteLoginUrl", "browserName", "browserVersion", "environmentName", "ipAddress", "port", "platform"})
    @BeforeTest
    public void setUp(
            String loginUrl,
            @Optional("firefox") String browserName,
            @Optional("latest") String browserVersion,
            @Optional("local") String environmentName,
            @Optional("localhost") String ipAddress,
            @Optional("4444") String port,
            @Optional("Windows 10") String platform
    ) {
        driver = getBrowserDriver(loginUrl, browserName, browserVersion, environmentName, ipAddress, port, platform);
        loginPage = AdminPageGeneratorManager.getAdminPageGeneratorManager().getLoginPage(driver);

        log.info("Pre Condition - Login - Step 01: Click to login button");
        adminDashboardPage = loginPage.clickToLoginButton(driver);

        log.info("Pre Condition - Login - Step 02: Verify that user can access admin dashboard and dashboard header is displayed");
        Assert.assertTrue(adminDashboardPage.isContentHeaderDisplayed(driver, "Dashboard"));

        adminLoginCookies = adminDashboardPage.getAllCookies(driver);

        closeBrowserAndKillProcess();
    }
}
