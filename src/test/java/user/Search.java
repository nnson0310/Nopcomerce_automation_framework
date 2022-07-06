package user;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageobjects.PageGeneratorManager;
import pageobjects.user.*;
import static reportconfig.ExtentTestManager.startTest;
import static reportconfig.ExtentTestManager.getTest;

import java.lang.reflect.Method;

public class Search extends BaseTest {
    WebDriver driver;

    String firstName, lastName, email, password;
    String productName, categoryName;
    int expectedResultNumber;

    UserHomePage userHomePage;
    SearchPage searchPage;

    @Parameters({"userSiteUrl", "browserName", "browserVersion", "environmentName", "ipAddress", "port", "platform"})
    @BeforeTest
    public void setUp(
            String userSiteUrl,
            @Optional("firefox") String browserName,
            @Optional("latest") String browserVersion,
            @Optional("local") String environmentName,
            @Optional("localhost") String ipAddress,
            @Optional("4444") String port,
            @Optional("Windows 10") String platform,
            Method method
    ) {
        driver = getBrowserDriver(userSiteUrl, browserName, browserVersion, environmentName, ipAddress, port, platform);
        userHomePage = PageGeneratorManager.getPageGeneratorManager().getUserHomePage(driver);

        log.info("Pre condition: Navigate to search page");
        userHomePage.clickToDynamicFooterLink(driver, "Search");
        searchPage = PageGeneratorManager.getPageGeneratorManager().getSearchPage(driver);

    }

    @Test(description = "Verify that error message is displayed when searching with empty keyword")
    public void TC_01_Empty_Keyword(Method method) {
        startTest(method.getName(), "TC_01_Empty_Keyword - Start test");
        getTest().log(Status.INFO, "TC_01_Empty_Keyword - Step 01: Enter empty keyword");
        searchPage.inputToSearchTextbox(driver, "");

        getTest().log(Status.INFO, "TC_01_Empty_Keyword - Step 02: Click to Search Button");
        searchPage.clickToSearchButton(driver);

        getTest().log(Status.INFO, "TC_01_Empty_Keyword - Step 03: Verify that 'Search term minimum length is 3 characters' error message is displayed");
        searchPage.isDynamicSearchErrorDisplayed(driver, "Search term minimum length is 3 characters");
    }

    @Test(description = "Verify that there is search result corresponding to partial product name search")
    public void TC_02_Partial_Product_Name(Method method) {
        expectedResultNumber = 2;
        productName = "Lenovo";

        startTest(method.getName(), "TC_02_Partial_Product_Name - Start test");
        getTest().log(Status.INFO, "TC_02_Partial_Product_Name - Step 01: Enter product name = " + productName);
        searchPage.inputToSearchTextbox(driver, productName);

        getTest().log(Status.INFO, "TC_02_Partial_Product_Name - Step 02: Click to Search Button");
        searchPage.clickToSearchButton(driver);

        getTest().log(Status.INFO, "TC_02_Partial_Product_Name - Step 03: Verify that there are " + expectedResultNumber + " products and all product names contain " + productName);
        searchPage.isSearchResultCorrect(driver, expectedResultNumber, productName);
    }

    @Test(description = "Verify that there is search result corresponding to full product name search")
    public void TC_03_Full_Product_Name(Method method) {
        expectedResultNumber = 1;
        productName = "Thinkpad X1 Carbon";

        startTest(method.getName(), "TC_03_Full_Product_Name - Start test");
        getTest().log(Status.INFO, "TC_03_Full_Product_Name - Step 01: Enter product name = " + productName);
        searchPage.inputToSearchTextbox(driver, productName);

        getTest().log(Status.INFO, "TC_03_Full_Product_Name - Step 02: Click to Search Button");
        searchPage.clickToSearchButton(driver);

        getTest().log(Status.INFO, "TC_03_Full_Product_Name - Step 03: Verify that there are " + expectedResultNumber + " products and all product names contain " + productName);
        searchPage.isSearchResultCorrect(driver, expectedResultNumber, productName);
    }

    @Test(description = "Verify that user can conduct advanced search with sub category")
    public void TC_04_Advanced_Search_With_Sub_Category(Method method) {
        expectedResultNumber = 1;
        productName = "Apple Macbook Pro";
        categoryName = "Computers";

        startTest(method.getName(), "TC_04_Advanced_Search_With_Sub_Category - Start test");
        getTest().log(Status.INFO, "TC_04_Advanced_Search_With_Sub_Category - Step 01: Enter product name = " + productName);
        searchPage.inputToSearchTextbox(driver, productName);

        getTest().log(Status.INFO, "TC_04_Advanced_Search_With_Sub_Category - Step 02: Click to advanced search checkbox");
        searchPage.clickToAdvancedSearchCheckbox(driver);

        getTest().log(Status.INFO, "TC_04_Advanced_Search_With_Sub_Category - Step 03: Select category = " + categoryName);
        searchPage.selectToCategoryDropdown(driver, categoryName);

        getTest().log(Status.INFO, "TC_04_Advanced_Search_With_Sub_Category - Step 04: Click to 'Automatically search sub categories' checkbox");
        searchPage.clickToSearchWithSubCategoryCheckbox(driver);

        getTest().log(Status.INFO, "TC_04_Advanced_Search_With_Sub_Category - Step 02: Click to Search Button");
        searchPage.clickToSearchButton(driver);

        getTest().log(Status.INFO, "TC_04_Advanced_Search_With_Sub_Category - Step 03: Verify that there are " + expectedResultNumber + " products and all product names contain " + productName);
        searchPage.isSearchResultCorrect(driver, expectedResultNumber, productName);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        closeBrowserAndKillProcess();
    }
}
