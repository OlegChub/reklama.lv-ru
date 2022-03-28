Feature: As a user I want to have possibility to add products to my favorites list

  Scenario: Favorite button on a product page is active and favorites count increases after adding product to favorite
    Given the user opens website with classifieds
    When the user clicks on the "Одежда" menu item
    And the user clicks on the "Брюки" submenu item
    And the user chooses first ad from the list
    And the user adds product to favorite
    Then favorite button changes it's text after pressing
    And favorites count increases by one

  Scenario: Added favorite product is in user's favorites list
    Given the user opens website with classifieds
    When the user clicks on the "Одежда" menu item
    And the user clicks on the "Брюки" submenu item
    And the user chooses first ad from the list
    And the user adds product to favorite
    And the user goes to his favorites list
    Then the user sees added product in his favorites list

  Scenario: Adding a product to favorite from category page
    Given the user opens website with classifieds
    When the user clicks on the "Одежда" menu item
    And the user clicks on the "Брюки" submenu item
    And the user mouseovers on the first ad from the list and adds it to favorites
    Then favorites count increases by one
    When the user goes to his favorites list
    Then the user sees added product in his favorites list