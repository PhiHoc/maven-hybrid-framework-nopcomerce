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
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.DataHelper;

import java.awt.desktop.UserSessionEvent;

public class Admin_02_CustomerTest extends BaseTest {
    @Parameters({"browser", "env"})
    @BeforeClass(alwaysRun = true)
    public void beforeClass(String browserName, String envName) {
        dataHelper = DataHelper.getDataHelper();
        customerEmail = dataHelper.getEmail();
        addressEmail = dataHelper.getEmail();

        adminComment = "Add new customer (Guest)";
        editCustomerEmail = "edit_" + customerEmail;
        editAddressEmail = "edit_" + addressEmail;
        editFirstName = "edit_" + UserData.FIRST_NAME;
        editLastName = "edit_" + UserData.LAST_NAME;
        editCompanyName = "edit_" + UserData.COMPANY_NAME;
        editAdminComment = "edit_" + adminComment;
        editFullname = editFirstName + " " + editLastName;
        editDob = "2/2/1999";

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

    @Description("Create New customer")
    @Test(groups = {"address"})
    public void Customer_01_Create_New_Customer() {
        log.info("Customer 01 - Step 01: Click to open 'Customers' link at side bar");
        adminDashboardPO.clickToSideBarLinkByName("Customers");

        log.info("Customer 01 - Step 02: Click to open 'Customers' sub link at side bar");
        adminDashboardPO.clickToSideBarSubLinkByName(" Customers");
        customersPO = PageGeneratorManager.getCustomersPage(driver);

        log.info("Customer 01 - Step 04: Click to 'Add new' button");
        customersPO.clickToAddNewButton();

        log.info("Customer 01 - Step 05: Enter data to 'Customer' form textboxes");
        customersPO.enterDataToCustomerFormTextboxes(customerEmail, UserData.PASSWORD, UserData.FIRST_NAME,
                UserData.LAST_NAME, UserData.DATE_OF_BIRTH, UserData.COMPANY_NAME, adminComment);

        log.info("Customer 01 - Step 06: Check to 'Male' radio");
        customersPO.checkToMaleRadio();

        log.info("Customer 01 - Step 07: Check to 'Active' checkbox");
        customersPO.checkToActiveCheckbox();

        log.info("Customer 01 - Step 08: Delete all role in 'Customer role' dropdown");
        customersPO.deleteAllRoleInCustomerRoleDropdown();

        log.info("Customer 01 - Step 09: Select to 'Customer role' dropdown with value 'Guests'");
        customersPO.selectToCustomerRoleDropdown("Guests");

        log.info("Customer 01 - Step 10: Click to 'Save And Continue' button");
        customersPO.clickToSaveAndContinueButton();

        log.info("Customer 01 - Step 11: Verify add customer success message");
        Assert.assertTrue(customersPO.getAddCustomerSuccessMessage().contains("The new customer has been added successfully."));

        log.info("Customer 01 - Step 12: Verify data");
        Assert.assertEquals(customersPO.getTextboxAttributeValueByLabel("Email", "value"), customerEmail);
        Assert.assertEquals(customersPO.getTextboxAttributeValueByLabel("First name", "value"), UserData.FIRST_NAME);
        Assert.assertEquals(customersPO.getTextboxAttributeValueByLabel("Last name", "value"), UserData.LAST_NAME);
        Assert.assertTrue(customersPO.isMaleGenderRadioChecked());
        Assert.assertEquals(customersPO.getTextboxAttributeValueByLabel("Date of birth", "value"), UserData.DATE_OF_BIRTH);
        Assert.assertEquals(customersPO.getSelectedValueAtCustomerRole(), "Guests");
        Assert.assertTrue(customersPO.isActiveCheckboxChecked());
        Assert.assertEquals(customersPO.getTextAreaTextByLabel("Admin comment"), adminComment);

        log.info("Customer 01 - Step 13: Click 'Back to Customer List' link");
        customersPO.clickToBackToCustomerListLink();

        log.info("Customer 01 - Step 14: Delete all role in 'Customer role' dropdown");
        customersPO.deleteAllRoleInCustomerRoleDropdown();

        log.info("Customer 01 - Step 15: Select to 'Customer role' dropdown with value 'Guests'");
        customersPO.selectToCustomerRoleDropdown("Guests");

        log.info("Customer 01 - Step 16: Click to 'Search' button");
        customersPO.clickToSearchCustomerButton();

        log.info("Customer 01 - Step 17: Wait for 'Ajax loading' icon undisplayed");
        customersPO.waitForAjaxLoadingIconUndisplayed();

        log.info("Customer 01 - Step 18: Verify Customer name appear");
        Assert.assertTrue(customersPO.getColumnDataByColumnName("Name").contains(UserData.FULL_NAME));

        log.info("Customer 01 - Step 19: Click to close 'Customers' link at side bar");
        customersPO.clickToSideBarLinkByName("Customers");
    }

    @Description("Search Customer with email")
    public void Customer_02_Search_Customer_With_Email() {
        log.info("Customer 02 - Step 01: Click to open 'Customers' link at side bar");
        customersPO.clickToSideBarLinkByName("Customers");

        log.info("Customer 02 - Step 02: Click to open 'Customers' sub link at side bar");
        customersPO.clickToSideBarSubLinkByName(" Customers");

        log.info("Customer 02 - Step 03: Enter to 'Email' textbox with value: '" + customerEmail + "'");
        customersPO.enterToTextboxByLabel("Email", customerEmail);

        log.info("Customer 02 - Step 04: Delete all role in 'Customer role' dropdown");
        customersPO.deleteAllRoleInCustomerRoleDropdown();

        log.info("Customer 02 - Step 05: Select to 'Customer role' dropdown with value 'Guests'");
        customersPO.selectToCustomerRoleDropdown("Guests");

        log.info("Customer 02 - Step 06: Click to 'Search' button");
        customersPO.clickToSearchCustomerButton();

        log.info("Customer 02 - Step 07: Wait for 'Ajax loading' icon undisplayed");
        customersPO.waitForAjaxLoadingIconUndisplayed();

        log.info("Customer 02 - Step 08: Verify only 1 Customer info appear");
        Assert.assertEquals(customersPO.getNumberOfCustomerInCustomerTable(), 1);

        log.info("Customer 02 - Step 09: Verify Customer name appear");
        Assert.assertEquals(customersPO.getTableDataByRowIndexAndColumnName("1", "Name"), UserData.FULL_NAME);

        log.info("Customer 02 - Step 10: Click to close 'Customers' link at side bar");
        customersPO.clickToSideBarLinkByName("Customers");
    }

    @Description("Search Customer with first name and last name")
    public void Customer_03_Search_Customer_With_First_Name_And_Last_Name() {
        log.info("Customer 03 - Step 01: Click to open 'Customers' link at side bar");
        customersPO.clickToSideBarLinkByName("Customers");

        log.info("Customer 03 - Step 02: Click to open 'Customers' sub link at side bar");
        customersPO.clickToSideBarSubLinkByName(" Customers");

        log.info("Customer 03 - Step 03: Enter to 'First name' textbox with value: '" + UserData.FIRST_NAME + "'");
        customersPO.enterToTextboxByLabel("First name", UserData.FIRST_NAME);

        log.info("Customer 03 - Step 04: Enter to 'Last name' textbox with value: '" + UserData.LAST_NAME + "'");
        customersPO.enterToTextboxByLabel("Last name", UserData.LAST_NAME);

        log.info("Customer 03 - Step 05: Delete all role in 'Customer role' dropdown");
        customersPO.deleteAllRoleInCustomerRoleDropdown();

        log.info("Customer 03 - Step 06: Select to 'Customer role' dropdown with value 'Guests'");
        customersPO.selectToCustomerRoleDropdown("Guests");

        log.info("Customer 03 - Step 07: Click to 'Search' button");
        customersPO.clickToSearchCustomerButton();

        log.info("Customer 03 - Step 08: Wait for 'Ajax loading' icon undisplayed");
        customersPO.waitForAjaxLoadingIconUndisplayed();

        log.info("Customer 03 - Step 09: Verify Customer name appear");
        Assert.assertEquals(customersPO.getTableDataByRowIndexAndColumnName("1", "Name"), UserData.FULL_NAME);

        log.info("Customer 03 - Step 10: Click to close 'Customers' link at side bar");
        customersPO.clickToSideBarLinkByName("Customers");
    }

    @Description("Search Customer with company name")
    public void Customer_04_Search_Customer_With_Company_Name() {
        log.info("Customer 04 - Step 01: Click to open 'Customers' link at side bar");
        customersPO.clickToSideBarLinkByName("Customers");

        log.info("Customer 04 - Step 02: Click to open 'Customers' sub link at side bar");
        customersPO.clickToSideBarSubLinkByName(" Customers");

        log.info("Customer 04 - Step 03: Enter to 'Company' textbox with value: '" + UserData.COMPANY_NAME + "'");
        customersPO.enterToTextboxByLabel("Company", UserData.COMPANY_NAME);

        log.info("Customer 04 - Step 04: Delete all role in 'Customer role' dropdown");
        customersPO.deleteAllRoleInCustomerRoleDropdown();

        log.info("Customer 04 - Step 05: Select to 'Customer role' dropdown with value 'Guests'");
        customersPO.selectToCustomerRoleDropdown("Guests");

        log.info("Customer 04 - Step 06: Click to 'Search' button");
        customersPO.clickToSearchCustomerButton();

        log.info("Customer 04 - Step 07: Wait for 'Ajax loading' icon undisplayed");
        customersPO.waitForAjaxLoadingIconUndisplayed();

        log.info("Customer 04 - Step 08: Verify Customer name appear");
        Assert.assertEquals(customersPO.getTableDataByRowIndexAndColumnName("1", "Name"), UserData.FULL_NAME);

        log.info("Customer 04 - Step 09: Click to close 'Customers' link at side bar");
        customersPO.clickToSideBarLinkByName("Customers");
    }

    @Description("Search Customer with full data")
    public void Customer_05_Search_Customer_With_Full_Data() {
        log.info("Customer 05 - Step 01: Click to open 'Customers' link at side bar");
        customersPO.clickToSideBarLinkByName("Customers");

        log.info("Customer 05 - Step 02: Click to open 'Customers' sub link at side bar");
        customersPO.clickToSideBarSubLinkByName(" Customers");

        log.info("Customer 05 - Step 03: Enter to 'Email' textbox with value: '" + customerEmail + "'");
        customersPO.enterToTextboxByLabel("Email", customerEmail);

        log.info("Customer 05 - Step 04: Enter to 'First name' textbox with value: '" + UserData.FIRST_NAME + "'");
        customersPO.enterToTextboxByLabel("First name", UserData.FIRST_NAME);

        log.info("Customer 05 - Step 05: Enter to 'Last name' textbox with value: '" + UserData.LAST_NAME + "'");
        customersPO.enterToTextboxByLabel("Last name", UserData.LAST_NAME);

        log.info("Customer 05 - Step 06: Enter to 'Company' textbox with value: '" + UserData.COMPANY_NAME + "'");
        customersPO.enterToTextboxByLabel("Company", UserData.COMPANY_NAME);

        log.info("Customer 05 - Step 07: Enter to 'Company' textbox with value: '" + UserData.COMPANY_NAME + "'");
        customersPO.enterToTextboxByLabel("Company", UserData.COMPANY_NAME);

        log.info("Customer 05 - Step 08: Delete all role in 'Customer role' dropdown");
        customersPO.deleteAllRoleInCustomerRoleDropdown();

        log.info("Customer 05 - Step 09: Select to 'Customer role' dropdown with value 'Guests'");
        customersPO.selectToCustomerRoleDropdown("Guests");

        log.info("Customer 05 - Step 10: Click to 'Search' button");
        customersPO.clickToSearchCustomerButton();

        log.info("Customer 05 - Step 11: Wait for 'Ajax loading' icon undisplayed");
        customersPO.waitForAjaxLoadingIconUndisplayed();

        log.info("Customer 05 - Step 12: Verify Customer name appear");
        Assert.assertEquals(customersPO.getTableDataByRowIndexAndColumnName("1", "Name"), UserData.FULL_NAME);

        log.info("Customer 05 - Step 13: Click to close 'Customers' link at side bar");
        customersPO.clickToSideBarLinkByName("Customers");
    }

    @Description("Edit customer")
    @Test(groups = {"address"})
    public void Customer_06_Edit_Customer() {
        log.info("Customer 06 - Step 01: Click to open 'Customers' link at side bar");
        customersPO.clickToSideBarLinkByName("Customers");

        log.info("Customer 06 - Step 02: Click to open 'Customers' sub link at side bar");
        customersPO.clickToSideBarSubLinkByName(" Customers");

        log.info("Customer 06 - Step 03: Enter to 'Email' textbox with value: '" + customerEmail + "'");
        customersPO.enterToTextboxByLabel("Email", customerEmail);

        log.info("Customer 06 - Step 04: Delete all role in 'Customer role' dropdown");
        customersPO.deleteAllRoleInCustomerRoleDropdown();

        log.info("Customer 06 - Step 05: Select to 'Customer role' dropdown with value 'Guests'");
        customersPO.selectToCustomerRoleDropdown("Guests");

        log.info("Customer 06 - Step 06: Click to 'Search' button");
        customersPO.clickToSearchCustomerButton();

        log.info("Customer 06 - Step 07: Wait for 'Ajax loading' icon undisplayed");
        customersPO.waitForAjaxLoadingIconUndisplayed();

        log.info("Customer 06 - Step 08: Click to edit button at row 1");
        customersPO.clickTableButtonAtRowIndexAndColumnName("1", "Edit");

        log.info("Customer 06 - Step 09: Enter data to 'Customer' form textboxes");
        customersPO.enterDataToCustomerFormTextboxes(editCustomerEmail, "", editFirstName,
                editLastName, editDob, editCompanyName, editAdminComment);

        log.info("Customer 06 - Step 10: Click to 'Save' button");
        customersPO.clickToCustomerSaveButton();

        log.info("Customer 06 - Step 11: Verify updated customer success message");
        Assert.assertTrue(customersPO.getAddCustomerSuccessMessage().contains("The customer has been updated successfully."));

        log.info("Customer 06 - Step 12: Enter to 'Email' textbox with value: '" + editCustomerEmail + "'");
        customersPO.enterToTextboxByLabel("Email", editCustomerEmail);

        log.info("Customer 06 - Step 13: Delete all role in 'Customer role' dropdown");
        customersPO.deleteAllRoleInCustomerRoleDropdown();

        log.info("Customer 06 - Step 14: Select to 'Customer role' dropdown with value 'Guests'");
        customersPO.selectToCustomerRoleDropdown("Guests");

        log.info("Customer 06 - Step 15: Click to 'Search' button");
        customersPO.clickToSearchCustomerButton();

        log.info("Customer 06 - Step 16: Wait for 'Ajax loading' icon undisplayed");
        customersPO.waitForAjaxLoadingIconUndisplayed();

        log.info("Customer 06 - Step 17: Verify data");
        Assert.assertEquals(customersPO.getTableDataByRowIndexAndColumnName("1", "Name"), editFullname);
        Assert.assertEquals(customersPO.getTableDataByRowIndexAndColumnName("1", "Customer roles"), "Guests");
        Assert.assertEquals(customersPO.getTableDataByRowIndexAndColumnName("1", "Company name"), editCompanyName);

        log.info("Customer 06 - Step 18: Click to close 'Customers' link at side bar");
        customersPO.clickToSideBarLinkByName("Customers");
    }

    @Description("Add address in customer detail")
    @Test(groups = {"address"})
    public void Customer_07_Add_Address() {
        log.info("Customer 07 - Step 01: Click to open 'Customers' link at side bar");
        customersPO.clickToSideBarLinkByName("Customers");

        log.info("Customer 07 - Step 02: Click to open 'Customers' sub link at side bar");
        customersPO.clickToSideBarSubLinkByName(" Customers");

        log.info("Customer 07 - Step 03: Enter to 'Email' textbox with value: '" + editCustomerEmail + "'");
        customersPO.enterToTextboxByLabel("Email", editCustomerEmail);

        log.info("Customer 07 - Step 04: Delete all role in 'Customer role' dropdown");
        customersPO.deleteAllRoleInCustomerRoleDropdown();

        log.info("Customer 07 - Step 05: Select to 'Customer role' dropdown with value 'Guests'");
        customersPO.selectToCustomerRoleDropdown("Guests");

        log.info("Customer 07 - Step 06: Click to 'Search' button");
        customersPO.clickToSearchCustomerButton();

        log.info("Customer 07 - Step 07: Wait for 'Ajax loading' icon undisplayed");
        customersPO.waitForAjaxLoadingIconUndisplayed();

        log.info("Customer 07 - Step 08: Click to edit button at row 1");
        customersPO.clickTableButtonAtRowIndexAndColumnName("1", "Edit");

//        log.info("Customer 07 - Step 09: Click to 'Addresses' Card");
//        customersPO.clickToAddressesCard();
//        customersPO.waitForAjaxLoadingIconUndisplayed();

        log.info("Customer 07 - Step 10: Click to 'Add new Address' button");
        customersPO.clickToAddNewAddressButton();

        log.info("Customer 07 - Step 11: Wait for 'Ajax loading' icon undisplayed");
        customersPO.waitForAjaxLoadingIconUndisplayed();

        log.info("Customer 07 - Step 12: Enter data to address form textboxes");
        customersPO.enterDataToAddressFormTextboxes(UserData.FIRST_NAME, UserData.LAST_NAME,
                addressEmail, UserData.COMPANY_NAME, UserData.COUNTRY, UserData.CITY, UserData.ADDRESS1,
                UserData.ADDRESS2, UserData.ZIP_CODE, UserData.PHONE_NUMBER, UserData.FAX_NUMBER);

        log.info("Customer 07 - Step 13: Select to 'Country' dropdown with value: '" + UserData.COUNTRY + "'");
        customersPO.selectToDropdownByLabel("Country", UserData.COUNTRY);

        log.info("Customer 07 - Step 14: Click to addresses 'Save' button");
        customersPO.clickToAddressSaveButton();

        log.info("Customer 07 - Step 15: Verify save Address success message");
        Assert.assertTrue(customersPO.getAddCustomerSuccessMessage().contains("The new address has been added successfully."));

        log.info("Customer 07 - Step 16: Click 'Back to customer details' link");
        customersPO.clickToBackToCustomerDetailLink();

        log.info("Customer 07 - Step 17: Verify Addresses data");
        Assert.assertEquals(customersPO.getAddressTableDataByRowIndexAndColumnName("1", "First name"), UserData.FIRST_NAME);
        Assert.assertEquals(customersPO.getAddressTableDataByRowIndexAndColumnName("1", "Last name"), UserData.LAST_NAME);
        Assert.assertEquals(customersPO.getAddressTableDataByRowIndexAndColumnName("1", "Email"), addressEmail);
        Assert.assertEquals(customersPO.getAddressTableDataByRowIndexAndColumnName("1", "Phone number"), UserData.PHONE_NUMBER);
        Assert.assertEquals(customersPO.getAddressTableDataByRowIndexAndColumnName("1", "Fax number"), UserData.FAX_NUMBER);
        Assert.assertTrue(customersPO.getAddressTableDataByRowIndexAndColumnName("1", "Address").contains(UserData.ADDRESS1));
        Assert.assertTrue(customersPO.getAddressTableDataByRowIndexAndColumnName("1", "Address").contains(UserData.ADDRESS2));
        Assert.assertTrue(customersPO.getAddressTableDataByRowIndexAndColumnName("1", "Address").contains(UserData.COMPANY_NAME));
        Assert.assertTrue(customersPO.getAddressTableDataByRowIndexAndColumnName("1", "Address").contains(UserData.CITY));
        Assert.assertTrue(customersPO.getAddressTableDataByRowIndexAndColumnName("1", "Address").contains(UserData.COUNTRY));
        Assert.assertTrue(customersPO.getAddressTableDataByRowIndexAndColumnName("1", "Address").contains(UserData.ZIP_CODE));

        log.info("Customer 07 - Step 18: Click to close 'Customers' link at side bar");
        customersPO.clickToSideBarLinkByName("Customers");
    }

    @Description("Edit address in customer detail")
    @Test(groups = {"address"})
    public void Customer_08_Edit_Address() {
        log.info("Customer 08 - Step 01: Click to open 'Customers' link at side bar");
        customersPO.clickToSideBarLinkByName("Customers");

        log.info("Customer 08 - Step 02: Click to open 'Customers' sub link at side bar");
        customersPO.clickToSideBarSubLinkByName(" Customers");

        log.info("Customer 08 - Step 03: Enter to 'Email' textbox with value: '" + editCustomerEmail + "'");
        customersPO.enterToTextboxByLabel("Email", editCustomerEmail);

        log.info("Customer 08 - Step 04: Delete all role in 'Customer role' dropdown");
        customersPO.deleteAllRoleInCustomerRoleDropdown();

        log.info("Customer 08 - Step 05: Select to 'Customer role' dropdown with value 'Guests'");
        customersPO.selectToCustomerRoleDropdown("Guests");

        log.info("Customer 08 - Step 06: Click to 'Search' button");
        customersPO.clickToSearchCustomerButton();

        log.info("Customer 08 - Step 07: Wait for 'Ajax loading' icon undisplayed");
        customersPO.waitForAjaxLoadingIconUndisplayed();

        log.info("Customer 08 - Step 08: Click to edit button at row 1");
        customersPO.clickTableButtonAtRowIndexAndColumnName("1", "Edit");

//        log.info("Customer 08 - Step 09: Click to 'Addresses' Card");
//        customersPO.clickToAddressesCard();
//        customersPO.waitForAjaxLoadingIconUndisplayed();

        log.info("Customer 08 - Step 10: Click to address 'Edit' button");
        customersPO.clickTableButtonAtRowIndexAndColumnName("1", "Edit");
        customersPO.waitForAjaxLoadingIconUndisplayed();

        log.info("Customer 08 - Step 11: Enter edited data to 'Edit Address' texboxes");
        customersPO.enterDataToAddressFormTextboxes(editFirstName, editLastName, editAddressEmail, editCompanyName,
                UserData.COUNTRY, UserData.CITY, UserData.ADDRESS1, UserData.ADDRESS2,
                UserData.ZIP_CODE, UserData.PHONE_NUMBER, UserData.FAX_NUMBER);

        log.info("Customer 08 - Step 12: Click to addresses 'Save' button");
        customersPO.clickToEditAddressSaveButton();

        log.info("Customer 08 - Step 13: Verify updated Address success message");
        Assert.assertTrue(customersPO.getAddCustomerSuccessMessage().contains("The address has been updated successfully."));

        log.info("Customer 08 - Step 14: Verify edited Addresses data");
        Assert.assertEquals(customersPO.getTextboxAttributeValueByLabel("First name","value"),editFirstName);
        Assert.assertEquals(customersPO.getTextboxAttributeValueByLabel("Last name","value"),editLastName);
        Assert.assertEquals(customersPO.getTextboxAttributeValueByLabel("Email","value"),editAddressEmail);
        Assert.assertEquals(customersPO.getTextboxAttributeValueByLabel("Company","value"),editCompanyName);
        Assert.assertEquals(customersPO.getTextboxAttributeValueByLabel("County / region","value"),UserData.COUNTRY);
        Assert.assertEquals(customersPO.getTextboxAttributeValueByLabel("City","value"),UserData.CITY);
        Assert.assertEquals(customersPO.getTextboxAttributeValueByLabel("Address 1","value"),UserData.ADDRESS1);
        Assert.assertEquals(customersPO.getTextboxAttributeValueByLabel("Address 2","value"),UserData.ADDRESS2);
        Assert.assertEquals(customersPO.getTextboxAttributeValueByLabel("Zip / postal code","value"),UserData.ZIP_CODE);
        Assert.assertEquals(customersPO.getTextboxAttributeValueByLabel("Phone number","value"),UserData.PHONE_NUMBER);
        Assert.assertEquals(customersPO.getTextboxAttributeValueByLabel("Fax number","value"),UserData.FAX_NUMBER);

        log.info("Customer 08 - Step 15: Click 'Back to customer details' link");
        customersPO.clickToBackToCustomerDetailLink();

//        log.info("Customer 08 - Step 16: Click to 'Addresses' Card");
//        customersPO.clickToAddressesCard();
//        customersPO.waitForAjaxLoadingIconUndisplayed();

        log.info("Customer 08 - Step 17: Verify Addresses data");
        Assert.assertEquals(customersPO.getAddressTableDataByRowIndexAndColumnName("1", "First name"), editFirstName);
        Assert.assertEquals(customersPO.getAddressTableDataByRowIndexAndColumnName("1", "Last name"), editLastName);
        Assert.assertEquals(customersPO.getAddressTableDataByRowIndexAndColumnName("1", "Email"), editAddressEmail);
        Assert.assertTrue(customersPO.getAddressTableDataByRowIndexAndColumnName("1", "Address").contains(editCompanyName));

        log.info("Customer 08 - Step 18: Click to close 'Customers' link at side bar");
        customersPO.clickToSideBarLinkByName("Customers");
    }

    @Description("Delete Address")
    @Test(groups = {"address"})
    public void Customer_09_Delete_Address() {
        log.info("Customer 09 - Step 01: Click to open 'Customers' link at side bar");
        customersPO.clickToSideBarLinkByName("Customers");

        log.info("Customer 09 - Step 02: Click to open 'Customers' sub link at side bar");
        customersPO.clickToSideBarSubLinkByName(" Customers");

        log.info("Customer 09 - Step 03: Enter to 'Email' textbox with value: '" + editCustomerEmail + "'");
        customersPO.enterToTextboxByLabel("Email", editCustomerEmail);

        log.info("Customer 09 - Step 04: Delete all role in 'Customer role' dropdown");
        customersPO.deleteAllRoleInCustomerRoleDropdown();

        log.info("Customer 09 - Step 05: Select to 'Customer role' dropdown with value 'Guests'");
        customersPO.selectToCustomerRoleDropdown("Guests");

        log.info("Customer 09 - Step 06: Click to 'Search' button");
        customersPO.clickToSearchCustomerButton();

        log.info("Customer 09 - Step 07: Wait for 'Ajax loading' icon undisplayed");
        customersPO.waitForAjaxLoadingIconUndisplayed();

        log.info("Customer 09 - Step 08: Click to edit button at row 1");
        customersPO.clickTableButtonAtRowIndexAndColumnName("1", "Edit");

//        log.info("Customer 09 - Step 09: Click to 'Addresses' Card");
//        customersPO.clickToAddressesCard();
//        customersPO.waitForAjaxLoadingIconUndisplayed();

        log.info("Customer 09 - Step 10: Click to address 'Delete' button");
        customersPO.clickTableButtonAtRowIndexAndColumnName("1", "Delete");

        log.info("Customer 09 - Step 11: Accept alert pop up");
        customersPO.acceptAlert();

        log.info("Customer 09 - Step 12: Wait for 'Ajax loading' icon undisplayed");
        customersPO.waitForAjaxLoadingIconUndisplayed();

        log.info("Customer 09 - Step 13: Verify 'No data' message");
        Assert.assertEquals(customersPO.getAddressRowDataByIndex("1"),"No data available in table");
    }


    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }

    private WebDriver driver;
    private AdminLoginPO adminLoginPO;
    private AdminDashboardPO adminDashboardPO;
    private String editFirstName, editLastName, editCustomerEmail, editCompanyName,
            editAdminComment, editDob, editFullname, editAddressEmail, adminComment, customerEmail, addressEmail;
    private DataHelper dataHelper;
    private CatalogPO catalogPO;
    private CustomersPO customersPO;
}
