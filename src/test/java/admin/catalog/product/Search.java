package admin.catalog.product;

import admin.PreCondition_Login;
import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import page.objects.AdminPageGeneratorManager;
import page.objects.admin.LoginPage;
import page.objects.admin.ProductListPage;
import utilities.FunctionHelper;

import java.lang.reflect.Method;

import static report.config.ExtentTestManager.getTest;
import static report.config.ExtentTestManager.startTest;

public class Search extends BaseTest {

    WebDriver driver;

    LoginPage loginPage;
    ProductListPage productListPage;

    String productName, categoryName, manufacturer;
    String productNameFieldName, categoryDropdownFieldName, subCategoryCheckboxFieldName, manufacturerDropdownFieldName;
    String searchButtonId, tableId, pagingInfoId;

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
        productNameFieldName = "SearchProductName";
        categoryDropdownFieldName = "SearchCategoryId";
        subCategoryCheckboxFieldName = "SearchIncludeSubCategories";
        manufacturerDropdownFieldName = "SearchManufacturerId";
        searchButtonId = "search-products";
        tableId = "products-grid";
        pagingInfoId = "div#products-grid_info";

        //test data
        productName = "Lenovo IdeaCentre 600 All-in-One PC";
        categoryName = "Electronics";
        manufacturer = "Apple";

    }


    @Test(description = "Verify that user can search with product name and manufacturer")
    public void TC_01_With_Product_Name (Method method) {

        startTest(method.getName(), "TC_01_Search_With_Product_Name - Start test");
        getTest().log(Status.INFO, "TC_01_Search_With_Product_Name - Step 01: Enter product name = " + productName);
        productListPage.inputToDynamicTextboxByNameAttribute(driver, productName, productNameFieldName);

        getTest().log(Status.INFO, "TC_01_Search_With_Product_Name - Step 02: Click to Search button");
        productListPage.clickToDynamicButtonById(driver, searchButtonId);
        FunctionHelper.sleepInSeconds(1);

        getTest().log(Status.INFO, "TC_01_Search_With_Product_Name - Step 03: Verify that only one product with name = " + productName + " is displayed as search result");
        Assert.assertTrue(productListPage.isSearchResultDisplayedCorrect(driver, tableId, productName, 1));
    }

    @Test(description = "Verify that user can search with product name and manufacturer")
    public void TC_02_With_Product_Name_And_Manufacturer (Method method) {
        startTest(method.getName(), "TC_02_With_Product_Name_And_Manufacturer - Start test");
        getTest().log(Status.INFO, "TC_02_With_Product_Name_And_Manufacturer - Step 01: Enter product name = " + productName);
        productListPage.inputToDynamicTextboxByNameAttribute(driver, productName, productNameFieldName);

        getTest().log(Status.INFO, "TC_02_With_Product_Name_And_Manufacturer - Step 02: Select category = " + categoryName);
        productListPage.clickToDynamicSelectByNameAttribute(driver, categoryName, categoryDropdownFieldName);

        getTest().log(Status.INFO, "TC_02_With_Product_Name_And_Manufacturer - Step 03: Uncheck 'Search subcategories' checkbox");
        productListPage.uncheckDynamicCheckboxOrRadioByName(driver, subCategoryCheckboxFieldName);

        getTest().log(Status.INFO, "TC_02_With_Product_Name_And_Manufacturer - Step 04: Select manufacturer = " + manufacturer);
        productListPage.clickToDynamicSelectByNameAttribute(driver, manufacturer, manufacturerDropdownFieldName);

        getTest().log(Status.INFO, "TC_02_With_Product_Name_And_Manufacturer - Step 05: Click to 'Search' Button");
        productListPage.clickToDynamicButtonById(driver, searchButtonId);

        getTest().log(Status.INFO, "TC_02_With_Product_Name_And_Manufacturer - Step 05: Verify that no data is displayed");
        Assert.assertTrue(productListPage.isNoSearchResultMessageDisplayed(driver, "No data available in table"));
    }

//    @AfterClass(alwaysRun = true)
//    public void tearDown() {
//        closeBrowserAndKillProcess();
//    }
}
