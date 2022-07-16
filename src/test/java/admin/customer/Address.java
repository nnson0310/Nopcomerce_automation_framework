package admin.customer;

import admin.PreCondition_Login;
import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import page.objects.AdminPageGeneratorManager;
import page.objects.admin.*;
import utilities.DataFaker;
import utilities.FunctionHelper;
import java.lang.reflect.Method;

import static report.config.ExtentTestManager.getTest;
import static report.config.ExtentTestManager.startTest;

public class Address extends BaseTest {
    WebDriver driver;

    LoginPage loginPage;
    CustomerListPage customerListPage;
    CustomerEditPage customerEditPage;
    CustomerCreatePage customerCreatePage;
    CustomerAddressCreatePage customerAddressCreatePage;

    String customerEmail;
    String cardFieldName, addressCardTitleFieldName;
    String firstNameFieldName, lastNameFieldName, emailFieldName, cityFieldName, address1FieldName, postalCodeFieldName, phoneNumberFieldName, faxNumberFieldName;
    String backLinkFieldName;

    String firstName, lastName, email, city, address1, postalCode, phoneNumber, faxNumber;

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

        log.info("Pre Condition - Step 01: Navigate to customer list page");
        customerListPage = loginPage.redirectToCustomersListPage(driver, "https://admin-demo.nopcommerce.com/Admin/Customer/List");
        FunctionHelper.sleepInSeconds(1);

        log.info("Pre Condition - Step 02: Click to 'Add New' button");
        customerListPage.clickToAddNewButton(driver);
        customerCreatePage = AdminPageGeneratorManager.getAdminPageGeneratorManager().getCustomerCreatePage(driver);
        FunctionHelper.sleepInSeconds(1);

        //data test
        customerEmail = DataFaker.getDataFaker().generateEmail();
        log.info("Pre Condition - Step 03: Enter customer email = " + customerEmail);
        customerCreatePage.inputToDynamicTextboxByNameAttribute(driver, customerEmail, "Email");

        log.info("Pre Condition - Step 04: Click to 'Save' button");
        customerCreatePage.clickToDynamicButtonByName(driver, "save");
        customerListPage = AdminPageGeneratorManager.getAdminPageGeneratorManager().getCustomerListPage(driver);
        FunctionHelper.sleepInSeconds(1);

        log.info("Pre Condition - Step 05: Click to edit button of customer email = " + customerEmail + " and navigate to edit customer page");
        customerListPage.clickToTableButton(driver, customerEmail, "Edit");
        customerEditPage = AdminPageGeneratorManager.getAdminPageGeneratorManager().getCustomerEditPage(driver);
        FunctionHelper.sleepInSeconds(1);

        //field name
        cardFieldName = "customer-cards";
        addressCardTitleFieldName = "customer-address";
        firstNameFieldName = "Address.FirstName";
        lastNameFieldName = "Address.LastName";
        emailFieldName = "Address.Email";
        address1FieldName = "Address.Address1";
        cityFieldName = "Address.City";
        postalCodeFieldName = "Address.ZipPostalCode";
        phoneNumberFieldName = "Address.PhoneNumber";
        faxNumberFieldName = "Address.FaxNumber";
        backLinkFieldName = "back to customer details";

        //data test
        firstName = "maria";
        lastName = "ozawa";
        email = "maria@gmail.com";
        city = "Ha Noi";
        address1 = "12 Tran Binh street";
        postalCode = "118000";
        phoneNumber = "0988766543";
        faxNumber = "009665";
    }


    @Test(description = "Verify that admin can create new address for customer")
    public void TC_01_Create (Method method) {
        startTest(method.getName(), "TC_01_Create - Start test");
        getTest().log(Status.INFO, "TC_01_Create - Step 01: Click to 'Addresses' card title");
        customerEditPage.clickToAddressesCardTitle(driver, cardFieldName, addressCardTitleFieldName);

        getTest().log(Status.INFO, "TC_01_Create - Step 02: Click to 'Add new address' card title");
        customerAddressCreatePage = customerEditPage.clickToAddNewAddressButton(driver);
        FunctionHelper.sleepInSeconds(1);

        getTest().log(Status.INFO, "TC_01_Create - Step 03: Enter first name = " + firstName);
        customerAddressCreatePage.inputToDynamicTextboxByNameAttribute(driver, firstName, firstNameFieldName);

        getTest().log(Status.INFO, "TC_01_Create - Step 04: Enter last name = " + lastName);
        customerAddressCreatePage.inputToDynamicTextboxByNameAttribute(driver, lastName, lastNameFieldName);

        getTest().log(Status.INFO, "TC_01_Create - Step 05: Enter email = " + email);
        customerAddressCreatePage.inputToDynamicTextboxByNameAttribute(driver, email, emailFieldName);

        getTest().log(Status.INFO, "TC_01_Create - Step 06: Enter city = " + city);
        customerAddressCreatePage.inputToDynamicTextboxByNameAttribute(driver, city, cityFieldName);

        getTest().log(Status.INFO, "TC_01_Create - Step 07: Enter address1 = " + address1);
        customerAddressCreatePage.inputToDynamicTextboxByNameAttribute(driver, address1, address1FieldName);

        getTest().log(Status.INFO, "TC_01_Create - Step 08: Enter postalCode = " + postalCode);
        customerAddressCreatePage.inputToDynamicTextboxByNameAttribute(driver, postalCode, postalCodeFieldName);

        getTest().log(Status.INFO, "TC_01_Create - Step 09: Enter phoneNumber = " + phoneNumber);
        customerAddressCreatePage.inputToDynamicTextboxByNameAttribute(driver, phoneNumber, phoneNumberFieldName);

        getTest().log(Status.INFO, "TC_01_Create - Step 10: Enter phoneNumber = " + phoneNumber);
        customerAddressCreatePage.inputToDynamicTextboxByNameAttribute(driver, phoneNumber, phoneNumberFieldName);

        getTest().log(Status.INFO, "TC_01_Create - Step 11: Enter faxNumber = " + faxNumber);
        customerAddressCreatePage.inputToDynamicTextboxByNameAttribute(driver, faxNumber, faxNumberFieldName);

        getTest().log(Status.INFO, "TC_01_Create - Step 12: Click to 'save' button");
        customerAddressCreatePage.clickToSaveButton(driver);

        getTest().log(Status.INFO, "TC_01_Create - Step 13: Verify that success alert message 'The new address has been added successfully' is displayed");
        Assert.assertTrue(customerAddressCreatePage.isSuccessAlertDisplayed(driver, "The new address has been added successfully."));

        getTest().log(Status.INFO, "TC_01_Create - Step 12: Click to close alert button");
        customerAddressCreatePage.clickToAlertCloseButton(driver);

        getTest().log(Status.INFO, "TC_01_Create - Step 16: Click to " + backLinkFieldName + " button");
        customerAddressCreatePage.clickToBackLink(driver, backLinkFieldName);
        customerListPage = AdminPageGeneratorManager.getAdminPageGeneratorManager().getCustomerListPage(driver);

        getTest().log(Status.INFO, "TC_01_Create - Step 17: Verify that new address is created successfully");
        String[] newAddress = new String[6];
        newAddress[0] = firstName;
        newAddress[1] = lastName;
        newAddress[2] = email;
        newAddress[3] = phoneNumber;
        newAddress[4] = faxNumber;
        newAddress[5] = address1 + "\n" + city + "," + postalCode;
        Assert.assertTrue(customerListPage.isAddressDisplayedCorrectly(driver, newAddress));

    }

    @Test(description = "Verify that admin can delete address")
    public void TC_02_Delete (Method method) {
        startTest(method.getName(), "TC_02_Delete - Start test");
        getTest().log(Status.INFO, "TC_02_Delete - Step 01: Click to Delete Address button");
        customerListPage.clickToTableButton(driver, firstName, "Delete");

        getTest().log(Status.INFO, "TC_02_Delete - Step 02: Click to accept delete");
        customerListPage.clickToPopupDeleteButton(driver);

        getTest().log(Status.INFO, "TC_02_Delete - Step 03: Verify that new address has been deleted");
        Assert.assertTrue(customerListPage.isNoDataInTableMessageDisplayed(driver, "customer-addresses-grid"));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        closeBrowserAndKillProcess();
    }
}
