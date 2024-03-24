package com.nopcomerce.user;

import com.nopcomerce.pageObjects.user.*;
import commons.BaseTest;
import commons.CommonRegister;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class WishlistCompareRecentViewTest extends BaseTest {
    @Parameters({"browser", "role"})
    @BeforeClass(alwaysRun = true)
    public void beforeClass(String browserName, String role) {

        firstName = CommonRegister.getFirstName();
        lastName = CommonRegister.getLastName();
        fullName = firstName + " " + lastName;
        email = CommonRegister.getEmail();
        password = CommonRegister.getPassword();

        noteBookNames.add("Apple MacBook Pro 13-inch");
        noteBookNames.add("Asus N551JK-XO076H Laptop");
        noteBookNames.add("HP Envy 6-1180ca 15.6-Inch Sleekbook");
        noteBookNames.add("HP Spectre XT Pro UltraBook");
        noteBookNames.add("Lenovo Thinkpad X1 Carbon Laptop");
        pcName = "Build your own computer";

        driver = getBrowserDriver(browserName, role);
        homePO = PageGeneratorManager.getHomePage(driver);

        log.info("Pre-condition Step 01 - Click to Login link");
        loginPO = homePO.clickToLoginLink();

        log.info("Pre-condition Step 02 - Login with a valid account");
        loginPO.loginToAccount(email, password);

        log.info("Pre-condition Step 03 - Verify login success");
        Assert.assertTrue(loginPO.isMyAccountLinkDisplayed());
        homePO = PageGeneratorManager.getHomePage(driver);
    }

    @Description("Add product to wishlist")
    @Test(groups = "wishlist")
    public void WishlistCompareRecentView_01_Add_To_WishList() {
        log.info("WishList 01 - Step 1: Click to product: '" + noteBookNames.get(0) + "'");
        homePO.clickToProductByName(noteBookNames.get(0));

        log.info("WishList 01 - Step 2: Click Add to wishlist button");
        homePO.clickToAddToWishListButton();

        log.info("WishList 01 - Step 3: Verify add to wishlist suscess message");
        Assert.assertEquals(homePO.getBarNotificationMessage(), "The product has been added to your wishlist");

        log.info("WishList 01 - Step 4: Click to close message button");
        homePO.clickToCloseNotificationMessageButton();

        log.info("WishList 01 - Step 5: Click to 'Wishlist' link");
        wishListPO = homePO.clickToWishListLink();

        log.info("WishList 01 - Step 6: Verify product name in wishlist page");
        Assert.assertEquals(wishListPO.getProductsNameList().get(0), noteBookNames.get(0));

        log.info("WishList 01 - Step 7: Click to 'Your wishlist URL for sharing link'");
        wishListPO.clickToWishListURLSharingLink();

        log.info("WishList 01 - Step 8: Verify user name in page title");
        Assert.assertEquals(wishListPO.getPageTitle(), "Wishlist of " + fullName);

        log.info("WishList 01 - Step 9: Verify product name in wishlist page");
        Assert.assertEquals(wishListPO.getProductsNameList().get(0), noteBookNames.get(0));

        log.info("WishList 01 - Step 10: Navigate back to user Wishlist page");
        wishListPO.backToPage();
    }

    @Description("Add product to cart from wishlist page")
    @Test(groups = "wishlist")
    public void WishlistCompareRecentView_02_Add_Product_To_Cart() {
        log.info("WishList 02 - Step 01: Check to 'Add to cart' checkbox");
        wishListPO.checkToAddToCartCheckbox();

        log.info("WishList 02 - Step 02: Click add to cart button");
        shoppingCartPO = wishListPO.clickToAddToCartButton();

        log.info("WishList 02 - Step 03: Verify product name in 'Shopping cart' page");
        Assert.assertEquals(shoppingCartPO.getProductsNameList().get(0), noteBookNames.get(0));

        log.info("WishList 02 - Step 04: Click to Wishlist link");
        wishListPO = shoppingCartPO.clickToWishListLink();

        log.info("WishList 02 - Step 05: Verify 'wishlist is empty' message appear ");
        Assert.assertEquals(wishListPO.getWistListIsEmptyMessage(), "The wishlist is empty!");

        wishListPO.openPageUrl(GlobalConstants.getGlobalConstants().getPortalPageUrl());
        homePO = PageGeneratorManager.getHomePage(driver);
    }
    @Description("Remove product in wishlist page")
    @Test(groups = "wishlist")
    public void WishlistCompareRecentView_03_Remove_Product_In_Wishlist_Page() {
        log.info("WishList 03 - Step 1: Click to product: '" + noteBookNames.get(0) + "'");
        homePO.clickToProductByName(noteBookNames.get(0));

        log.info("WishList 03 - Step 2: Click Add to wishlist button");
        homePO.clickToAddToWishListButton();

        log.info("WishList 03 - Step 3: Verify add to wishlist suscess message");
        Assert.assertEquals(homePO.getBarNotificationMessage(), "The product has been added to your wishlist");

        log.info("WishList 03 - Step 4: Click to close message button");
        homePO.clickToCloseNotificationMessageButton();

        log.info("WishList 03 - Step 5: Click to 'Wishlist' link");
        wishListPO = homePO.clickToWishListLink();

        log.info("WishList 03 - Step 6: Click to all remove product button");
        wishListPO.clickToAllRemoveProductButton();

        log.info("WishList 03 - Step 07: Verify 'wishlist is empty' message appear ");
        Assert.assertEquals(wishListPO.getWistListIsEmptyMessage(), "The wishlist is empty!");

        log.info("WishList 03 - Step 8: Click home page logo to go back to homepage");
        homePO = wishListPO.clickToHomePageLogoLink();
    }

    @Description("Add product to compare")
    @Test
    public void WishlistCompareRecentView_04_Add_Product_To_Compare() {
        log.info("Compare product - Step 01: Click to compare button of product: '"+ noteBookNames.get(0)+"'");
        homePO.clickToCompareButtonByProductName(noteBookNames.get(0));

        log.info("Compare product - Step 02: Verify add product to compare list success");
        Assert.assertEquals(homePO.getBarNotificationMessage(),"The product has been added to your product comparison");

        log.info("Compare product - Step 03: Click to Close message");
        homePO.clickToCloseNotificationMessageButton();

        log.info("Compare product - Step 04: Click to compare button of product: '"+ pcName +"'");
        homePO.clickToCompareButtonByProductName(pcName);

        log.info("Compare product - Step 05: Verify add product to compare list success");
        Assert.assertEquals(homePO.getBarNotificationMessage(),"The product has been added to your product comparison");

        log.info("Compare product - Step 06: Click to Close message");
        homePO.clickToCloseNotificationMessageButton();

        log.info("Compare product - Step 07: Click to 'Compare product' link");
        compareProductPO = (CompareProductPO) homePO.clickToFooterLinkByName("Compare products list");

        log.info("Compare product - Step 08: Verify first product name");
        Assert.assertEquals(compareProductPO.getCompareProductNameList().get(0), pcName);

        log.info("Compare product - Step 09: Verify second product name");
        Assert.assertEquals(compareProductPO.getCompareProductNameList().get(1), noteBookNames.get(0));

        log.info("Compare product - Step 10: Click to 'Clear Data' button");
        compareProductPO.clickToClearListButton();

        log.info("Compare product - Step 11: Verify no product message");
        Assert.assertEquals(compareProductPO.getNoCompareProductMessage(),"You have no items to compare.");

        log.info("Compare product - Step 12: Click home page logo to go back to homepage");
        homePO = wishListPO.clickToHomePageLogoLink();
    }

    @Description("Recently viewed product")
    @Test
    public void WishlistCompareRecentView_05_Recently_Viewed_Product() {
        log.info("Recently viewed products - Step 01: Click to 'Computer' menu");
        homePO.clickToComputersMenu();

        log.info("Recently viewed products - Step 02: Click to 'Notebook' submenu");
        homePO.clickToNoteBookSubMenu();

        log.info("Recently viewed products - Step 03: Click to product '"+noteBookNames.get(0)+"' and navigate back");
        homePO.clickToProductByName(noteBookNames.get(0));
        homePO.backToPage();

        log.info("Recently viewed products - Step 04: Click to product '"+noteBookNames.get(1)+"' and navigate back");
        homePO.clickToProductByName(noteBookNames.get(1));
        homePO.backToPage();

        log.info("Recently viewed products - Step 05: Click to product '"+noteBookNames.get(2)+"' and navigate back");
        homePO.clickToProductByName(noteBookNames.get(2));
        homePO.backToPage();

        log.info("Recently viewed products - Step 06: Click to product '"+noteBookNames.get(3)+"' and navigate back");
        homePO.clickToProductByName(noteBookNames.get(3));
        homePO.backToPage();

        log.info("Recently viewed products - Step 07: Click to product '"+noteBookNames.get(4)+"' and navigate back");
        homePO.clickToProductByName(noteBookNames.get(4));
        homePO.backToPage();

        log.info("Recently viewed products - Step 08: Click to product 'Recently View Product' link");
        homePO.clickToFooterLinkByName("Recently viewed products");

        log.info("Recently viewed products - Step 09: Verify 3 lasted product are in recently viewed page");
        Assert.assertEquals(homePO.getProductNameListInRecentlyViewPage().get(0),noteBookNames.get(noteBookNames.size()-1));
        Assert.assertEquals(homePO.getProductNameListInRecentlyViewPage().get(1),noteBookNames.get(noteBookNames.size()-2));
        Assert.assertEquals(homePO.getProductNameListInRecentlyViewPage().get(2),noteBookNames.get(noteBookNames.size()-3));
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }

    private WebDriver driver;
    private HomePO homePO;
    private LoginPO loginPO;
    private String firstName, lastName, fullName, email, password, pcName;
    private List<String> noteBookNames = new ArrayList<>();
    private WishListPO wishListPO;
    private ShoppingCartPO shoppingCartPO;
    private CompareProductPO compareProductPO;
}
