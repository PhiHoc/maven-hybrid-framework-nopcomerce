package com.nopcomerce.pageObjects.admin;

import commons.BaseComponent;
import org.openqa.selenium.WebDriver;

public class AdminDashboardPO extends BaseComponent {
    private WebDriver driver;
    public AdminDashboardPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
