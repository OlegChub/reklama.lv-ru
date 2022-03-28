package pages;

import org.openqa.selenium.By;

public class FavoritesPage extends BasePage {
    private static final String AD_FROM_FAVORITES_LIST_PAGE = "//tbody/tr/td[@class='img']/a";

    public String getProductLinkFromFavoritesList() {
        return findElements(By.xpath(AD_FROM_FAVORITES_LIST_PAGE)).get(0).getAttribute("href");
    }
}
