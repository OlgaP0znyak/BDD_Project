Feature: As a user
  I want to use car flea market menu item
  So that I can see submenu of car flea market

  Scenario: when you hover over the car flea market menu item,
  a submenu appears and displays categories - division by price, by city and brand

    Given the user opens onliner website
    When the user moves the mouse over on car flea market menu item
    Then a submenu appears and displays categories - division by price, by city and brand












