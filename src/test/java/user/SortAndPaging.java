package user;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import dataprovider.UserSortAndPaging;
import dbconnection.DBConnect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobjects.PageGeneratorManager;
import pageobjects.user.NotebookPage;
import pageobjects.user.UserHomePage;
import utilities.FunctionHelper;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static reportconfig.ExtentTestManager.getTest;
import static reportconfig.ExtentTestManager.startTest;

public class SortAndPaging extends BaseTest {

    WebDriver driver;

    UserHomePage userHomePage;
    NotebookPage notebookPage;

    String topMenu, topMenuSubList;
    int currentProductNumbers;
    Connection conn;

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
    ) throws SQLException {
        driver = getBrowserDriver(userSiteUrl, browserName, browserVersion, environmentName, ipAddress, port, platform);
        userHomePage = PageGeneratorManager.getPageGeneratorManager().getUserHomePage(driver);

        topMenu = "Computers";
        topMenuSubList = "Notebooks";

        log.info("Pre condition: Navigate to " + topMenuSubList + " page");
        userHomePage.clickToTopMenuSubList(driver, topMenu, topMenuSubList);
        notebookPage = PageGeneratorManager.getPageGeneratorManager().getNotebookPage(driver);

        //test data
        //current number of products in database
        //sample connect to database
        try {
            String dbName = "Automation_Sample";
            conn = DBConnect.getDBConnection(dbName);
            Statement statement = conn.createStatement();
            String sql = "Select count(*) as product_numbers from product";
            ResultSet result = statement.executeQuery(sql);
            while(result.next()) {
                currentProductNumbers = result.getInt("product_numbers");
            }
        } finally {
            conn.close();
        }

    }

    @Test(
            description = "Verify that product name is sorted from a to z correctly",
            dataProvider = "user-sort-paging",
            dataProviderClass = UserSortAndPaging.class
    )
    public void TC_01_Sort(String sortName, Method method) {

        startTest(method.getName(), "TC_01_Name_From_A_To_Z - Start test");
        getTest().log(Status.INFO, "TC_01_Name_From_A_To_Z - Step 01: Click to sortName = " + sortName);
        notebookPage.selectSortByName(driver, sortName);
        FunctionHelper.sleepInSeconds(1);

        getTest().log(Status.INFO, "TC_01_Name_From_A_To_Z - Step 02: Verify that product name is sorted correctly");
        Assert.assertTrue(notebookPage.isProductSortedCorrectly(driver, sortName));

    }

    @Test(
            description = "Verify that paging feature is correct",
            dataProvider = "user-sort-paging",
            dataProviderClass = UserSortAndPaging.class
    )
    public void TC_02_Paging(String perPage, Method method) {
        startTest(method.getName(), "TC_02_Display_3_Per_Page - Start test");
        getTest().log(Status.INFO, "TC_02_Display_3_Per_Page - Step 01: Click to display per page = " + perPage);
        notebookPage.clickToDisplayPerPage(driver, perPage);
        FunctionHelper.sleepInSeconds(2);

        getTest().log(Status.INFO, "TC_02_Display_3_Per_Page - Step 02: Verify that only " + perPage + " products are displayed");
        Assert.assertTrue(notebookPage.isItemPerPageDisplayedCorrectly(driver, perPage));

        getTest().log(Status.INFO, "TC_02_Display_3_Per_Page - Step 02: Verify that only " + perPage + " products are displayed");
        int itemPerPage = Integer.valueOf(perPage);
        if (itemPerPage < currentProductNumbers) {
            Assert.assertTrue(notebookPage.isPagingIconDisplayed(driver, itemPerPage, currentProductNumbers));
        }
        else {
            Assert.assertFalse(notebookPage.isPagingIconDisplayed(driver, itemPerPage, currentProductNumbers));
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        closeBrowserAndKillProcess();
    }

}
