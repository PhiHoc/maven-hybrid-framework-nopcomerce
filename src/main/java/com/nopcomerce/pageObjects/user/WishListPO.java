package com.nopcomerce.pageObjects.user;

import commons.BaseComponent;
import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import com.nopcomerce.PageUIs.user.WishListPUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class WishListPO extends BaseComponent {
    public WishListPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Verify products name")
    public List<String> getProductsNameList() {
        waitForAllElementVisible(WishListPUI.PRODUCTS_NAME_LINK);
        return getElements(WishListPUI.PRODUCTS_NAME_LINK).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    @Step("Click to 'Wishlist URL for sharing' link")
    public void clickToWishListURLSharingLink() {
        waitForElementClickable(WishListPUI.SHARE_WISHLIST_URL_LINK);
        clickToElement(WishListPUI.SHARE_WISHLIST_URL_LINK);
    }

    @Step("Verify Wishlist page title")
    public String getPageTitle() {
        waitForElementVisible(WishListPUI.WISHLIST_PAGE_TITILE);
        return getElementText(WishListPUI.WISHLIST_PAGE_TITILE);
    }

    @Step("Click to all 'Add to cart' checkbox")
    public void checkToAddToCartCheckbox() {
        waitForAllElementVisible(WishListPUI.ADD_TO_CART_CHECKBOXES);
        List<WebElement> checkboxesList = getElements(WishListPUI.ADD_TO_CART_CHECKBOXES);
        for(WebElement checkbox:checkboxesList){
            if(!checkbox.isSelected()){
                checkbox.click();
            }
        }
    }

    @Step("Click to 'Add to cart' button")
    public ShoppingCartPO clickToAddToCartButton() {
        waitForElementClickable(WishListPUI.ADD_TO_CART_BUTTON);
        clickToElement(WishListPUI.ADD_TO_CART_BUTTON);
        return PageGeneratorManager.getShoppingCartPage(driver);
    }

    @Step("Verify Wishlist empty message")
    public String getWistListIsEmptyMessage() {
        waitForElementVisible(WishListPUI.WISHLIST_EMPTY_MESSAGE);
        return getElementText(WishListPUI.WISHLIST_EMPTY_MESSAGE);
    }

    @Step("Click to all 'Remove product' button")
    public void clickToAllRemoveProductButton() {
        waitForAllElementVisible(WishListPUI.REMOVE_PRODUCT_BUTTON);
        List<WebElement> removeButtonList = getElements(WishListPUI.REMOVE_PRODUCT_BUTTON);
        for(WebElement rmbutton:removeButtonList){
            rmbutton.click();
        }
    }

    private WebDriver driver;
}
