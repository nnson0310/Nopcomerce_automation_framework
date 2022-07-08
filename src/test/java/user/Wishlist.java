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

public class Wishlist extends BaseTest {

    WebDriver driver;

    String topMenu, topMenuSubList, wishlistFieldName;
    String productName, productQuantity;
    String notification;

    UserHomePage userHomePage;
    NotebookPage notebookPage;
    ProductDetailsPage productDetailsPage;
    WishlistPage wishlistPage;
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
        topMenuSubList = "Notebooks";

        log.info("Pre condition: Navigate to " + topMenuSubList + " page");
        userHomePage.clickToTopMenuSubList(driver, topMenu, topMenuSubList);
        notebookPage = PageGeneratorManager.getPageGeneratorManager().getNotebookPage(driver);

        //test data
        wishlistFieldName = "ico-wishlist";
        productName = "Apple MacBook Pro 13-inch";
        notification = "The product has been added to your wishlist";

    }

    @Test(description = "Verify that user can add product to wishlist")
    public void TC_01_Add_To_Wishlist(Method method) {

        startTest(method.getName(), "TC_01_Add_To_Wishlist - Start test");
        getTest().log(Status.INFO, "TC_01_Add_To_Wishlist - Step 01: Click to product image name = " + productName);
        notebookPage.clickToDynamicProductImageLink(driver, productName);
        productDetailsPage = PageGeneratorManager.getPageGeneratorManager().getProductDetailsPage(driver);

        // get default product quantity
        productQuantity = productDetailsPage.getProductQuantity(driver);

        getTest().log(Status.INFO, "TC_01_Add_To_Wishlist - Step 02: Click 'Add to wishlist' button");
        productDetailsPage.clickToAddToWishlistButton(driver);

        getTest().log(Status.INFO, "TC_01_Add_To_Wishlist - Step 03: Verify that notification with message = " + notification + " is displayed");
        Assert.assertEquals(productDetailsPage.getSuccessNotificationContent(driver), notification);

        getTest().log(Status.INFO, "TC_01_Add_To_Wishlist - Step 04: Click to close notification");
        productDetailsPage.clickToCloseBarNotificationButton(driver);
        FunctionHelper.sleepInSeconds(1);

        getTest().log(Status.INFO, "TC_01_Add_To_Wishlist - Step 05: Click to wishlist header link");
        productDetailsPage.clickToDynamicHeaderLink(driver, wishlistFieldName);
        wishlistPage = PageGeneratorManager.getPageGeneratorManager().getWishlistPage(driver);

        getTest().log(Status.INFO, "TC_01_Add_To_Wishlist - Step 06: Verify that products = " + productName + " are added to wishlist successfully");
        Assert.assertTrue(wishlistPage.isProductAddedToWishlist(driver, productName));

        getTest().log(Status.INFO, "TC_01_Add_To_Wishlist - Step 07: Click to share link");
        wishlistPage.clickToSharingLink(driver);

        getTest().log(Status.INFO, "TC_01_Add_To_Wishlist - Step 08: Verify that products = " + productName + " are added to wishlist successfully");
        Assert.assertTrue(wishlistPage.isProductAddedToWishlist(driver, productName));
    }

    @Test(description = "Verify that user can add product to cart from wishlist")
    public void TC_02_Add_To_Cart_From_Wishlist(Method method) {
        startTest(method.getName(), "TC_02_Add_To_Cart_From_Wishlist - Start test");
        getTest().log(Status.INFO, "TC_02_Add_To_Cart_From_Wishlist - Step 01: Click to header logo to return to home page");
        userHomePage = wishlistPage.clickToHeaderLogoLink(driver);

        getTest().log(Status.INFO, "TC_02_Add_To_Cart_From_Wishlist - Step 02: Click to wishlist header link");
        userHomePage.clickToDynamicHeaderLink(driver, wishlistFieldName);
        wishlistPage = PageGeneratorManager.getPageGeneratorManager().getWishlistPage(driver);

        getTest().log(Status.INFO, "TC_02_Add_To_Cart_From_Wishlist - Step 03: Click to 'Add to cart' checkbox");
        wishlistPage.clickToAddToCartCheckbox(driver, productName);

        getTest().log(Status.INFO, "TC_02_Add_To_Cart_From_Wishlist - Step 04: Click to 'Add to cart' button");
        wishlistPage.clickToAddToCartButton(driver);
        shoppingCartPage = PageGeneratorManager.getPageGeneratorManager().getShoppingCartPage(driver);

        getTest().log(Status.INFO, "TC_02_Add_To_Cart_From_Wishlist - Step 05: Verify that product = " + productName + " are added to cart successfully");
        Assert.assertTrue(shoppingCartPage.isProductAddedToCart(driver, productName));

        getTest().log(Status.INFO, "TC_02_Add_To_Cart_From_Wishlist - Step 06: Verify that product qty in textbox = " + productQuantity);
        Assert.assertEquals(shoppingCartPage.getProductQuantity(driver, productName), productQuantity);

        getTest().log(Status.INFO, "TC_02_Add_To_Cart_From_Wishlist - Step 07: Verify that wishlist is empty");
        Assert.assertEquals(shoppingCartPage.getProductQuantityOfWishlistHeaderLink(driver), "0");

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        closeBrowserAndKillProcess();
    }
}
