package com.it_academy.onliner.steps;

import com.it_academy.onliner.OnlinerNavigation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_object.HomePage;

import java.util.List;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

public class SubmenuOfCarFleaMarketExistingTest {
    private final HomePage homePage = new HomePage();

    private static final String PRICE_CATEGORY_OF_CAR_FLEA_MARKET_LINK_XPATH_PATTERN =
            "//a[contains(@href, '?price')]/span[contains(@class, 'sign')]";
    private static final String CITY_CATEGORY_OF_CAR_FLEA_MARKET_LINK_XPATH_PATTERN =
            "//a[contains(@href, 'city')]/span[contains(@class, 'sign')]";
    private static final String CATEGORIES_OF_CAR_FLEA_MARKET_LINK_XPATH_PATTERN =
            "//a[contains(@href, 'ab.onliner.by/')]/span[contains(@class, 'sign')]";

    @Given("the user opens onliner website")
    public void theUserOpensOnlinerWebsite() {
        OnlinerNavigation.navigateToOnlinerHomePage();
    }

    @When("the user moves the mouse over on car flea market menu item")
    public void theUserMovesTheMouseOverOnCarFleaMarketMenuItem() {
        homePage.moveOnMainMenuItem("Автобарахолка");
    }

    @Then("a submenu appears and displays categories - division by price, by city and brand")
    public void aSubmenuAppearsAndDisplaysCategoriesDivisionByPriceByCityAndBrand() {
        List<String> textOfPriceCategoryOfCarFleaMarket =
                homePage.getListOfTextOfElements(PRICE_CATEGORY_OF_CAR_FLEA_MARKET_LINK_XPATH_PATTERN);
        List<String> textOfCityCategoryOfCarFleaMarket =
                homePage.getListOfTextOfElements(CITY_CATEGORY_OF_CAR_FLEA_MARKET_LINK_XPATH_PATTERN);
        List<String> textOfCategoriesOfCarFleaMarket =
                homePage.getListOfTextOfElements(CATEGORIES_OF_CAR_FLEA_MARKET_LINK_XPATH_PATTERN);
        List<String> textOfBrandCategoryOfCarFleaMarket =
                textOfCategoriesOfCarFleaMarket.subList(12, textOfCategoriesOfCarFleaMarket.size() - 1);

        assertSoftly(softly -> {
            softly.assertThat(textOfPriceCategoryOfCarFleaMarket).
                    as("В подменю Автобарахолка отсутствует деление по ценам")
                    .doesNotContain("")
                    .hasSizeGreaterThanOrEqualTo(1);
            softly.assertThat(textOfCityCategoryOfCarFleaMarket).
                    as("В подменю Автобарахолка отсутствует деление по городам")
                    .doesNotContain("")
                    .hasSizeGreaterThanOrEqualTo(1);
            softly.assertThat(textOfBrandCategoryOfCarFleaMarket).
                    as("В подменю Автобарахолка отсутствует деление по маркам")
                    .doesNotContain("")
                    .hasSizeGreaterThanOrEqualTo(1);
        });
    }
}
