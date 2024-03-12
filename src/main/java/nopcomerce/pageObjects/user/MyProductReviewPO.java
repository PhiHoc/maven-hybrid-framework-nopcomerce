package nopcomerce.pageObjects.user;

import nopcomerce.PageUIs.user.MyProductReviewPUI;
import org.openqa.selenium.WebDriver;

public class MyProductReviewPO extends MyAccountPO{
    public MyProductReviewPO(WebDriver driver) {
        super(driver);
    }

    public String getReviewTitleText() {
        waitForElementVisible(MyProductReviewPUI.REVIEW_TITLE_TEXT);
        return getElementText(MyProductReviewPUI.REVIEW_TITLE_TEXT);
    }

    public String getReviewContentText() {
        waitForElementVisible(MyProductReviewPUI.REVIEW_CONTENT_TEXT);
        return getElementText(MyProductReviewPUI.REVIEW_CONTENT_TEXT);
    }
}
