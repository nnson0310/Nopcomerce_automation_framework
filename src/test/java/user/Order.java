package user;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobjects.PageGeneratorManager;
import pageobjects.user.*;
import utilities.FunctionHelper;

import java.lang.reflect.Method;

import static reportconfig.ExtentTestManager.getTest;
import static reportconfig.ExtentTestManager.startTest;

public class Order extends BaseTest {
    WebDriver driver;

    String topMenu, topMenuSubList, wishlistFieldName;
    String productName, productQuantity;
    String notification, shoppingCartHeaderLink;
    String defaultSoftware, processor, ram, hdd, os, software, productAttributes;
    String qty, unitPrice, subTotal;

    UserHomePage userHomePage;
    DesktopsPage desktopsPage;
    ProductDetailsPage productDetailsPage;
    ShoppingCartPage shoppingCartPage;

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

        topMenu = "Computers";
        topMenuSubList = "Desktops";

        log.info("Pre condition: Navigate to " + topMenuSubList + " page");
        userHomePage.clickToTopMenuSubList(driver, topMenu, topMenuSubList);
        desktopsPage = PageGeneratorManager.getPageGeneratorManager().getDesktopsPage(driver);

        //test data
        processor = "2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]";
        shoppingCartHeaderLink = "ico-cart";
        productName = "Build your own computer";
        ram = "8GB [+$60.00]";
        hdd = "400 GB [+$100.00]";
        os = "Vista Premium [+$60.00]";
        defaultSoftware = "Microsoft Office [+$50.00]";
        software = "Acrobat Reader [+$10.00]";
        qty = "3";
        notification = "The product has been added to your shopping cart";
        productAttributes = "Processor: " + processor +
                "\n" + "RAM: " + ram +
                "\n" + "HDD: " + hdd +
                "\n" + "OS: " + os +
                "\n" + "Software: " + defaultSoftware +
                "\n" + "Software: " + software;

    }

    @Test(description = "Verify that user can add product to cart")
    public void TC_01_Add_To_Cart(Method method) {

        startTest(method.getName(), "TC_01_Add_To_Cart - Start test");
        getTest().log(Status.INFO, "TC_01_Add_To_Cart - Step 01: Click to product image name = " + productName);
        productDetailsPage = desktopsPage.clickToDynamicProductImageLink(driver, productName);

        getTest().log(Status.INFO, "TC_01_Add_To_Cart - Step 02: Select Ram = " + ram);
        productDetailsPage.selectRamDropdown(driver, ram);

        getTest().log(Status.INFO, "TC_01_Add_To_Cart - Step 03: Click to choose HDD = " + hdd);
        productDetailsPage.clickToHddRadioButton(driver, hdd);

        getTest().log(Status.INFO, "TC_01_Add_To_Cart - Step 04: Click to choose os = " + os);
        productDetailsPage.clickToOsRadioButton(driver, os);

        getTest().log(Status.INFO, "TC_01_Add_To_Cart - Step 05: Click to add more software = " + software);
        productDetailsPage.clickToSoftwareCheckbox(driver, software);

        getTest().log(Status.INFO, "TC_01_Add_To_Cart - Step 06: Enter product qty = " + qty);
        productDetailsPage.enterToProductQuantityTextbox(driver, qty);

        unitPrice = productDetailsPage.getProductUnitPrice(driver);
        //caculate subTotal
        int unitPriceNumber = Integer.valueOf(FunctionHelper.getProductPriceByText(unitPrice));
        int qtyNumber = Integer.valueOf(qty);
        subTotal = String.valueOf(unitPriceNumber * qtyNumber);

        getTest().log(Status.INFO, "TC_01_Add_To_Cart - Step 07: Click to 'Add to Cart' button");
        productDetailsPage.clickToAddToCartButton(driver);

        getTest().log(Status.INFO, "TC_01_Add_To_Cart - Step 08: Verify that success message is displayed");
        Assert.assertEquals(productDetailsPage.getSuccessNotificationContent(driver), notification);

        getTest().log(Status.INFO, "TC_01_Add_To_Cart - Step 09: Close bar notification");
        productDetailsPage.clickToCloseBarNotificationButton(driver);

        getTest().log(Status.INFO, "TC_01_Add_To_Cart - Step 10: Verify that product number = " + qty + " is added to shopping cart");
        Assert.assertEquals(productDetailsPage.getProductQuantityOfShoppingCartHeaderLink(driver), qty);

        getTest().log(Status.INFO, "TC_01_Add_To_Cart - Step 11: Hover to shopping cart header link");
        productDetailsPage.hoverToShoppingCartHeaderLink(driver, shoppingCartHeaderLink);

        getTest().log(Status.INFO, "TC_01_Add_To_Cart - Step 12: Verify that mini cart's product quantity = " + qty);
        Assert.assertEquals(productDetailsPage.getProductQuantityFromMiniCart(driver), qty);

        getTest().log(Status.INFO, "TC_01_Add_To_Cart - Step 13: Verify that mini cart's product name = " + productName);
        Assert.assertTrue(productDetailsPage.isMiniCartProductNameDisplayed(driver, productName));

        getTest().log(Status.INFO, "TC_01_Add_To_Cart - Step 14: Verify that mini cart's product info = " + productName);
        Assert.assertEquals(productDetailsPage.getMiniCartProductInfo(driver), productAttributes);

        getTest().log(Status.INFO, "TC_01_Add_To_Cart - Step 15: Verify that mini cart's product unit price = " + unitPrice);
        Assert.assertEquals(productDetailsPage.getMiniCartProductUnitPrice(driver), unitPrice);

        getTest().log(Status.INFO, "TC_01_Add_To_Cart - Step 16: Verify that mini cart's product qty = " + qty);
        Assert.assertEquals(productDetailsPage.getMiniCartProductQuantity(driver), qty);

        getTest().log(Status.INFO, "TC_01_Add_To_Cart - Step 17: Verify that mini cart's subTotal = " + subTotal);
        Assert.assertEquals(productDetailsPage.getMiniCartProductSubTotal(driver), FunctionHelper.getProductPriceByText(subTotal));

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        closeBrowserAndKillProcess();
    }
}
