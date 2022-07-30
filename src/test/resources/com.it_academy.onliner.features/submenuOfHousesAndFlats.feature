Feature: As a user
  I want to use houses and flats menu item
  So that I can see submenu of houses and flats

  Scenario: when you hover over the houses and flats menu item,
  a submenu appears and displays categories - division by city, by rooms and price

    Given the user opens onliner website
    When the user moves the mouse over on houses and flats menu item
    Then a submenu appears and displays categories - division by city, by rooms and price
