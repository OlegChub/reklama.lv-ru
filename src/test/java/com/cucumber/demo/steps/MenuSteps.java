package com.cucumber.demo.steps;


import com.cucumber.demo.driver.DriverManager;
import com.cucumber.demo.pages.AdsListPage;
import com.cucumber.demo.pages.FavoritesPage;
import com.cucumber.demo.pages.HomePage;
import com.cucumber.demo.pages.ProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MenuSteps {

    private HomePage homePage = new HomePage();
    private AdsListPage adsListPage = new AdsListPage();
    private ProductPage productPage = new ProductPage();
    private FavoritesPage favoritesPage = new FavoritesPage();

    @Given("the user opens website with classifieds")
    public void openClassifiedsHomePage() {
        homePage.openClassifiedsHomePage();
    }

    @When("the user clicks on the {string} menu item")
    public void clickOnMenuItem(String menuItem) {
        homePage.getMenuItem(menuItem).click();
    }

    @When("the user clicks on the {string} submenu item")
    public void clicksOnTheSubmenuItem(String subMenuItem) {
        homePage.getSubMenuItem(subMenuItem).click();
    }

    @When("the user chooses first ad from the list")
    public void chooseFirstAdFromTheList() {
        adsListPage.setAdLink();
        adsListPage.getFirstAdFromTheList().click();
    }

    @And("the user adds product to favorite")
    public void addProductToFavorite() {
        productPage.addProductToFavorite().click();
    }

    @Then("favorite button changes it's text after pressing")
    public void favoriteButtonChangesItsTextAfterPressingCheck() {
        assertThat(productPage.addProductToFavorite()
                .getText())
                .overridingErrorMessage("Expected text is not displayed")
                .isEqualTo(productPage.getAddWasAddedToFavoriteText());
    }

    @And("favorites count increases by one")
    public void favoritesCountIncreasesByOneCheck() {
        assertThat(productPage.getFavoriteCount()
                .getText())
                .overridingErrorMessage("Favorites count is not correct")
                .isEqualTo("1");
    }

    @And("the user goes to his favorites list")
    public void openUserFavoritesListFromProductPage() {
        productPage.getFavoritesList().click();
    }

    @And("the user mouseovers on the first ad from the list and adds it to favorites")
    public void mouseoverOnTheFirstAdFromTheListAndAddItToFavorites() throws InterruptedException {
        Actions builder = new Actions(DriverManager.getDriver());
        builder.moveToElement(adsListPage.getFirstAdFromTheList())
                .moveToElement(adsListPage.addToFavoriteFromAdsListPage()).click()
                .build().perform();
        adsListPage.setAdLink();
    }

    @Then("the user sees added product in his favorites list")
    public void addedProductIsInUserFavoritesList() {
        assertThat(favoritesPage.getProductLinkFromFavoritesList()).isEqualTo(adsListPage.getSavedAdLink());
    }
}
