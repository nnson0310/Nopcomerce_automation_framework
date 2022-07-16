package user;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import commons.GlobalConstants;
import data.provider.UserCheckout;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import page.objects.UserPageGeneratorManager;
import page.objects.user.*;
import utilities.FunctionHelper;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;

import static report.config.ExtentTestManager.getTest;
import static report.config.ExtentTestManager.startTest;

public class Checkout extends BaseTest {
    WebDriver driver;

    String topMenu, topMenuSubList;
    String shippingMethod, paymentMethod;
    String firstName, lastName, fullName, email, company, country, state, city, cityStateZip, address1, postalCode, phoneNumber;

    //product info
    //sku: stock keeping unit (ma quan li kho hang)
    String productName, sku, unitPrice, quantity, subTotal;
    String orderNumber, pdfName;

    UserHomePage userHomePage;
    NotebookPage notebookPage;
    ProductDetailsPage productDetailsPage;
    ShoppingCartPage shoppingCartPage;
    UserLoginPage userLoginPage;
    CheckoutPage checkoutPage;
    OrderCompletePage orderCompletePage;
    OrderDetailPage orderDetailPage;

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

        //data
        topMenu = "Computers";
        topMenuSubList = "Notebooks";
        productName = "HP Spectre XT Pro UltraBook";

        log.info("Pre condition - Step 01: Navigate to " + topMenuSubList + " page");
        userHomePage.clickToTopMenuSubList(driver, topMenu, topMenuSubList);
        notebookPage = UserPageGeneratorManager.getUserPageGeneratorManager().getNotebookPage(driver);

        log.info("Pre condition - Step 02: Click to image of product name = " + productName);
        productDetailsPage = notebookPage.clickToDynamicProductImageLink(driver, productName);
        unitPrice = productDetailsPage.getProductUnitPrice(driver);
        quantity = productDetailsPage.getProductQuantity(driver);
        sku = productDetailsPage.getSkuCode(driver);

        log.info("Pre condition - Step 03: Click to 'Add to cart' button");
        productDetailsPage.clickToAddToCartButton(driver);

        log.info("Pre condition - Step 05: Verify that success message is displayed");
        Assert.assertEquals(productDetailsPage.getSuccessNotificationContent(driver), "The product has been added to your shopping cart");

        log.info("Pre condition - Step 04: Close bar notification");
        productDetailsPage.clickToCloseBarNotificationButton(driver);
        FunctionHelper.sleepInSeconds(1);

        log.info("Pre condition - Step 05: Click to 'Shopping Cart' header link");
        productDetailsPage.clickToDynamicHeaderLink(driver, "ico-cart");
        shoppingCartPage = UserPageGeneratorManager.getUserPageGeneratorManager().getShoppingCartPage(driver);
        subTotal = shoppingCartPage.getSubTotal(driver);

        //test data
        shippingMethod = "Next Day Air ($0.00)";
        paymentMethod = "Check / Money Order";

    }

    @Test(
            description = "Verify that user can checkout order with 'cheque' payment method",
            dataProvider = "user-checkout",
            dataProviderClass = UserCheckout.class
    )
    public void TC_01_Cheque_Payment_Method(HashMap<String, String> billingAddress, Method method) {

        firstName = billingAddress.get("first_name");
        lastName = billingAddress.get("last_name");
        fullName = firstName + " " + lastName;
        email = billingAddress.get("email");
        company = billingAddress.get("company");
        postalCode = billingAddress.get("postal_code");
        country = billingAddress.get("country");
        state = billingAddress.get("state");
        city = billingAddress.get("city");
        cityStateZip = city + "," + state + "," + postalCode;
        address1 = billingAddress.get("address1");
        phoneNumber = billingAddress.get("phone_number");

        startTest(method.getName(), "TC_01_Cheque_Payment_Method - Start test");
        getTest().log(Status.INFO, "TC_01_Cheque_Payment_Method - Step 01: Click to 'Agree with term of service' checkbox");
        shoppingCartPage.clickToAgreeWithTermOfService(driver);

        getTest().log(Status.INFO, "TC_01_Cheque_Payment_Method - Step 02: Click to Checkout button");
        shoppingCartPage.clickToCheckoutButton(driver);
        userLoginPage = UserPageGeneratorManager.getUserPageGeneratorManager().getUserLoginPage(driver);

        getTest().log(Status.INFO, "TC_01_Cheque_Payment_Method - Step 03: Click to 'Checkout as guest' button");
        checkoutPage = userLoginPage.clickToCheckoutAsGuestButton(driver);

        getTest().log(Status.INFO, "TC_01_Cheque_Payment_Method - Step 04: Enter billing address's first name = " + firstName);
        checkoutPage.inputToDynamicTextboxByNameAttribute(driver, firstName, "BillingNewAddress.FirstName");

        getTest().log(Status.INFO, "TC_01_Cheque_Payment_Method - Step 05: Enter billing address's last name = " + lastName);
        checkoutPage.inputToDynamicTextboxByNameAttribute(driver, lastName, "BillingNewAddress.LastName");

        getTest().log(Status.INFO, "TC_01_Cheque_Payment_Method - Step 06: Enter billing address's email = " + email);
        checkoutPage.inputToDynamicTextboxByNameAttribute(driver, email, "BillingNewAddress.Email");

        getTest().log(Status.INFO, "TC_01_Cheque_Payment_Method - Step 07: Enter billing address's company = " + company);
        checkoutPage.inputToDynamicTextboxByNameAttribute(driver, company, "BillingNewAddress.Company");

        getTest().log(Status.INFO, "TC_01_Cheque_Payment_Method - Step 08: Select billing address's country = " + country);
        checkoutPage.selectCountryOfBillingAddress(driver, country);

        getTest().log(Status.INFO, "TC_01_Cheque_Payment_Method - Step 09: Select billing address's state/province = " + state);
        checkoutPage.selectStateOfBillingAddress(driver, state);

        getTest().log(Status.INFO, "TC_01_Cheque_Payment_Method - Step 10: Enter billing address's city = " + city);
        checkoutPage.inputToDynamicTextboxByNameAttribute(driver, city, "BillingNewAddress.City");

        getTest().log(Status.INFO, "TC_01_Cheque_Payment_Method - Step 11: Enter billing address's address 1 = " + address1);
        checkoutPage.inputToDynamicTextboxByNameAttribute(driver, address1, "BillingNewAddress.Address1");

        getTest().log(Status.INFO, "TC_01_Cheque_Payment_Method - Step 12: Enter billing address's postal code = " + postalCode);
        checkoutPage.inputToDynamicTextboxByNameAttribute(driver, postalCode, "BillingNewAddress.ZipPostalCode");

        getTest().log(Status.INFO, "TC_01_Cheque_Payment_Method - Step 13: Enter billing address's phone number = " + phoneNumber);
        checkoutPage.inputToDynamicTextboxByNameAttribute(driver, phoneNumber, "BillingNewAddress.PhoneNumber");

        getTest().log(Status.INFO, "TC_01_Cheque_Payment_Method - Step 14: Click to 'Continue' Button");
        checkoutPage.clickToDynamicContinueButton(driver, "new-address-next-step-button");

        getTest().log(Status.INFO, "TC_01_Cheque_Payment_Method - Step 15: Click to choose shipping method = " + shippingMethod);
        checkoutPage.clickToShippingMethodRadioButton(driver, shippingMethod);

        getTest().log(Status.INFO, "TC_01_Cheque_Payment_Method - Step 16: Click to  'Continue' button");
        checkoutPage.clickToDynamicContinueButton(driver, "shipping-method-next-step-button");

        getTest().log(Status.INFO, "TC_01_Cheque_Payment_Method - Step 17: Click to choose payment method = " + paymentMethod);
        checkoutPage.clickToPaymentMethodRadioButton(driver, paymentMethod);

        getTest().log(Status.INFO, "TC_01_Cheque_Payment_Method - Step 18: Click to  'Continue' button");
        checkoutPage.clickToDynamicContinueButton(driver, "payment-method-next-step-button");

        getTest().log(Status.INFO, "TC_01_Cheque_Payment_Method - Step 19: Click to  'Continue' button");
        checkoutPage.clickToDynamicContinueButton(driver, "payment-info-next-step-button");

        getTest().log(Status.INFO, "TC_01_Cheque_Payment_Method - Step 20: Verify billing address info: "
                        + "Name = " + fullName
                        + ", Email = " + email
                        + ", Phone = " + phoneNumber
                        + ", Company = " + company
                        + ", Address1 = " + address1
                        + ", City-state-zip = " + cityStateZip
                        + ", Country = " + country
        );
        Assert.assertTrue(checkoutPage.isBillingAddressInfoCorrect(driver, fullName, email, phoneNumber, company, address1, cityStateZip, country));

        getTest().log(Status.INFO, "TC_01_Cheque_Payment_Method - Step 21: Verify that payment method = " + paymentMethod);
        Assert.assertEquals(checkoutPage.getPaymentMethodOfConfirmOrder(driver), paymentMethod);

        getTest().log(Status.INFO, "TC_01_Cheque_Payment_Method - Step 22: Verify shipping address info: "
                + "Name = " + fullName
                + ", Email = " + email
                + ", Phone = " + phoneNumber
                + ", Company = " + company
                + ", Address1 = " + address1
                + ", City-state-zip = " + cityStateZip
                + ", Country = " + country
        );
        Assert.assertTrue(checkoutPage.isShippingAddressInfoCorrect(driver, fullName, email, phoneNumber, company, address1, cityStateZip, country));

        getTest().log(Status.INFO, "TC_01_Cheque_Payment_Method - Step 23: Verify that shipping method = " + shippingMethod);
        Assert.assertEquals(checkoutPage.getShippingMethodOfConfirmOrder(driver), FunctionHelper.getOnlyCharacterFromString(shippingMethod));

        getTest().log(Status.INFO, "TC_01_Cheque_Payment_Method - Step 24: Verify cart info: "
                + "SKU = " + sku
                + ", Product Name = " + productName
                + ", Price = " + unitPrice
                + ", Quantity = " + quantity
                + ", Sub total = " + subTotal
        );
        Assert.assertTrue(checkoutPage.isCartInfoCorrect(driver, sku, productName, unitPrice, quantity, subTotal));

        getTest().log(Status.INFO, "TC_01_Cheque_Payment_Method - Step 24: Click to Confirm button");
        orderCompletePage = checkoutPage.clickToConfirmButton(driver);

        getTest().log(Status.INFO, "TC_01_Cheque_Payment_Method - Step 25: Verify that order success message is displayed");
        Assert.assertTrue(orderCompletePage.isOrderSuccessMessageDisplayed(driver, "Your order has been successfully processed!"));

        //get order number
        orderNumber = orderCompletePage.getOrderNumberInfo(driver);

        getTest().log(Status.INFO, "TC_01_Cheque_Payment_Method - Step 26: Click to order details link");
        orderDetailPage = orderCompletePage.clickToOrderDetailLink(driver);

        getTest().log(Status.INFO, "TC_01_Cheque_Payment_Method - Step 27: Verify that order number in order detail page = " + orderNumber);
        Assert.assertTrue(orderDetailPage.isOrderNumberDisplayed(driver, orderNumber));

    }

    @Test(description = "Verify that user can download pdf invoice with correct information of orders")
    public void TC_02_Download_Pdf_Invoice(Method method) {

        startTest(method.getName(), "TC_02_Download_Pdf_Invoice - Start test");
        getTest().log(Status.INFO, "TC_02_Download_Pdf_Invoice - Step 01: Click to 'PDF Invoice' button to download and auto save file");
        orderDetailPage.clickToPDFInvoiceButton(driver);
        FunctionHelper.sleepInSeconds(2);

        //pdf name
        pdfName = "order_" + orderNumber + ".pdf";

        getTest().log(Status.INFO, "TC_02_Download_Pdf_Invoice - Step 02: Verify that user can download pdf name = " + pdfName);
        String pathToFile = GlobalConstants.getGlobalConstants().getDownloadFilePath() + pdfName;
        File pdfFile = new File(pathToFile);
        Assert.assertTrue(pdfFile.exists());

        getTest().log(Status.INFO, "TC_02_Download_Pdf_Invoice - Step 03: Verify pdf content contains correct order number = " + orderNumber);
        Assert.assertTrue(orderDetailPage.verifyPdfContent(pdfName, pathToFile, "Order# " + orderNumber));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        closeBrowserAndKillProcess();
    }
}
