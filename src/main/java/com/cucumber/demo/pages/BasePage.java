package com.cucumber.demo.pages;

import com.cucumber.demo.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public abstract class BasePage {

    public WebElement findElement(By by) {
        return DriverManager.getDriver().findElement(by);
    }

    public List<WebElement> findElements(By by) {
        return DriverManager.getDriver().findElements(by);
    }

    public void scrollToElement(By by) {
        WebElement element = DriverManager.getDriver().findElement(by);
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(element);
        actions.perform();
    }

}
