package com.nopcomerce.user;

import commons.BaseTest;
import commons.CommonRegister;
import io.qameta.allure.Description;
import com.nopcomerce.pageObjects.user.HomePO;
import com.nopcomerce.pageObjects.user.LoginPO;
import commons.PageGeneratorManager;
import com.nopcomerce.pageObjects.user.ShoppingCartPO;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ShoppingCartTest extends BaseTest {
    @Parameters({"browser", "env"})
    @BeforeClass
    public void beforeClass(String browserName, String envName) {
        email = CommonRegister.email;
        password = CommonRegister.password;
        pcName = "Build your own computer";
        lenovoName = "Lenovo Thinkpad X1 Carbon Laptop";
        macbookName = "Apple MacBook Pro 13-inch";

        prossesor = "2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]";
        ram = "8GB [+$60.00]";
        hddRadio = "400 GB [+$100.00]";
        osRadio = "Vista Premium [+$60.00]";
        softwareMicrosoft = "Microsoft Office [+$50.00]";
        softwareAcrobat = "Acrobat Reader [+$10.00]";
        softwareComander = "Total Commander [+$5.00]";

        editProssesor = "2.2 GHz Intel Pentium Dual-Core E2200";
        editRam = "4GB [+$20.00]";
        editOsRadio = "Vista Home [+$50.00]";
        editHddRadio = "320 GB";

        driver = getBrowserDriver(browserName, envName);
        homePO = PageGeneratorManager.getHomePage(driver);

//        log.info("Pre-condition Step 01 - Click to Login link");
//        loginPO = homePO.clickToLoginLink();
//
//        log.info("Pre-condition Step 02 - Login with a valid account");
//        loginPO.loginToAccount(email, password);
//
//        log.info("Pre-condition Step 03 - Verify login success");
//        Assert.assertTrue(loginPO.isMyAccountLinkDisplayed());
//        homePO = PageGeneratorManager.getHomePage(driver);
    }

    @Description("Add product to cart")
    @Test
    public void Cart_01_Add_Product_To_Cart() {
        log.info("Cart 01 - Step 01: Click to product: '" + pcName + "'");
        homePO.clickToProductByName(pcName);

        log.info("Cart 01 - Step 02: Select ram: '" + ram + "'");
        homePO.selectProductAttributeDropdownByLabel(" RAM ", ram);

        log.info("Cart 01 - Step 03: Check to HDD radio: '" + hddRadio + "'");
        homePO.checkToProductAttributeRadioByLabel(hddRadio);

        log.info("Cart 01 - Step 04: Check to OS radio: '" + osRadio + "'");
        homePO.checkToProductAttributeRadioByLabel(osRadio);

        log.info("Cart 01 - Step 05: Check to all software checkbox");
        homePO.checkToProductAttributeCheckboxByLabel(softwareMicrosoft);
        homePO.checkToProductAttributeCheckboxByLabel(softwareAcrobat);
        homePO.checkToProductAttributeCheckboxByLabel(softwareComander);

        log.info("Cart 01 - Step 06: Click to 'Add to cart' button");
        homePO.clickToAddToCartButton();

        log.info("Cart 01 - Step 07: Verify add to cart success message");
        Assert.assertEquals(homePO.getBarNotificationMessage(), "The product has been added to your shopping cart");

        log.info("Cart 01 - Step 08: Click to close message button");
        homePO.clickToCloseNotificationMessageButton();

        log.info("Cart 01 - Step 09: Click to 'Shopping cart' link");
        shoppingCartPO = homePO.clickToShoppingCartLink();

        log.info("Cart 01 - Step 10: Verify product name in 'Shopping cart' page");
        Assert.assertEquals(shoppingCartPO.getProductsNameList().get(0), pcName);

        log.info("Cart 01 - Step 11: Verify product attribute");
        String productAttribute = shoppingCartPO.getProductAttributeByName(pcName);
        Assert.assertTrue(productAttribute.contains(prossesor));
        Assert.assertTrue(productAttribute.contains(ram));
        Assert.assertTrue(productAttribute.contains(hddRadio));
        Assert.assertTrue(productAttribute.contains(osRadio));
        Assert.assertTrue(productAttribute.contains(softwareMicrosoft));
        Assert.assertTrue(productAttribute.contains(softwareAcrobat));
        Assert.assertTrue(productAttribute.contains(softwareComander));

        log.info("Cart 01 - Step 12: Verify product price");
        Assert.assertEquals(shoppingCartPO.getProductsPriceByProductName(pcName), "$1,500.00");

    }

    @Description("Edit product in shopping cart")
    @Test
    public void Cart_02_Edit_Product_In_Cart() {
        log.info("Cart 02 - Step 01: Click to edit link of product: '" + pcName + "'");
        homePO = shoppingCartPO.clickToProductEditLinkByName(pcName);

        log.info("Cart 02 - Step 02: Select Processor: '" + editProssesor + "'");
        homePO.selectProductAttributeDropdownByLabel(" Processor ", editProssesor);

        log.info("Cart 02 - Step 03: Select Ram: '" + editRam + "'");
        homePO.selectProductAttributeDropdownByLabel(" RAM ", editRam);

        log.info("Cart 02 - Step 04: Check to HDD radio: '" + hddRadio + "'");
        homePO.checkToProductAttributeRadioByLabel(editHddRadio);

        log.info("Cart 02 - Step 05: Check to OS radio: '" + hddRadio + "'");
        homePO.checkToProductAttributeRadioByLabel(editOsRadio);

        log.info("Cart 02 - Step 06: Microsoft Office checkbox and uncheck to others checkbox");
        homePO.checkToProductAttributeCheckboxByLabel(softwareMicrosoft);
        homePO.uncheckToProductAttributeCheckboxByLabel(softwareAcrobat);
        homePO.uncheckToProductAttributeCheckboxByLabel(softwareComander);

        log.info("Cart 02 - Step 07: Update product quantity to 2");
        homePO.enterToProductQuantity("2");

        log.info("Cart 02 - Step 08: Click to Update button");
        homePO.clickToUpdateButton();

        log.info("Cart 02 - Step 09: Verify update success message");
        Assert.assertEquals(homePO.getBarNotificationMessage(), "The product has been added to your shopping cart");

        log.info("Cart 02 - Step 10: Click to close message button");
        homePO.clickToCloseNotificationMessageButton();

        log.info("Cart 02 - Step 11: Click to 'Shopping cart' link");
        shoppingCartPO = homePO.clickToShoppingCartLink();

        log.info("Cart 02 - Step 12: Verify product name in 'Shopping cart' page");
        Assert.assertEquals(shoppingCartPO.getProductsNameList().get(0), pcName);

        log.info("Cart 02 - Step 13: Verify product attribute");
        String productAttribute = shoppingCartPO.getProductAttributeByName(pcName);
        Assert.assertTrue(productAttribute.contains(editProssesor));
        Assert.assertTrue(productAttribute.contains(editRam));
        Assert.assertTrue(productAttribute.contains(editHddRadio));
        Assert.assertTrue(productAttribute.contains(editOsRadio));
        Assert.assertTrue(productAttribute.contains(softwareMicrosoft));

        log.info("Cart 02 - Step 14: Verify product price");
        Assert.assertEquals(shoppingCartPO.getProductsPriceByProductName(pcName), "$1,320.00");

        log.info("Cart 02 - Step 15: Verify product Total price");
        Assert.assertEquals(shoppingCartPO.getProductsTotalPriceByProductName(pcName), "$2,640.00");
    }

    @Description("Remove product in shopping cart")
    @Test
    public void Cart_03_Remove_Product_In_Cart() {
        log.info("Cart 03 - Step 01: Click to remove button");
        shoppingCartPO.clickToRemoveAllProduct();

        log.info("Cart 03 - Step 02: Verify empty cart message");
        Assert.assertEquals(shoppingCartPO.getEmptyShoppingCartMessage(), "Your Shopping Cart is empty!");

        log.info("Cart 03 - Step 03: Verify 0 product at 'Shopping cart' link");
        Assert.assertEquals(shoppingCartPO.getProductNumberAtShoppingCartLink(), "(0)");

        log.info("Cart 03 - Step 04: Click to 'Home page' logo to return to Home page");
        homePO = shoppingCartPO.clickToHomePageLogoLink();
    }

    @Description("Update product in shopping cart")
    @Test
    public void Cart_04_Update_Product_In_Cart() {
        log.info("Cart 04 - Step 01: Click to Computer menu");
        homePO.clickToComputersMenu();

        log.info("Cart 04 - Step 02: Click to Notebook submenu");
        homePO.clickToNoteBookSubMenu();

        log.info("Cart 04 - Step 03: Click to product: '" + lenovoName + "'");
        homePO.clickToProductByName(lenovoName);

        log.info("Cart 04 - Step 04: Click 'Add to cart' button");
        homePO.clickToAddToCartButton();

        log.info("Cart 04 - Step 05: Vefiry add to cart success message");
        Assert.assertEquals(homePO.getBarNotificationMessage(), "The product has been added to your shopping cart");

        log.info("Cart 04 - Step 06: Click to close message button");
        homePO.clickToCloseNotificationMessageButton();

        log.info("Cart 04 - Step 07: Click to 'Shopping cart' link");
        shoppingCartPO = homePO.clickToShoppingCartLink();

        log.info("Cart 04 - Step 08: Verify total product price");
        Assert.assertEquals(shoppingCartPO.getProductsTotalPriceByProductName(lenovoName), "$1,360.00");

        log.info("Cart 04 - Step 09: Update product quantity");
        shoppingCartPO.enterToQuantityTextBoxByProductName(lenovoName, "5");

        log.info("Cart 04 - Step 10: Click to 'Update cart' button");
        shoppingCartPO.clickToUpdateCartButton();

        log.info("Cart 04 - Step 11: Verify total product price after update quantity");
        Assert.assertEquals(shoppingCartPO.getProductsTotalPriceByProductName(lenovoName), "$6,800.00");


        log.info("Cart 04 - Step 12: Remove product and back to home page");
        shoppingCartPO.clickToRemoveAllProduct();
        homePO = shoppingCartPO.clickToHomePageLogoLink();
    }
    
    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }

    private WebDriver driver;
    private HomePO homePO;
    String email, password,pcName,lenovoName, prossesor, macbookName,
            ram, hddRadio, osRadio, softwareMicrosoft, softwareAcrobat, softwareComander;
    String editProssesor, editRam, editHddRadio, editOsRadio;
    private LoginPO loginPO;
    private ShoppingCartPO shoppingCartPO;
}
