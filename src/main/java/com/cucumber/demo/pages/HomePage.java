package com.cucumber.demo.pages;

import com.cucumber.demo.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static java.lang.String.format;

public class HomePage extends BasePage {

    private static final String CLASSIFIEDS_HOME_URL = "https://www.reklama.lv/ru/";
    private static final String MENU_LINK_PATTERN = "//h3[text()='%s']";
    private static final String SUBMENU_LINK_PATTERN = "//h2/a[text()='%s']";

    public void openClassifiedsHomePage() {
        DriverManager.getDriver().get(CLASSIFIEDS_HOME_URL);
    }

    public WebElement getMenuItem(String linkText) {
        return findElement(By.xpath(format(MENU_LINK_PATTERN, linkText)));
    }

    public WebElement getSubMenuItem(String linkText) {
        return findElement(By.xpath(format(SUBMENU_LINK_PATTERN, linkText)));
    }
}
