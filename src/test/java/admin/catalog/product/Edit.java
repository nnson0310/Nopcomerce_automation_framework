package admin.catalog.product;

import admin.PreCondition_Login;
import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import page.objects.AdminPageGeneratorManager;
import page.objects.admin.ProductEditPage;
import page.objects.admin.LoginPage;
import page.objects.admin.ProductListPage;
import utilities.FunctionHelper;

import java.lang.reflect.Method;

import static report.config.ExtentTestManager.getTest;
import static report.config.ExtentTestManager.startTest;

public class Edit extends BaseTest {
    WebDriver driver;

    LoginPage loginPage;
    ProductListPage productListPage;
    ProductEditPage editProductPage;

    String productSku, availableStartDate, availableEndDate;
    String skuFieldName, goToSkuButtonFieldName, categoryMultiSelectFieldName, categoryMultiSelectItemFieldName;
    String availableStartDateFieldName, availableEndDateFieldName;
    String saveButtonFieldName;
    String updateCategoryName;

    @Parameters({"adminSiteDashboardUrl", "browserName", "browserVersion", "environmentName", "ipAddress", "port", "os", "osVersion"})
    @BeforeClass
    public void setUp(
            String dashboardUrl,
            @Optional("firefox") String browserName,
            @Optional("latest") String browserVersion,
            @Optional("local") String environmentName,
            @Optional("localhost") String ipAddress,
            @Optional("4444") String port,
            @Optional("Windows") String os,
            @Optional("10") String osVersion
    ) {
        driver = getBrowserDriver(dashboardUrl, browserName, browserVersion, environmentName, ipAddress, port, os, osVersion);
        loginPage = AdminPageGeneratorManager.getAdminPageGeneratorManager().getLoginPage(driver);
        loginPage.setCookies(driver, PreCondition_Login.adminLoginCookies);

        log.info("Pre Condition - Navigate to product list page");
        productListPage = loginPage.redirectToProductListPage(driver, "https://admin-demo.nopcommerce.com/Admin/Product/List");
        FunctionHelper.sleepInSeconds(2);

        //field name
        skuFieldName = "GoDirectlyToSku";
        goToSkuButtonFieldName = "go-to-product-by-sku";
        categoryMultiSelectFieldName = "SelectedCategoryIds_taglist";
        categoryMultiSelectItemFieldName = "SelectedCategoryIds_listbox";
        availableStartDateFieldName = "AvailableStartDateTimeUtc";
        availableEndDateFieldName = "AvailableEndDateTimeUtc";
        saveButtonFieldName = "save";

        //test data
        productSku = "LE_IC_600";
        updateCategoryName = "Computers >> Desktops";
        availableStartDate = "7/7/2035 12:00:00 AM";
        availableEndDate = "7/7/2050 12:00:00 AM";
    }


    @Test(description = "Verify that user can update product details: category, tag and available date")
    public void TC_01_Update_Category_And_Available_Date (Method method) {
        startTest(method.getName(), "TC_01_Update_Category_And_Tag_And_Available_Date - Start test");
        getTest().log(Status.INFO, "TC_01_Update_Category_And_Tag_And_Available_Date - Step 01: Enter product sku = " + productSku);
        productListPage.inputToDynamicTextboxByNameAttribute(driver, productSku, skuFieldName);

        getTest().log(Status.INFO, "TC_01_Update_Category_And_Tag_And_Available_Date - Step 02: Click to 'Go' button");
        productListPage.clickToDynamicButtonById(driver, goToSkuButtonFieldName);
        FunctionHelper.sleepInSeconds(2);
        editProductPage = AdminPageGeneratorManager.getAdminPageGeneratorManager().getProductEditPage(driver);

        getTest().log(Status.INFO, "TC_01_Update_Category_And_Tag_And_Available_Date - Step 03: Clear all existed category");
        editProductPage.clickToMultiSelectDeleteButton(driver, categoryMultiSelectFieldName);

        getTest().log(Status.INFO, "TC_01_Update_Category_And_Tag_And_Available_Date - Step 04: Update category name = " + updateCategoryName);
        editProductPage.clickToHiddenMultiSelect(driver, updateCategoryName, categoryMultiSelectFieldName, categoryMultiSelectItemFieldName);

        getTest().log(Status.INFO, "TC_01_Update_Category_And_Tag_And_Available_Date - Step 05: Enter available start date = " + availableStartDate);
        editProductPage.inputToDynamicTextboxByNameAttribute(driver, availableStartDate, availableStartDateFieldName);

        getTest().log(Status.INFO, "TC_01_Update_Category_And_Tag_And_Available_Date - Step 06: Enter available end date = " + availableEndDateFieldName);
        editProductPage.inputToDynamicTextboxByNameAttribute(driver, availableEndDate, availableEndDateFieldName);

        getTest().log(Status.INFO, "TC_01_Update_Category_And_Tag_And_Available_Date - Step 07: Click to 'Save' button");
        editProductPage.clickToDynamicButtonByName(driver, saveButtonFieldName);

        getTest().log(Status.INFO, "TC_01_Update_Category_And_Tag_And_Available_Date - Step 08: Verify success alert is displayed");
        Assert.assertTrue(editProductPage.isSuccessAlertDisplayed(driver, "The product has been updated successfully."));
        FunctionHelper.sleepInSeconds(5);

        getTest().log(Status.INFO, "TC_01_Update_Category_And_Tag_And_Available_Date - Step 09: Enter product sku = " + productSku);
        productListPage.inputToDynamicTextboxByNameAttribute(driver, productSku, skuFieldName);

        getTest().log(Status.INFO, "TC_01_Update_Category_And_Tag_And_Available_Date - Step 10: Click to 'Go' button");
        productListPage.clickToDynamicButtonById(driver, goToSkuButtonFieldName);
        FunctionHelper.sleepInSeconds(2);
        editProductPage = AdminPageGeneratorManager.getAdminPageGeneratorManager().getProductEditPage(driver);

        getTest().log(Status.INFO, "TC_01_Update_Category_And_Tag_And_Available_Date - Step 11: Verify that category name = " + updateCategoryName + " is displayed");
        Assert.assertTrue(editProductPage.isSelectedCategoryItemDisplayed(driver, updateCategoryName));

        getTest().log(Status.INFO, "TC_01_Update_Category_And_Tag_And_Available_Date - Step 12: Verify that value of available start date = " + availableStartDate);
        Assert.assertEquals(editProductPage.getValueOfAvailableStartDateTextbox(driver), availableStartDate);

        getTest().log(Status.INFO, "TC_01_Update_Category_And_Tag_And_Available_Date - Step 12: Verify that value of available end date = " + availableEndDate);
        Assert.assertEquals(editProductPage.getValueOfAvailableEndDateTextbox(driver), availableEndDate);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        closeBrowserAndKillProcess();
    }
}
