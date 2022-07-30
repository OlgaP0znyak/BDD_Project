package com.it_academy.onliner.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_object.HomePage;

import java.util.List;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

public class SubmenuHousesAndFlatsExistingTest {
    private final HomePage homePage = new HomePage();

    private static final String CITY_CATEGORY_OF_HOUSES_AND_FLATS_LINK_XPATH_PATTERN =
            "//a[contains(@href, 'pk/#bounds')]/span[contains(@class, 'sign')]";
    private static final String ROOMS_CATEGORY_OF_HOUSES_AND_FLATS_LINK_XPATH_PATTERN =
            "//a[contains(@href, 'pk/?number')]/span[contains(@class, 'sign')]";
    private static final String PRICE_CATEGORY_OF_OF_HOUSES_AND_FLATS_LINK_XPATH_PATTERN =
            "//a[contains(@href, 'pk/#price')]/span[contains(@class, 'sign')]";

    @When("the user moves the mouse over on houses and flats menu item")
    public void theUserMovesTheMouseOverOnHousesAndFlatsMenuItem() {
        homePage.moveOnMainMenuItem("���� � ��������");
    }

    @Then("a submenu appears and displays categories - division by city, by rooms and price")
    public void aSubmenuAppearsAndDisplaysCategoriesDivisionByCityByRoomsAndPrice() {
        List<String> textOfCityCategoryOfHousesAndFlats =
                homePage.getListOfTextOfElements(CITY_CATEGORY_OF_HOUSES_AND_FLATS_LINK_XPATH_PATTERN);
        List<String> textOfRoomsCategoryOfHousesAndFlats =
                homePage.getListOfTextOfElements(ROOMS_CATEGORY_OF_HOUSES_AND_FLATS_LINK_XPATH_PATTERN);
        List<String> textOfPriceCategoryOfHousesAndFlats =
                homePage.getListOfTextOfElements(PRICE_CATEGORY_OF_OF_HOUSES_AND_FLATS_LINK_XPATH_PATTERN);

        assertSoftly(softly -> {
            softly.assertThat(textOfCityCategoryOfHousesAndFlats).
                    as("� ������� �������� � ���� ����������� ������� �� �������")
                    .doesNotContain("")
                    .hasSizeGreaterThanOrEqualTo(1);
            softly.assertThat(textOfRoomsCategoryOfHousesAndFlats).
                    as("� ������� �������� � ���� ����������� ������� �� ���������� ������")
                    .doesNotContain("")
                    .hasSizeGreaterThanOrEqualTo(1);
            softly.assertThat(textOfPriceCategoryOfHousesAndFlats).
                    as("� ������� �������� � ���� ����������� ������� �� �����")
                    .doesNotContain("")
                    .hasSizeGreaterThanOrEqualTo(1);
        });
    }
}
