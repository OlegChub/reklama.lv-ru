package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage {

    private static final String ADD_TO_FAVORITE_BTN = "favs-link";
    private static final String AD_WAS_ADDED_TO_FAVORITE_TEXT = "Удалить из избранного";
    private static final String FAVORITES_COUNT = "favorites_count";
    private static final String FAVORITES_LINK = "favorites-link";
    private static final String PRODUCT_DESCRIPTION = "//div[id='icon_view']/span";

    public WebElement addProductToFavorite() {
        scrollToElement(By.id(ADD_TO_FAVORITE_BTN));
        return findElement(By.id(ADD_TO_FAVORITE_BTN));
    }

    public String getAddWasAddedToFavoriteText() {
        return AD_WAS_ADDED_TO_FAVORITE_TEXT;
    }

    public WebElement getFavoriteCount() {
        scrollToElement(By.id(FAVORITES_COUNT));
        return findElement(By.id(FAVORITES_COUNT));
    }

    public WebElement getFavoritesList() {
        scrollToElement(By.id(FAVORITES_LINK));
        return findElement(By.id(FAVORITES_LINK));
    }

}