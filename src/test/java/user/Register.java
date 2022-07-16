package user;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import data.provider.UserRegister;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import page.objects.UserPageGeneratorManager;
import page.objects.user.UserHomePage;
import page.objects.user.UserRegisterPage;
import page.objects.user.UserRegisterResultPage;

import java.lang.reflect.Method;
import java.util.HashMap;

import static report.config.ExtentTestManager.startTest;
import static report.config.ExtentTestManager.getTest;

public class Register extends BaseTest {
    WebDriver driver;

    UserHomePage userHomePage;
    UserRegisterPage userRegisterPage;
    UserRegisterResultPage userRegisterResultPage;

    String emailFieldName, firstNameFieldName, lastNameFieldName, passwordFieldName, confirmPasswordFieldName;
    String birthDateFieldName, birthMonthFieldName, birthYearFieldName, companyFieldName;

    @Parameters({"userSiteUrl", "browserName", "browserVersion", "environmentName", "ipAddress", "port", "os", "osVersion"})
    @BeforeClass
    public void setUp(
            String userSiteUrl,
            @Optional("firefox") String browserName,
            @Optional("latest") String browserVersion,
            @Optional("local") String environmentName,
            @Optional("localhost") String ipAddress,
            @Optional("4444") String port,
            @Optional("Windows") String os,
            @Optional("10") String osVersion
    ) {
        driver = getBrowserDriver(userSiteUrl, browserName, browserVersion, environmentName, ipAddress, port, os, osVersion);
        userHomePage = UserPageGeneratorManager.getUserPageGeneratorManager().getUserHomePage(driver);
        userRegisterPage = userHomePage.clickToRegisterLink(driver);

        emailFieldName = "Email";
        firstNameFieldName = "FirstName";
        lastNameFieldName = "LastName";
        passwordFieldName = "Password";
        confirmPasswordFieldName = "ConfirmPassword";
        birthDateFieldName = "DateOfBirthDay";
        birthMonthFieldName = "DateOfBirthMonth";
        birthYearFieldName = "DateOfBirthYear";
        companyFieldName = "Company";
    }

    @Test(description = "TC_01_Empty_Data - Verify that error message will be displayed at required fields")
    public void TC_01_Empty_Data(Method method) {

        startTest(method.getName(), "TC_01_Empty_Data - Start Test");
        getTest().log(Status.INFO, "TC_01_Empty_Data - Step 01: Click to register button");
        userRegisterPage.clickToRegisterButton(driver);

        getTest().log(Status.INFO, "TC_01_Empty_Data - Step 02: Verify that 'First name is required.' is displayed");
        Assert.assertTrue(userRegisterPage.isErrorValidationMsgDisplayed(driver, firstNameFieldName, "First name is required."));

        getTest().log(Status.INFO, "TC_01_Empty_Data - Step 03: Verify that 'Last name is required.' is displayed");
        Assert.assertTrue(userRegisterPage.isErrorValidationMsgDisplayed(driver, lastNameFieldName, "Last name is required."));

        getTest().log(Status.INFO, "TC_01_Empty_Data - Step 04: Verify that 'Email is required.' is displayed");
        Assert.assertTrue(userRegisterPage.isErrorValidationMsgDisplayed(driver, emailFieldName, "Email is required."));

        getTest().log(Status.INFO, "TC_01_Empty_Data - Step 05: Verify that 'Password is required.' is displayed");
        Assert.assertTrue(userRegisterPage.isErrorValidationMsgDisplayed(driver, passwordFieldName, "Password is required."));

        getTest().log(Status.INFO, "TC_01_Empty_Data - Step 06: Verify that 'Confirm Password is required.' is displayed");
        Assert.assertTrue(userRegisterPage.isErrorValidationMsgDisplayed(driver, confirmPasswordFieldName, "Password is required."));

    }

    @Test(
            description = "TC_02_Invalid_Email - Verify that error message will be displayed when entering invalid email",
            dataProvider = "user-register",
            dataProviderClass = UserRegister.class
    )
    public void TC_02_Invalid_Email(String invalidEmail, HashMap<String, String> credentials, Method method) {

        startTest(method.getName(), "TC_02_Invalid_Email - Start Test");
        getTest().log(Status.INFO, "TC_02_Invalid_Email - Step 01: Enter invalid email = " + invalidEmail);
        userRegisterPage.inputToDynamicTextbox(driver, invalidEmail, emailFieldName);

        getTest().log(Status.INFO, "TC_02_Invalid_Email - Step 03: Enter first name = " + credentials.get("firstName"));
        userRegisterPage.inputToDynamicTextbox(driver, credentials.get("firstName"), firstNameFieldName);

        getTest().log(Status.INFO, "TC_02_Invalid_Email - Step 04: Enter last name = " + credentials.get("lastName"));
        userRegisterPage.inputToDynamicTextbox(driver, credentials.get("lastName"), lastNameFieldName);

        getTest().log(Status.INFO, "TC_02_Invalid_Email - Step 05: Enter password = " + credentials.get("password"));
        userRegisterPage.inputToDynamicTextbox(driver, credentials.get("password"), passwordFieldName);

        getTest().log(Status.INFO, "TC_02_Invalid_Email - Step 06: Enter confirm password = " + credentials.get("password"));
        userRegisterPage.inputToDynamicTextbox(driver, credentials.get("password"), confirmPasswordFieldName);

        getTest().log(Status.INFO, "TC_02_Invalid_Email - Step 07: Click register button");
        userRegisterPage.clickToRegisterButton(driver);

        getTest().log(Status.INFO, "TC_02_Invalid_Email - Step 08: Validate that 'Wrong email' will be displayed");
        Assert.assertTrue(userRegisterPage.isValidationSummaryErrorsDisplayed(driver, "Wrong email"));

    }

    @Test(
            description = "TC_03_Registered_Email - Verify that user can not register with existed email",
            dataProvider = "user-register",
            dataProviderClass = UserRegister.class
    )
    public void TC_03_Registered_Email(HashMap<String, String> credentials, Method method) {
        startTest(method.getName(), "TC_03_Registered_Email - Start Test");
        getTest().log(Status.INFO, "TC_03_Registered_Email - Step 01: Choose gender = " + credentials.get("gender"));
        userRegisterPage.clickToGenderRadioButton(driver, credentials.get("gender"));

        getTest().log(Status.INFO, "TC_03_Registered_Email - Step 01: Enter first name = " + credentials.get("firstName"));
        userRegisterPage.inputToDynamicTextbox(driver, credentials.get("firstName"), firstNameFieldName);

        getTest().log(Status.INFO, "TC_03_Registered_Email - Step 02: Enter last name = " + credentials.get("lastName"));
        userRegisterPage.inputToDynamicTextbox(driver, credentials.get("lastName"), lastNameFieldName);

        getTest().log(Status.INFO, "TC_03_Registered_Email - Step 03: Select birth date = " + credentials.get("birthDate"));
        userRegisterPage.clickToDynamicSelect(driver, credentials.get("birthDate"), birthDateFieldName);

        getTest().log(Status.INFO, "TC_03_Registered_Email - Step 04: Select birth month = " + credentials.get("birthMonth"));
        userRegisterPage.clickToDynamicSelect(driver, credentials.get("birthMonth"), birthMonthFieldName);

        getTest().log(Status.INFO, "TC_03_Registered_Email - Step 05: Select birth year = " + credentials.get("birthYear"));
        userRegisterPage.clickToDynamicSelect(driver, credentials.get("birthYear"), birthYearFieldName);

        getTest().log(Status.INFO, "TC_03_Registered_Email - Step 06: Input company name = " + credentials.get("companyName"));
        userRegisterPage.inputToDynamicTextbox(driver, credentials.get("companyName"), companyFieldName);

        getTest().log(Status.INFO, "TC_03_Registered_Email - Step 07: Enter email = " + credentials.get("registeredEmail"));
        userRegisterPage.inputToDynamicTextbox(driver, credentials.get("registeredEmail"), emailFieldName);

        getTest().log(Status.INFO, "TC_03_Registered_Email - Step 07: Enter password = " + credentials.get("password"));
        userRegisterPage.inputToDynamicTextbox(driver, credentials.get("password"), passwordFieldName);

        getTest().log(Status.INFO, "TC_03_Registered_Email - Step 08: Enter confirm password = " + credentials.get("password"));
        userRegisterPage.inputToDynamicTextbox(driver, credentials.get("password"), confirmPasswordFieldName);

        getTest().log(Status.INFO, "TC_03_Registered_Email - Step 09: Click to register button");
        userRegisterPage.clickToRegisterButton(driver);

        getTest().log(Status.INFO, "TC_03_Registered_Email - Step 10: Verify that 'The specified email already exists' is displayed");
        userRegisterPage.isValidationSummaryErrorsDisplayed(driver, "The specified email already exists");

    }

    @Test(
            description = "TC_04_Valid_Info - Verify that user can register with valid info",
            dataProvider = "user-register",
            dataProviderClass = UserRegister.class
    )
    public void TC_04_Valid_Info(HashMap<String, String> credentials, Method method) {

        startTest(method.getName(), "TC_04_Valid_Info - Start Test");
        getTest().log(Status.INFO, "TC_04_Valid_Info - Step 01: Choose gender = " + credentials.get("gender"));
        userRegisterPage.clickToGenderRadioButton(driver, credentials.get("gender"));

        getTest().log(Status.INFO, "TC_04_Valid_Info - Step 01: Enter first name = " + credentials.get("firstName"));
        userRegisterPage.inputToDynamicTextbox(driver, credentials.get("firstName"), firstNameFieldName);

        getTest().log(Status.INFO, "TC_04_Valid_Info - Step 02: Enter last name = " + credentials.get("lastName"));
        userRegisterPage.inputToDynamicTextbox(driver, credentials.get("lastName"), lastNameFieldName);

        getTest().log(Status.INFO, "TC_04_Valid_Info - Step 03: Select birth date = " + credentials.get("birthDate"));
        userRegisterPage.clickToDynamicSelect(driver, credentials.get("birthDate"), birthDateFieldName);

        getTest().log(Status.INFO, "TC_04_Valid_Info - Step 04: Select birth month = " + credentials.get("birthMonth"));
        userRegisterPage.clickToDynamicSelect(driver, credentials.get("birthMonth"), birthMonthFieldName);

        getTest().log(Status.INFO, "TC_04_Valid_Info - Step 05: Select birth year = " + credentials.get("birthYear"));
        userRegisterPage.clickToDynamicSelect(driver, credentials.get("birthYear"), birthYearFieldName);

        getTest().log(Status.INFO, "TC_04_Valid_Info - Step 06: Input company name = " + credentials.get("companyName"));
        userRegisterPage.inputToDynamicTextbox(driver, credentials.get("companyName"), companyFieldName);

        getTest().log(Status.INFO, "TC_04_Valid_Info - Step 07: Enter email = " + credentials.get("email"));
        userRegisterPage.inputToDynamicTextbox(driver, credentials.get("email"), emailFieldName);

        getTest().log(Status.INFO, "TC_04_Valid_Info - Step 07: Enter password = " + credentials.get("password"));
        userRegisterPage.inputToDynamicTextbox(driver, credentials.get("password"), passwordFieldName);

        getTest().log(Status.INFO, "TC_04_Valid_Info - Step 08: Enter confirm password = " + credentials.get("password"));
        userRegisterPage.inputToDynamicTextbox(driver, credentials.get("password"), confirmPasswordFieldName);

        getTest().log(Status.INFO, "TC_04_Valid_Info - Step 09: Click to register button");
        userRegisterPage.clickToRegisterButton(driver);
        userRegisterResultPage = UserPageGeneratorManager.getUserPageGeneratorManager().getUserRegisterResultPage(driver);

        getTest().log(Status.INFO, "TC_04_Valid_Info - Step 10: Verify that user can register successfully");
        Assert.assertTrue(userRegisterResultPage.isRegisterSuccessMessageDisplayed(driver, "Your registration completed"));

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        closeBrowserAndKillProcess();
    }
}
