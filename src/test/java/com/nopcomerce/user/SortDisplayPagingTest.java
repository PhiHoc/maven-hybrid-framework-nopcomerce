package com.nopcomerce.user;

import commons.BaseTest;
import io.qameta.allure.Description;
import com.nopcomerce.pageObjects.user.HomePO;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SortDisplayPagingTest extends BaseTest {
    @Parameters({"browser", "role"})
    @BeforeClass(alwaysRun = true)
    public void beforeClass(String browserName, String role) {
        driver = getBrowserDriver(browserName, role);
        homePO = PageGeneratorManager.getHomePage(driver);

        log.info("Pre-condition Step 01 - Click to Computers menu");
        homePO.clickToComputersMenu();

        log.info("Pre-condition Step 02 - Click to NoteBook sub-menu");
        homePO.clickToNoteBookSubMenu();
    }

    @Description("Sort products name from A to Z")
    @Test(groups = "sort")
    public void Sort_DisPlay_01_Sort_With_Name_A_To_Z(){
        log.info("Sort 01 - Step 01: Select sort A to Z in 'Sort by' dropdown");
        homePO.selectToSortByDropdownWithValue("Name: A to Z");

        log.info("Sort 01 - Step 02: Refresh page");
        homePO.refreshPage();

        log.info("Sort 01 - Step 03: Verify is Products name sorted from A to Z");
        Assert.assertTrue(homePO.isProductNameSortedFromAtoZ());
    }

    @Description("Sort products name from Z to A")
    @Test(groups = "sort")
    public void Sort_DisPlay_02_Sort_With_Name_Z_To_A(){
        log.info("Sort 02 - Step 01: Select sort Z to A in 'Sort by' dropdown");
        homePO.selectToSortByDropdownWithValue("Name: Z to A");

        log.info("Sort 02 - Step 02: Refresh page");
        homePO.refreshPage();

        log.info("Sort 02 - Step 03: Verify is Products name sorted from Z to A");
        Assert.assertTrue(homePO.isProductNameSortedFromZtoA());
    }

    @Description("Sort products price from low to high")
    @Test(groups = "sort")
    public void Sort_DisPlay_03_Sort_With_Price_Low_To_High(){
        log.info("Sort 03 - Step 01: Select sort price from low to high in 'Sort by' dropdown");
        homePO.selectToSortByDropdownWithValue("Price: Low to High");

        log.info("Sort 03 - Step 02: Refresh page");
        homePO.refreshPage();

        log.info("Sort 03 - Step 03: Verify is Products price sorted from low to high");
        Assert.assertTrue(homePO.isProductPriceSortedFromLowToHigh());
    }

    @Description("Sort products price from high to low")
    @Test(groups = "sort")
    public void Sort_DisPlay_04_Sort_With_Price_High_To_Low(){
        log.info("Sort 04 - Step 01: Select sort price from high to low in 'Sort by' dropdown");
        homePO.selectToSortByDropdownWithValue("Price: High to Low");

        log.info("Sort 04 - Step 02: Refresh page");
        homePO.refreshPage();

        log.info("Sort 04 - Step 03: Verify is Products price sorted from high to low");
        Assert.assertTrue(homePO.isProductPriceSortedFromHighToLow());
    }

    @Description("Display 3 products per page")
    @Test(groups = "display")
    public void Sort_Display_05_Display_3_Products_Per_Page(){
        log.info("Display 01 - Step 01: Select 3 in 'Display per page' dropdown");
        homePO.selectToDisplayPerPageDropdownWithValue("3");

        log.info("Display 01 - Step 02: Refresh page");
        homePO.refreshPage();

        log.info("Display 01 - Step 03: Verify 3 or less products appear");
        Assert.assertTrue(homePO.getNumberOfProductsDisplayed()<=3);

        log.info("Display 01 - Step 04: Verify current page is 1");
        Assert.assertEquals(homePO.getPagingCurrentPage(),"1");

        log.info("Display 01 - Step 04: Verify paging 'Next Icon' appear at page 1");
        Assert.assertTrue(homePO.isPagingNextIconDisplayed());

        log.info("Display 01 - Step 06: Click to paging 'Next Icon'");
        homePO.clickToPagingNextIcon();
        homePO.refreshPage();

        log.info("Display 01 - Step 07: Verify current page is 2");
        Assert.assertEquals(homePO.getPagingCurrentPage(),"2");

        log.info("Display 01 - Step 08: Verify paging 'Previous Icon' appear at page 2");
        Assert.assertTrue(homePO.isPagingPreviousIconDisplayed());

    }

    @Description("Display 6 products per page")
    @Test(groups = "display")
    public void Sort_Display_06_Display_6_Products_Per_Page(){
        log.info("Display 02 - Step 01: Select 6 in 'Display per page' dropdown");
        homePO.selectToDisplayPerPageDropdownWithValue("6");

        log.info("Display 02 - Step 02: Refresh page");
        homePO.refreshPage();

        log.info("Display 02 - Step 03: Verify 6 or less products appear");
        Assert.assertTrue(homePO.getNumberOfProductsDisplayed()<=6);

        log.info("Display 02 - Step 04: Verify no paging icon appear");
        Assert.assertTrue(homePO.isPagingNextIconUnDisplayed());
    }

    @Description("Display 9 products per page")
    @Test(groups = "display")
    public void Sort_Display_07_Display_9_Products_Per_Page(){
        log.info("Display 03 - Step 01: Select 9 in 'Display per page' dropdown");
        homePO.selectToDisplayPerPageDropdownWithValue("9");

        log.info("Display 03 - Step 02: Refresh page");
        homePO.refreshPage();

        log.info("Display 03 - Step 03: Verify 9 or less products appear");
        Assert.assertTrue(homePO.getNumberOfProductsDisplayed()<=9);

        log.info("Display 03 - Step 04: Verify no paging icon appear");
        Assert.assertTrue(homePO.isPagingNextIconUnDisplayed());

    }
    @AfterClass(alwaysRun = true)
    public void afterClass(){
        closeBrowserDriver();
    }

    private WebDriver driver;
    HomePO homePO;
}
