package com.nopcomerce.admin;

import com.nopcomerce.data.AdminData;
import com.nopcomerce.pageObjects.admin.AdminDashboardPO;
import com.nopcomerce.pageObjects.admin.AdminLoginPO;
import com.nopcomerce.pageObjects.admin.CatalogPO;
import commons.BaseTest;
import commons.PageGeneratorManager;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.DataHelper;

public class Admin_01_ProductTest extends BaseTest {
    @Parameters({"browser", "role"})
    @BeforeClass(alwaysRun = true)
    public void beforeClass(String browserName, String role) {
        productName = "Lenovo IdeaCentre 600 All-in-One PC";
        productSku = "LE_IC_600";
        productPrice = "500";
        productQuantity = "10000";
        adminComment = "Add new customer (Guest)";
        dataHelper = DataHelper.getDataHelper();
        email = dataHelper.getEmail();

        driver = getBrowserDriver(browserName, role);
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
        adminDashboardPO.clickToSideBarSubLinkByName("Products");
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
        catalogPO.clickToSideBarLinkByName(" Products");

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
        catalogPO.clickToSideBarSubLinkByName("Products");

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
        catalogPO.clickToSideBarSubLinkByName("Products");

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
        catalogPO.clickToSideBarSubLinkByName("Products");

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
        catalogPO.clickToSideBarSubLinkByName("Products");

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

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }

    private WebDriver driver;
    private AdminLoginPO adminLoginPO;
    private AdminDashboardPO adminDashboardPO;
    private String productName, productSku, productPrice, productQuantity, email,adminComment;
    private DataHelper dataHelper;
    private CatalogPO catalogPO;
}
