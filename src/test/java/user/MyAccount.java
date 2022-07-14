package user;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import page.objects.UserPageGeneratorManager;
import page.objects.user.*;
import utilities.DataFaker;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static report.config.ExtentTestManager.getTest;
import static report.config.ExtentTestManager.startTest;

public class MyAccount extends BaseTest {

    WebDriver driver;

    UserHomePage userHomePage;
    UserLoginPage userLoginPage;
    UserRegisterPage userRegisterPage;
    UserRegisterResultPage userRegisterResultPage;
    MyAccountPage myAccountPage;
    DesktopsPage desktopsPage;
    ProductDetailsPage productDetailsPage;
    ProductReviewsPage productReviewsPage;
    MyProductReviewsPage myProductReviewsPage;

    String firstName, lastName, email, password;
    String firstNameFieldName, lastNameFieldName;
    String blockAccountNavigation, topMenu, topMenuSubList, productTitle;
    String reviewTitle, reviewText, rating;
    String myAccountHeaderLink;
    String myProductReviewNavigation;
    Map<String, Integer> ratings;

    @Parameters({"userSiteUrl", "browserName", "browserVersion", "environmentName", "ipAddress", "port", "platform"})
    @BeforeClass
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
        userHomePage = UserPageGeneratorManager.getUserPageGeneratorManager().getUserHomePage(driver);

        //registration info
        firstName = "son";
        lastName = "thu";
        email = DataFaker.getDataFaker().generateEmail();
        password = "123456";

        log.info("Pre Condition - Register and Login - Step 01: Navigate to register page");
        userRegisterPage = userHomePage.clickToRegisterLink(driver);

        log.info("Pre Condition - Register and Login - Step 02: Enter first name = " + firstName);
        userRegisterPage.inputToDynamicTextbox(driver, firstName, "FirstName");

        log.info("Pre Condition - Register and Login - Step 03: Enter last name = " + lastName);
        userRegisterPage.inputToDynamicTextbox(driver, lastName, "LastName");

        log.info("Pre Condition - Register and Login - Step 04: Enter email = " + email);
        userRegisterPage.inputToDynamicTextbox(driver, email, "Email");

        log.info("Pre Condition - Register and Login - Step 05: Enter password = " + password);
        userRegisterPage.inputToDynamicTextbox(driver, password, "Password");

        log.info("Pre Condition - Register and Login - Step 06: Enter confirm password = " + password);
        userRegisterPage.inputToDynamicTextbox(driver, password, "ConfirmPassword");

        log.info("Pre Condition - Register and Login - Step 07: Click to register button");
        userRegisterPage.clickToRegisterButton(driver);
        userRegisterResultPage = UserPageGeneratorManager.getUserPageGeneratorManager().getUserRegisterResultPage(driver);

        log.info("Pre Condition - Register and Login - Step 08: Click to continue button");
        userHomePage = userRegisterResultPage.clickToContinueButton(driver);

        log.info("Pre Condition - Register and Login - Step 09: Click to my account header link");
        myAccountPage = userHomePage.clickToMyAccountLink(driver);

        //test data
        firstNameFieldName = "FirstName";
        lastNameFieldName = "LastName";
        myAccountHeaderLink = "ico-account";
        myProductReviewNavigation = "My product reviews";
        ratings = new HashMap<String, Integer>();
        ratings.put("Bad", 20);
        ratings.put("Not good", 40);
        ratings.put("Not bad but also not excellent", 60);
        ratings.put("Good", 80);
        ratings.put("Excellent", 100);

    }

    @Test(description = "Update account info and verify that account info is updated successfully")
    public void TC_01_Update_Account_Info(Method method) {
        firstName = "Huyen";
        lastName = "Dao";

        startTest(method.getName(), "TC_01_Update_Account_Info - Start Test");
        getTest().log(Status.INFO, "TC_01_Update_Account_Info - Step 01: Enter first name = " + firstName);
        myAccountPage.inputToDynamicTextbox(driver, firstName, firstNameFieldName);

        getTest().log(Status.INFO, "TC_01_Update_Account_Info - Step 02: Enter last name = " + lastName);
        myAccountPage.inputToDynamicTextbox(driver, lastName, lastNameFieldName);

        getTest().log(Status.INFO, "TC_01_Update_Account_Info - Step 03: Click to SAVE button");
        myAccountPage.clickToSaveButton(driver);

        getTest().log(Status.INFO, "TC_01_Update_Account_Info - Step 04: Verify that first_name textbox value = " + firstName + " is updated successfully");
        Assert.assertEquals(myAccountPage.getAccountInfo(driver, firstNameFieldName), firstName);

        getTest().log(Status.INFO, "TC_01_Update_Account_Info - Step 05: Verify that last_name textbox value = " + lastName + " is updated successfully");
        Assert.assertEquals(myAccountPage.getAccountInfo(driver, lastNameFieldName), lastName);
    }

    @Test(description = "Add new product review and verify that review id displayed in 'My Product Reviews' category")
    public void TC_02_Add_Product_Reviews(Method method) {

        blockAccountNavigation = "My product reviews";
        topMenu = "Computers";
        topMenuSubList = "Desktops";
        productTitle = "Build your own computer";
        reviewTitle = "Best product";
        reviewText = "This is one of best product I have ever seen";
        rating = "Not good";

        startTest(method.getName(), "TC_03_Add_Product_Reviews - Start Test");
        getTest().log(Status.INFO, "TC_03_Add_Product_Reviews - Step 01: Click to top menu = " + topMenuSubList);
        myAccountPage.clickToTopMenuSubList(driver, topMenu, topMenuSubList);
        desktopsPage = UserPageGeneratorManager.getUserPageGeneratorManager().getDesktopsPage(driver);

        getTest().log(Status.INFO, "TC_03_Add_Product_Reviews - Step 02: Click to product title = " + productTitle);
        productDetailsPage =  desktopsPage.clickToProductTitle(driver, productTitle);

        getTest().log(Status.INFO, "TC_03_Add_Product_Reviews - Step 03: Click to 'Add your review' link");
        productReviewsPage = productDetailsPage.clickToAddReviewLink(driver);

        getTest().log(Status.INFO, "TC_03_Add_Product_Reviews - Step 04: Enter review title = " + reviewTitle);
        productReviewsPage.inputToReviewTitleTextbox(driver, reviewTitle);

        getTest().log(Status.INFO, "TC_03_Add_Product_Reviews - Step 05: Enter review text = " + reviewText);
        productReviewsPage.inputToReviewTextTextarea(driver, reviewText);

        getTest().log(Status.INFO, "TC_03_Add_Product_Reviews - Step 05: Click to rating = " + rating);
        productReviewsPage.clickToRatingRadioButton(driver, rating);

        getTest().log(Status.INFO, "TC_03_Add_Product_Reviews - Step 06: Click to submit review button");
        productReviewsPage.clickToSubmitReviewButton(driver);

        getTest().log(Status.INFO, "TC_03_Add_Product_Reviews - Step 07: Verify that product reviews is submitted successfully");
        productReviewsPage.isResultMessageDisplayed(driver, "Product review is successfully added");

        getTest().log(Status.INFO, "TC_03_Add_Product_Reviews - Step 08: Click to My Account Header link");
        productReviewsPage.clickToDynamicHeaderLink(driver, myAccountHeaderLink);
        myAccountPage = UserPageGeneratorManager.getUserPageGeneratorManager().getMyAccountPage(driver);

        getTest().log(Status.INFO, "TC_03_Add_Product_Reviews - Step 09: Click to My Account Header link");
        myAccountPage.clickToDynamicBlockAccountNavigation(driver, myProductReviewNavigation);
        myProductReviewsPage = UserPageGeneratorManager.getUserPageGeneratorManager().getMyProductReviewsPage(driver);

        getTest().log(Status.INFO, "TC_03_Add_Product_Reviews - Step 10: Verify that review title = " + reviewTitle);
        Assert.assertEquals(myProductReviewsPage.getProductReviewTitle(driver), reviewTitle);

        getTest().log(Status.INFO, "TC_03_Add_Product_Reviews - Step 11: Verify that review text = " + reviewText);
        Assert.assertEquals(myProductReviewsPage.getProductReviewText(driver), reviewText);

        getTest().log(Status.INFO, "TC_03_Add_Product_Reviews - Step 11: Verify that rating = " + rating);
        Assert.assertEquals(myProductReviewsPage.getProductRating(driver), ratings.get(rating).intValue());
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        closeBrowserAndKillProcess();
    }
}
