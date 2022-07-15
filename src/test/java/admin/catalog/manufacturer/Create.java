package admin.catalog.manufacturer;

import admin.PreCondition_Login;
import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import page.objects.AdminPageGeneratorManager;
import page.objects.admin.ManufacturerCreatePage;
import page.objects.admin.LoginPage;
import page.objects.admin.ManufacturerListPage;
import utilities.DataFaker;
import utilities.FunctionHelper;

import java.lang.reflect.Method;

import static report.config.ExtentTestManager.getTest;
import static report.config.ExtentTestManager.startTest;

public class Create extends BaseTest {
    WebDriver driver;

    LoginPage loginPage;
    ManufacturerListPage manufacturerListPage;
    ManufacturerCreatePage manufacturerCreatePage;

    String manufacturerNameTextboxName, descriptionIframeName;
    String manufacturerName, description, picture;
    String saveButtonFieldName, tableId;

    @Parameters({"adminSiteDashboardUrl", "browserName", "browserVersion", "environmentName", "ipAddress", "port", "platform"})
    @BeforeClass
    public void setUp(
            String dashboardUrl,
            @Optional("firefox") String browserName,
            @Optional("latest") String browserVersion,
            @Optional("local") String environmentName,
            @Optional("localhost") String ipAddress,
            @Optional("4444") String port,
            @Optional("Windows 10") String platform
    ) {
        driver = getBrowserDriver(dashboardUrl, browserName, browserVersion, environmentName, ipAddress, port, platform);
        loginPage = AdminPageGeneratorManager.getAdminPageGeneratorManager().getLoginPage(driver);
        loginPage.setCookies(driver, PreCondition_Login.adminLoginCookies);

        log.info("Pre Condition - Step 01: Navigate to manufacturer list page");
        manufacturerListPage = loginPage.redirectToManufacturerListPage(driver, "https://admin-demo.nopcommerce.com/Admin/Manufacturer/List");
        FunctionHelper.sleepInSeconds(1);

        log.info("Pre Condition - Step 02: Click to 'Add New' button");
        manufacturerListPage.clickToAddNewButton(driver);
        manufacturerCreatePage = AdminPageGeneratorManager.getAdminPageGeneratorManager().getManufacturerCreatePage(driver);
        FunctionHelper.sleepInSeconds(1);

        //field name
        manufacturerNameTextboxName = "Name";
        descriptionIframeName = "Description";
        saveButtonFieldName = "save";
        tableId = "manufacturers-grid";

        //test data
        manufacturerName = "Samsung" + DataFaker.generateRandomNumber();
        description = "Samsung is one of biggest phone manufacturing company";
        picture = "manufacturer-picture.jpg";
    }


    @Test(description = "Verify that user can add new manufacturer in advanced mode")
    public void TC_01_Create_With_Advanced_Mod (Method method) {
        startTest(method.getName(), "TC_01_Create_With_Advanced_Mod - Start test");
        getTest().log(Status.INFO, "TC_01_Create_With_Advanced_Mod - Step 01: Click to Mod Switch Button to switch to advanced mode");
        manufacturerCreatePage.clickToModSwitchButton(driver);
        FunctionHelper.sleepInSeconds(2);

        getTest().log(Status.INFO, "TC_01_Create_With_Advanced_Mod - Step 02: Enter manufacturer name = " + manufacturerName);
        manufacturerCreatePage.inputToDynamicTextboxByNameAttribute(driver, manufacturerName, manufacturerNameTextboxName);

        getTest().log(Status.INFO, "TC_01_Create_With_Advanced_Mod - Step 03: Enter description = " + description);
        manufacturerCreatePage.inputToDescriptionIframe(driver, description, descriptionIframeName);

        getTest().log(Status.INFO, "TC_01_Create_With_Advanced_Mod - Step 04: Upload manufacturer picture");
        manufacturerCreatePage.uploadManufacturerPicture(driver, picture);
        FunctionHelper.sleepInSeconds(2);

        getTest().log(Status.INFO, "TC_01_Create_With_Advanced_Mod - Step 05: Verify that pictured upload successfully");
        Assert.assertTrue(manufacturerCreatePage.isUploadPictureDisplayed(driver, picture));

        getTest().log(Status.INFO, "TC_01_Create_With_Advanced_Mod - Step 06: Click save button");
        manufacturerCreatePage.clickToDynamicButtonByName(driver, saveButtonFieldName);
        manufacturerListPage = AdminPageGeneratorManager.getAdminPageGeneratorManager().getManufacturerListPage(driver);

        getTest().log(Status.INFO, "TC_01_Create_With_Advanced_Mod - Step 07: Verify that alert message '\n" +
                "The new manufacturer has been added successfully.\n' is displayed");
        Assert.assertTrue(manufacturerListPage.isSuccessAlertDisplayed(driver, "The new manufacturer has been added successfully."));

        getTest().log(Status.INFO, "TC_01_Create_With_Advanced_Mod - Step 08: Verify that new manufacturer has been added to table");
        Assert.assertTrue(manufacturerListPage.isNewItemDisplayedInTable(driver, tableId, manufacturerName));

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        closeBrowserAndKillProcess();
    }
}
