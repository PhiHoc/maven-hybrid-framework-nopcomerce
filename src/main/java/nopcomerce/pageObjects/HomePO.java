package nopcomerce.pageObjects;

import commons.BasePage;
import io.qameta.allure.Step;
import nopcomerce.PageUIs.HomePUI;
import org.openqa.selenium.WebDriver;

public class HomePO extends BasePage {
    public HomePO(WebDriver driver) {
        super(driver);
    }

    @Step("Click to product link: {0}")
    public void clickToProductByName(String name) {
        waitForElementClickable(HomePUI.DYNAMIC_PRODUCT_LINK_BY_NAME,name);
        clickToElement(HomePUI.DYNAMIC_PRODUCT_LINK_BY_NAME,name);
    }

    public void clickToAddYourReviewLink() {
        waitForElementClickable(HomePUI.ADD_YOUR_REVIEW_LINK);
        clickToElement(HomePUI.ADD_YOUR_REVIEW_LINK);
    }

    public void enterToReviewTitleTextbox(String reviewTitle) {
        waitForElementVisible(HomePUI.REVIEW_TITLE_TEXTBOX);
        sendKeysToElement(HomePUI.REVIEW_TITLE_TEXTBOX,reviewTitle);
    }

    public void enterToReviewTextArea(String reviewText) {
        waitForElementVisible(HomePUI.REVIEW_TEXT_AREA);
        sendKeysToElement(HomePUI.REVIEW_TEXT_AREA,reviewText);
    }

    public void ckickToSubmitReviewButton() {
        waitForElementClickable(HomePUI.SUBMIT_REVIEW_BUTTON);
        clickToElement(HomePUI.SUBMIT_REVIEW_BUTTON);
    }

    public String getSubmitReviewResult() {
        waitForElementVisible(HomePUI.SUBMIT_REVIEW_RESULT_MESSAGE);
        return getElementText(HomePUI.SUBMIT_REVIEW_RESULT_MESSAGE);
    }
}
