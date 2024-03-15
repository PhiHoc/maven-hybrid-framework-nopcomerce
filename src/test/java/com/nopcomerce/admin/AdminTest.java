package com.nopcomerce.admin;

import com.nopcomerce.data.AdminData;
import com.nopcomerce.data.UserData;
import com.nopcomerce.pageObjects.admin.AdminDashboardPO;
import com.nopcomerce.pageObjects.admin.AdminLoginPO;
import com.nopcomerce.pageObjects.admin.CatalogPO;
import com.nopcomerce.pageObjects.admin.CustomersPO;
import commons.BaseTest;
import commons.PageGeneratorManager;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utilities.DataHelper;

public class AdminTest extends BaseTest {
    @Parameters({"browser", "env"})
    @BeforeClass(alwaysRun = true)
    public void beforeClass(String browserName, String envName) {
        productName = "Lenovo IdeaCentre 600 All-in-One PC";
        productSku = "LE_IC_600";
        productPrice = "500";
        productQuantity = "10000";
        dataHelper = DataHelper.getDataHelper();
        email = dataHelper.getEmail();

        driver = getBrowserDriver(browserName, envName);
        adminLoginPO = PageGeneratorManager.getAdminLoginPage(driver);

        log.info("Precondition - Step 01: Enter to 'Email' textbox with value: '" + AdminData.EMAIL + "'");
        adminLoginPO.enterToEmailTextbox(AdminData.EMAIL);

        log.info("Precondition - Step 02: Enter to 'Password' textbox with value: '" + AdminData.PASSWORD + "'");
        adminLoginPO.enterToPasswordTextbox(AdminData.PASSWORD);

        log.info("Precondition - Step 03: Click to 'Login' button");
        adminDashboardPO = adminLoginPO.clickToLoginButton();

        log.info("Precondition - Step 04: Verify Login success");
        Assert.assertTrue(adminDashboardPO.isLogoutLinkDisplayed());
    }

    @Description("Search with Product name")
    @Test(groups = "product")
    public void Admin_01_Search_With_Product_Name() {
        log.info("Admin 01 - Step 01: Click to open 'Catalog' link at side bar");
        adminDashboardPO.clickToSideBarLinkByName("Catalog");

        log.info("Admin 01 - Step 02: Click to open 'Products' link at side bar");
        adminDashboardPO.clickToSideBarSubLinkByName(" Products");
        catalogPO = PageGeneratorManager.getCatalogPage(driver);

        log.info("Admin 01 - Step 03: Click to close 'Catalog' link at side bar");
        catalogPO.clickToSideBarLinkByName("Catalog");

        log.info("Admin 01 - Step 04: Enter to 'Product name' textbox with value: '" + productName + "'");
        catalogPO.enterToTextboxByLabel("Product name", productName);

        log.info("Admin 01 - Step 05: Click to 'Search' button");
        catalogPO.clickToSearchProductButton();

        log.info("Admin 01 - Step 06: Wait for 'Ajax loading' icon undisplayed");
        catalogPO.waitForAjaxLoadingIconUndisplayed();

        log.info("Admin 01 - Step 07: Verify product's name");
        Assert.assertEquals(catalogPO.getTableDataByRowIndexAndColumnName("1", "Product name"), productName);

        log.info("Admin 01 - Step 08: Verify product's SKU");
        Assert.assertEquals(catalogPO.getTableDataByRowIndexAndColumnName("1", "SKU"), productSku);

        log.info("Admin 01 - Step 09: Verify product's Price");
        Assert.assertEquals(catalogPO.getTableDataByRowIndexAndColumnName("1", "Price"), productPrice);

        log.info("Admin 01 - Step 10: Verify product's Stock quantity");
        Assert.assertEquals(catalogPO.getTableDataByRowIndexAndColumnName("1", "Stock quantity"), productQuantity);
    }

    @Description("Search with Product name and Category")
    @Test(groups = "product")
    public void Admin_02_Search_With_Product_Name_And_Category() {
        log.info("Admin 02 - Step 01: Click to open 'Catalog' link at side bar");
        catalogPO.clickToSideBarLinkByName("Catalog");

        log.info("Admin 02 - Step 02: Click to open 'Products' link at side bar");
        catalogPO.clickToSideBarSubLinkByName(" Products");

        log.info("Admin 02 - Step 03: Click to close 'Catalog' link at side bar");
        catalogPO.clickToSideBarLinkByName("Catalog");

        log.info("Admin 02 - Step 04: Enter to 'Product name' textbox with value: '" + productName + "'");
        catalogPO.enterToTextboxByLabel("Product name", productName);

        log.info("Admin 02 - Step 05: Select to 'Category' dropdown with value: 'Computers'");
        catalogPO.selectToDropdownByLabel("Category", "Computers");

        log.info("Admin 02 - Step 06: Click to 'Search' button");
        catalogPO.clickToSearchProductButton();

        log.info("Admin 02 - Step 07: Wait for 'Ajax loading' icon undisplayed");
        catalogPO.waitForAjaxLoadingIconUndisplayed();

        log.info("Admin 03 - Step 08: Verify 'No data available' message");
        Assert.assertEquals(catalogPO.getRowDataByIndex("1"), "No data available in table");
    }

    @Description("Search with Product name, Category and Subcategory ")
    @Test(groups = "product")
    public void Admin_03_Search_With_Product_Name_And_Category_And_Subcategory() {
        log.info("Admin 03 - Step 01: Click to open 'Catalog' link at side bar");
        catalogPO.clickToSideBarLinkByName("Catalog");

        log.info("Admin 03 - Step 02: Click to open 'Products' link at side bar");
        catalogPO.clickToSideBarSubLinkByName(" Products");

        log.info("Admin 03 - Step 03: Click to close 'Catalog' link at side bar");
        catalogPO.clickToSideBarLinkByName("Catalog");

        log.info("Admin 03 - Step 04: Enter to 'Product name' textbox with value: '" + productName + "'");
        catalogPO.enterToTextboxByLabel("Product name", productName);

        log.info("Admin 03 - Step 05: Select to 'Category' dropdown with value: 'Computers'");
        catalogPO.selectToDropdownByLabel("Category", "Computers");

        log.info("Admin 03 - Step 06: Check to 'Search subcategories' checkbox ");
        catalogPO.checkToSearchSubcategoryCheckbox();

        log.info("Admin 03 - Step 07: Click to 'Search' button");
        catalogPO.clickToSearchProductButton();

        log.info("Admin 03 - Step 08: Wait for 'Ajax loading' icon undisplayed");
        catalogPO.waitForAjaxLoadingIconUndisplayed();

        log.info("Admin 03 - Step 09: Verify product's name");
        Assert.assertEquals(catalogPO.getTableDataByRowIndexAndColumnName("1", "Product name"), productName);

        log.info("Admin 03 - Step 10: Verify product's SKU");
        Assert.assertEquals(catalogPO.getTableDataByRowIndexAndColumnName("1", "SKU"), productSku);

        log.info("Admin 03 - Step 11: Verify product's Price");
        Assert.assertEquals(catalogPO.getTableDataByRowIndexAndColumnName("1", "Price"), productPrice);

        log.info("Admin 03 - Step 12: Verify product's Stock quantity");
        Assert.assertEquals(catalogPO.getTableDataByRowIndexAndColumnName("1", "Stock quantity"), productQuantity);
    }

    @Description("Search with Product name and child Category")
    @Test(groups = "product")
    public void Admin_04_Search_With_Product_Name_And_Child_Category() {
        log.info("Admin 04- Step 01: Click to open 'Catalog' link at side bar");
        catalogPO.clickToSideBarLinkByName("Catalog");

        log.info("Admin 04- Step 02: Click to open 'Products' link at side bar");
        catalogPO.clickToSideBarSubLinkByName(" Products");

        log.info("Admin 04- Step 03: Click to close 'Catalog' link at side bar");
        catalogPO.clickToSideBarLinkByName("Catalog");

        log.info("Admin 04- Step 04: Enter to 'Product name' textbox with value: '" + productName + "'");
        catalogPO.enterToTextboxByLabel("Product name", productName);

        log.info("Admin 04- Step 05: Select to 'Category' dropdown with value: 'Computers >> Desktops'");
        catalogPO.selectToDropdownByLabel("Category", "Computers >> Desktops");

        log.info("Admin 04- Step 06: UnCheck to 'Search subcategories' checkbox ");
        catalogPO.uncheckToSearchSubcategoryCheckbox();

        log.info("Admin 04- Step 07: Click to 'Search' button");
        catalogPO.clickToSearchProductButton();

        log.info("Admin 04- Step 08: Wait for 'Ajax loading' icon undisplayed");
        catalogPO.waitForAjaxLoadingIconUndisplayed();

        log.info("Admin 04 - Step 09: Verify product's name");
        Assert.assertEquals(catalogPO.getTableDataByRowIndexAndColumnName("1", "Product name"), productName);

        log.info("Admin 04 - Step 10: Verify product's SKU");
        Assert.assertEquals(catalogPO.getTableDataByRowIndexAndColumnName("1", "SKU"), productSku);

        log.info("Admin 04 - Step 11: Verify product's Price");
        Assert.assertEquals(catalogPO.getTableDataByRowIndexAndColumnName("1", "Price"), productPrice);

        log.info("Admin 04 - Step 12: Verify product's Stock quantity");
        Assert.assertEquals(catalogPO.getTableDataByRowIndexAndColumnName("1", "Stock quantity"), productQuantity);
    }

    @Description("Search with Product name and manufacturer")
    @Test(groups = "product")
    public void Admin_05_Search_With_Product_Name_And_Manufacturer() {
        log.info("Admin 05 - Step 01: Click to open 'Catalog' link at side bar");
        catalogPO.clickToSideBarLinkByName("Catalog");

        log.info("Admin 05 - Step 02: Click to open 'Products' link at side bar");
        catalogPO.clickToSideBarSubLinkByName(" Products");

        log.info("Admin 05 - Step 03: Click to close 'Catalog' link at side bar");
        catalogPO.clickToSideBarLinkByName("Catalog");

        log.info("Admin 05 - Step 04: Enter to 'Product name' textbox with value: '" + productName + "'");
        catalogPO.enterToTextboxByLabel("Product name", productName);

        log.info("Admin 05 - Step 05: Select to 'Category' dropdown with value: 'All'");
        catalogPO.selectToDropdownByLabel("Category", "All");

        log.info("Admin 05 - Step 06: Select to 'Manufacturer' dropdown with value: 'Apple'");
        catalogPO.selectToDropdownByLabel("Manufacturer", "Apple");

        log.info("Admin 05 - Step 07: UnCheck to 'Search subcategories' checkbox ");
        catalogPO.uncheckToSearchSubcategoryCheckbox();

        log.info("Admin 05 - Step 08: Click to 'Search' button");
        catalogPO.clickToSearchProductButton();

        log.info("Admin 05 - Step 09: Wait for 'Ajax loading' icon undisplayed");
        catalogPO.waitForAjaxLoadingIconUndisplayed();

        log.info("Admin 04 - Step 10: Verify 'No data available' message");
        Assert.assertEquals(catalogPO.getRowDataByIndex("1"), "No data available in table");
    }

    @Description("Go directly to product SKU")
    @Test(groups = "product")
    public void Admin_06_Go_Directly_To_Product_SKU() {
        log.info("Admin 06 - Step 01: Click to open 'Catalog' link at side bar");
        catalogPO.clickToSideBarLinkByName("Catalog");

        log.info("Admin 06 - Step 02: Click to open 'Products' link at side bar");
        catalogPO.clickToSideBarSubLinkByName(" Products");

        log.info("Admin 06 - Step 03: Click to close 'Catalog' link at side bar");
        catalogPO.clickToSideBarLinkByName("Catalog");

        log.info("Admin 06 - Step 04: Enter to 'Go directly to product SKU' textbox with value: '" + productSku + "'");
        catalogPO.enterToTextboxByLabel("Go directly to product SKU", productSku);

        log.info("Admin 06 - Step 05: Click to 'Go' button at 'SKU' textbox");
        catalogPO.clickToSkuGoButon();

        log.info("Admin 06 - Step 06: Wait for 'Ajax loading' icon undisplayed");
        catalogPO.waitForAjaxLoadingIconUndisplayed();

        log.info("Admin 06 - Step 07: Verify current page is 'Product details' page");
        Assert.assertTrue(catalogPO.getPageHeader().contains("Edit product details - " + productName));

        log.info("Admin 06 - Step 08: Verify product name at 'Product name' textbox");
        Assert.assertEquals(catalogPO.getTextboxAttributeValueByLabel("Product name", "value"), productName);

        log.info("Admin 06 - Step 09: Click to 'Dashboard' link");
        adminDashboardPO = catalogPO.clickToDashboardLink();
    }

    @Description("Create New customer")
    @Test(groups = "customer")
    public void Admin_07_Create_New_Customer() {
        log.info("Admin 07 - Step 01: Click to open 'Customers' link at side bar");
        adminDashboardPO.clickToSideBarLinkByName("Customers");

        log.info("Admin 07 - Step 02: Click to open 'Customers' sub link at side bar");
        adminDashboardPO.clickToSideBarSubLinkByName(" Customers");
        customersPO = PageGeneratorManager.getCustomersPage(driver);

        log.info("Admin 07 - Step 04: Click to 'Add new' button");
        adminDashboardPO.clickToAddNewButton();

        log.info("Admin 07 - Step 05: Enter to 'Email' textbox with value: '" + email + "'");
        adminDashboardPO.enterToTextboxByLabel("Email", email);

        log.info("Admin 07 - Step 06: Enter to 'Password' textbox with value: '" + UserData.PASSWORD + "'");
        adminDashboardPO.enterToTextboxByLabel("Password", UserData.PASSWORD);

        log.info("Admin 07 - Step 07: Enter to 'First name' textbox with value: '" + UserData.FIRST_NAME + "'");
        adminDashboardPO.enterToTextboxByLabel("First name", UserData.FIRST_NAME);

        log.info("Admin 07 - Step 08: Enter to 'Last name' textbox with value: '" + UserData.LAST_NAME + "'");
        adminDashboardPO.enterToTextboxByLabel("Last name", UserData.LAST_NAME);

        log.info("Admin 07 - Step 09: Enter to 'Date of birth' textbox with value: '" + UserData.DATE_OF_BIRTH + "'");
        adminDashboardPO.enterToTextboxByLabel("Date of birth", UserData.DATE_OF_BIRTH);

        log.info("Admin 07 - Step 10: Enter to 'Company' textbox with value: '" + UserData.COMPANY_NAME + "'");
        adminDashboardPO.enterToTextboxByLabel("Company name", UserData.COMPANY_NAME);

        log.info("Admin 07 - Step 11: Enter to 'Admin comment' textbox");
        adminDashboardPO.enterToTextAreaByLabel("Admin comment", "Add new customer (Guest)");

        log.info("Admin 07 - Step 12: Check to 'Male' radio");
        adminDashboardPO.checkToMaleRadio();

        log.info("Admin 07 - Step 13: Check to 'Active' checkbox");
        adminDashboardPO.checkToActiveCheckbox();

        log.info("Admin 07 - Step 14: Delete all role in 'Customer role' dropdown");
        adminDashboardPO.deleteAllRoleInCustomerRoleDropdown();

        log.info("Admin 07 - Step 15: Select to 'Customer role' dropdown with value 'Guests'");
        adminDashboardPO.selectToCustomerRoleDropdown("Guests");

        log.info("Admin 07 - Step 16: Click to 'Save And Continue' button");
        adminDashboardPO.clickToSaveAndContinueButton();

        log.info("Admin 07 - Step 17: Verify add customer success message");
        Assert.assertTrue(adminDashboardPO.getAddCustomerSuccessMessage().contains("The new customer has been added successfully."));

        log.info("Admin 07 - Step 18: Verify data");
        Assert.assertEquals(adminDashboardPO.getTextboxAttributeValueByLabel("Email", "value"), email);
        Assert.assertEquals(adminDashboardPO.getTextboxAttributeValueByLabel("First name", "value"), UserData.FIRST_NAME);
        Assert.assertEquals(adminDashboardPO.getTextboxAttributeValueByLabel("Last name", "value"), UserData.LAST_NAME);
        Assert.assertTrue(adminDashboardPO.isMaleGenderRadioChecked());
        Assert.assertEquals(adminDashboardPO.getTextboxAttributeValueByLabel("Date of birth", "value"), UserData.DATE_OF_BIRTH);
        Assert.assertEquals(adminDashboardPO.getSelectedValueAtCustomerRole(), "Guests");
        Assert.assertTrue(adminDashboardPO.isActiveCheckboxChecked());
        Assert.assertEquals(adminDashboardPO.getTextAreaTextByLabel("Admin comment"), "Add new customer (Guest)");

        log.info("Admin 07 - Step 19: Click 'Back to Customer List' link");
        adminDashboardPO.clickToBackToCustomerListLink();

        log.info("Admin 07 - Step 20: Delete all role in 'Customer role' dropdown");
        adminDashboardPO.deleteAllRoleInCustomerRoleDropdown();

        log.info("Admin 07 - Step 21: Select to 'Customer role' dropdown with value 'Guests'");
        adminDashboardPO.selectToCustomerRoleDropdown("Guests");

        log.info("Admin 07 - Step 22: Click to 'Search' button");
        adminDashboardPO.clickToSearchCustomerButton();

        log.info("Admin 07 - Step 23: Wait for 'Ajax loading' icon undisplayed");
        adminDashboardPO.waitForAjaxLoadingIconUndisplayed();

        log.info("Admin 07 - Step 24: Verify Customer name appear");
        Assert.assertTrue(adminDashboardPO.getColumnDataByColumnName("Name").contains(UserData.FULL_NAME));

        log.info("Admin 07 - Step 03: Click to close 'Customers' link at side bar");
        adminDashboardPO.clickToSideBarLinkByName("Customers");
    }

    @Description("Search Customer with email")
    @Test(groups = "customer")
    public void Admin_08_Search_Customer_With_Email() {
        log.info("Admin 08 - Step 01: Click to open 'Customers' link at side bar");
        adminDashboardPO.clickToSideBarLinkByName("Customers");

        log.info("Admin 08 - Step 02: Click to open 'Customers' sub link at side bar");
        adminDashboardPO.clickToSideBarSubLinkByName(" Customers");

        log.info("Admin 08 - Step 04: Enter to 'Email' textbox with value: '" + email + "'");
        adminDashboardPO.enterToTextboxByLabel("Email", email);

        log.info("Admin 08 - Step 05: Delete all role in 'Customer role' dropdown");
        adminDashboardPO.deleteAllRoleInCustomerRoleDropdown();

        log.info("Admin 08 - Step 06: Select to 'Customer role' dropdown with value 'Guests'");
        adminDashboardPO.selectToCustomerRoleDropdown("Guests");

        log.info("Admin 08 - Step 07: Click to 'Search' button");
        adminDashboardPO.clickToSearchCustomerButton();

        log.info("Admin 08 - Step 06: Wait for 'Ajax loading' icon undisplayed");
        adminDashboardPO.waitForAjaxLoadingIconUndisplayed();

        log.info("Admin 08 - Step 07: Verify only 1 Customer info appear");
        Assert.assertEquals(adminDashboardPO.getNumberOfCustomerInCustomerTable(), 1);

        log.info("Admin 08 - Step 08: Verify Customer name appear");
        Assert.assertEquals(adminDashboardPO.getTableDataByRowIndexAndColumnName("1", "Name"), UserData.FULL_NAME);

        log.info("Admin 08 - Step 03: Click to close 'Customers' link at side bar");
        adminDashboardPO.clickToSideBarLinkByName("Customers");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }

    private WebDriver driver;
    private AdminLoginPO adminLoginPO;
    private AdminDashboardPO adminDashboardPO;
    private String productName, productSku, productPrice, productQuantity, email;
    private DataHelper dataHelper;
    private CatalogPO catalogPO;
    private CustomersPO customersPO;
}
