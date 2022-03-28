package com.cucumber.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AdsListPage extends BasePage {

    private static final String IMAGES_OF_ADS = "//tbody/tr//img[@class='ad-photo']";
    private static String savedAdLink;

    public WebElement getFirstAdFromTheList() {
        return findElements(By.xpath(IMAGES_OF_ADS)).get(0);
    }

    public WebElement addToFavoriteFromAdsListPage() {
        return findElement(By.xpath("//a[@class='fav-add']/img"));
    }

    public void setAdLink() {
        savedAdLink = findElements(By.xpath("//tbody/tr/td[@class='img']/a")).get(0).getAttribute("href");
    }

    public String getSavedAdLink() {
        return savedAdLink;
    }
}