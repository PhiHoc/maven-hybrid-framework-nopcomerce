package com.nopcomerce.user;

import commons.BaseTest;
import io.qameta.allure.Description;
import com.nopcomerce.pageObjects.user.HomePO;
import com.nopcomerce.pageObjects.user.LoginPO;
import commons.PageGeneratorManager;
import com.nopcomerce.pageObjects.user.SearchPO;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {
    @Parameters({"browser", "env"})
    @BeforeClass
    public void beforeClass(String browserName, String envName) {
        notExistProduct = "Mac Pro 2050";
        relativeProductName = "Lenovo";
        absoluteProductName = "ThinkPad X1 Carbon";
        advancedSearchKeyword = "Apple Macbook Pro";

        driver = getBrowserDriver(browserName, envName);
        homePO = PageGeneratorManager.getHomePage(driver);

        log.info("Pre-condition: Click to Search link at footer");
        searchPO = (SearchPO) homePO.clickToFooterLinkByName("Search");

    }

    @Description("Search with empty data")
    @Test
    public void Search_01_Search_With_Empty_Data(){
        log.info("Search 01 - Step 01: Click to search button");
        searchPO.clickToSearchButton();

        log.info("Search 01 - Step 02: Verify error result message");
        Assert.assertEquals(searchPO.getSearchResultMessage(),"Search term minimum length is 3 characters");
    }

    @Description("Search with data not exist")
    @Test
    public void Search_02_Search_With_Data_Not_Exist(){
        log.info("Search 02 - Step 01: Enter not exist data to search textbox with value: '"+notExistProduct+"'");
        searchPO.enterToSearchTextBox(notExistProduct);

        log.info("Search 02 - Step 02: Click to 'Search' button");
        searchPO.clickToSearchButton();

        log.info("Search 02 - Step 03: Verify Search result message");
        Assert.assertEquals(searchPO.getSearchResultMessage(),"No products were found that matched your criteria.");
    }

    @Description("Search with relative product name")
    @Test
    public void Search_03_Search_With_Relative_Product_Name(){
        log.info("Search 03 - Step 01: Enter to search textbox with value: '"+relativeProductName+"'");
        searchPO.enterToSearchTextBox(relativeProductName);

        log.info("Search 03 - Step 02: Click to 'Search' button");
        searchPO.clickToSearchButton();

        log.info("Search 03 - Step 03: Verify 2 product appear");
        Assert.assertEquals(searchPO.getNumberOfProductsAppear(),2);

        log.info("Search 03 - Step 04: Verify product name");
        Assert.assertEquals(searchPO.getProductsNameList().get(0),"Lenovo IdeaCentre 600 All-in-One PC");
        Assert.assertEquals(searchPO.getProductsNameList().get(1),"Lenovo Thinkpad X1 Carbon Laptop");
    }

    @Description("Search with absolute product name")
    @Test
    public void Search_04_Search_With_Absolute_Product_Name(){
        log.info("Search 04 - Step 01: Enter to search textbox with value: '"+absoluteProductName+"'");
        searchPO.enterToSearchTextBox(absoluteProductName);

        log.info("Search 04 - Step 02: Click to 'Search' button");
        searchPO.clickToSearchButton();

        log.info("Search 04 - Step 03: Verify 1 product appear");
        Assert.assertEquals(searchPO.getNumberOfProductsAppear(),1);

        log.info("Search 04 - Step 04: Verify product name");
        Assert.assertEquals(searchPO.getProductsNameList().get(0),"Lenovo Thinkpad X1 Carbon Laptop");
    }

    @Description("Advanced search with parent category")
    @Test
    public void Search_05_Advanced_Search_With_Parent_Category(){
        log.info("Search 05 - Step 01: Enter to search textbox with value: '"+advancedSearchKeyword+"'");
        searchPO.enterToSearchTextBox(advancedSearchKeyword);

        log.info("Search 05 - Step 02: Check to 'Advanced search' checkbox");
        searchPO.checkToAdvancedSearchCheckBox();

        log.info("Search 05 - Step 03: Select Category with value: 'Computers'");
        searchPO.selectCategoryDropdownWithValue("Computers");

        log.info("Search 05 - Step 04: Uncheck to 'Automatically search sub categories' checkbox");
        searchPO.unCheckToAutoSearchSubCategoryCheckBox();

        log.info("Search 05 - Step 05: Click to 'Search' button");
        searchPO.clickToSearchButton();

        log.info("Search 05 - Step 06: Verify Search result message");
        Assert.assertEquals(searchPO.getSearchResultMessage(),"No products were found that matched your criteria.");
    }

    @Description("Advanced search with sub category")
    @Test
    public void Search_06_Advanced_Search_With_Sub_Category(){
        log.info("Search 06 - Step 01: Enter to search textbox with value: '"+advancedSearchKeyword+"'");
        searchPO.enterToSearchTextBox(advancedSearchKeyword);

        log.info("Search 06 - Step 02: Check to 'Advanced search' checkbox");
        searchPO.checkToAdvancedSearchCheckBox();

        log.info("Search 06 - Step 03: Select Category with value: 'Computers'");
        searchPO.selectCategoryDropdownWithValue("Computers");

        log.info("Search 06 - Step 04: check to 'Automatically search sub categories' checkbox");
        searchPO.checkToAutoSearchSubCategoryCheckBox();

        log.info("Search 06 - Step 05: Click to 'Search' button");
        searchPO.clickToSearchButton();

        log.info("Search 06 - Step 06: Verify 1 product appear");
        Assert.assertEquals(searchPO.getNumberOfProductsAppear(),1);

        log.info("Search 06 - Step 07: Verify product name");
        Assert.assertEquals(searchPO.getProductsNameList().get(0),"Apple MacBook Pro 13-inch");
    }

    @Description("Advanced search with incorrect manufacturer")
    @Test
    public void Search_07_Advanced_Search_With_Incorrect_Manufacturer(){
        log.info("Search 07 - Step 01: Enter to search textbox with value: '"+advancedSearchKeyword+"'");
        searchPO.enterToSearchTextBox(advancedSearchKeyword);

        log.info("Search 07 - Step 02: Check to 'Advanced search' checkbox");
        searchPO.checkToAdvancedSearchCheckBox();

        log.info("Search 07 - Step 03: Select Category with value: 'Computers'");
        searchPO.selectCategoryDropdownWithValue("Computers");

        log.info("Search 07 - Step 04: check to 'Automatically search sub categories' checkbox");
        searchPO.checkToAutoSearchSubCategoryCheckBox();

        log.info("Search 07 - Step 05: Select Manufacturer with value: 'HP'");
        searchPO.selectManufacturerDropdownWithValue("HP");

        log.info("Search 07 - Step 06: Click to 'Search' button");
        searchPO.clickToSearchButton();

        log.info("Search 07 - Step 07: Verify Search result message");
        Assert.assertEquals(searchPO.getSearchResultMessage(),"No products were found that matched your criteria.");
    }

    @Description("Advanced search with correct manufacturer")
    @Test
    public void Search_08_Advanced_Search_With_Correct_Manufacturer(){
        log.info("Search 08 - Step 01: Enter to search textbox with value: '"+advancedSearchKeyword+"'");
        searchPO.enterToSearchTextBox(advancedSearchKeyword);

        log.info("Search 08 - Step 02: Check to 'Advanced search' checkbox");
        searchPO.checkToAdvancedSearchCheckBox();

        log.info("Search 08 - Step 03: Select Category with value: 'Computers'");
        searchPO.selectCategoryDropdownWithValue("Computers");

        log.info("Search 08 - Step 04: check to 'Automatically search sub categories' checkbox");
        searchPO.checkToAutoSearchSubCategoryCheckBox();

        log.info("Search 08 - Step 05: Select Manufacturer with value: 'HP'");
        searchPO.selectManufacturerDropdownWithValue("Apple");

        log.info("Search 08 - Step 06: Click to 'Search' button");
        searchPO.clickToSearchButton();

        log.info("Search 08 - Step 07: Verify 1 product appear");
        Assert.assertEquals(searchPO.getNumberOfProductsAppear(),1);

        log.info("Search 08 - Step 08: Verify product name");
        Assert.assertEquals(searchPO.getProductsNameList().get(0),"Apple MacBook Pro 13-inch");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        closeBrowserDriver();
    }

    private String notExistProduct,relativeProductName,absoluteProductName,advancedSearchKeyword;
    private WebDriver driver;
    HomePO homePO;
    LoginPO loginPO;
    SearchPO searchPO;
}
