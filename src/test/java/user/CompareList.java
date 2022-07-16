package user;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import page.objects.user.CompareListPage;
import page.objects.UserPageGeneratorManager;
import page.objects.user.NotebookPage;
import page.objects.user.UserHomePage;

import java.lang.reflect.Method;
import static report.config.ExtentTestManager.getTest;
import static report.config.ExtentTestManager.startTest;

public class CompareList extends BaseTest {
    WebDriver driver;

    String topMenu, topMenuSubList, wishlistFieldName;
    String firstCompareProduct, secondCompareProduct, productQuantity;
    String firstCompareProductPrice, secondCompareProductPrice;
    String notification;
    String footerLink;

    UserHomePage userHomePage;
    NotebookPage notebookPage;
    CompareListPage compareListPage;

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

        topMenu = "Computers";
        topMenuSubList = "Notebooks";

        log.info("Pre condition: Navigate to " + topMenuSubList + " page");
        userHomePage.clickToTopMenuSubList(driver, topMenu, topMenuSubList);
        notebookPage = UserPageGeneratorManager.getUserPageGeneratorManager().getNotebookPage(driver);

        //test data
        firstCompareProduct = "Apple MacBook Pro 13-inch";
        secondCompareProduct = "Asus N551JK-XO076H Laptop";
        notification = "The product has been added to your product comparison";
        footerLink = "Compare products list";

    }

    @Test(description = "Verify that user can add product to compare list")
    public void TC_01_Add_To_Compare_List (Method method) {
        firstCompareProductPrice = notebookPage.getProductPrice(driver, firstCompareProduct);
        secondCompareProductPrice = notebookPage.getProductPrice(driver, secondCompareProduct);

        startTest(method.getName(), "TC_01_Add_To_Compare_List - Start test");
        getTest().log(Status.INFO, "TC_01_Add_To_Compare_List - Step 01: Click to 'add to compare list' button of product name = " + firstCompareProduct);
        notebookPage.clickToAddToCompareListButton(driver, firstCompareProduct);

        getTest().log(Status.INFO, "TC_01_Add_To_Compare_List - Step 02: Verify that notification = '" + notification + "' is displayed");
        Assert.assertEquals(notebookPage.getSuccessNotificationContent(driver), notification);

        getTest().log(Status.INFO, "TC_01_Add_To_Compare_List - Step 03: Click to 'add to compare list' button of product name = " + secondCompareProduct);
        notebookPage.clickToAddToCompareListButton(driver, secondCompareProduct);

        getTest().log(Status.INFO, "TC_01_Add_To_Compare_List - Step 04: Verify that notification = " + notification + " is displayed");
        Assert.assertEquals(notebookPage.getSuccessNotificationContent(driver), notification);

        getTest().log(Status.INFO, "TC_01_Add_To_Compare_List - Step 05: Click to 'Compare products list' footer link");
        notebookPage.clickToDynamicFooterLink(driver, footerLink);
        compareListPage = UserPageGeneratorManager.getUserPageGeneratorManager().getCompareListPage(driver);

        getTest().log(Status.INFO, "TC_01_Add_To_Compare_List - Step 06: Verify that first compared product name = " + firstCompareProduct + " and price = " + firstCompareProductPrice);
        Assert.assertEquals(compareListPage.getComparedProductPrice(driver, firstCompareProduct), firstCompareProductPrice);

        getTest().log(Status.INFO, "TC_01_Add_To_Compare_List - Step 07: Verify that second compared product name = " + secondCompareProduct + " and price = " + secondCompareProductPrice);
        Assert.assertEquals(compareListPage.getComparedProductPrice(driver, secondCompareProduct), secondCompareProductPrice);

        getTest().log(Status.INFO, "TC_01_Add_To_Compare_List - Step 08: Click 'Clear List' button");
        compareListPage.clickToClearListButton(driver);

        getTest().log(Status.INFO, "TC_01_Add_To_Compare_List - Step 09: Verify that all products are cleared from compare list");
        Assert.assertTrue(compareListPage.isClearListMessageDisplayed(driver, "You have no items to compare."));

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        closeBrowserAndKillProcess();
    }
}
