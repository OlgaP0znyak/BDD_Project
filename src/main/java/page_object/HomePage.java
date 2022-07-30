package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AbstractPage {
    private static final String MAIN_MENU_LINK_XPATH_PATTERN =
            "//*[contains(@class, 'b-main-navigation__text') and contains(text(), '%s')]";

    public void moveOnMainMenuItem(String link) {
        WebElement mainMenuItem;
        mainMenuItem =
                waitForElementVisible(By.xpath(String.format(MAIN_MENU_LINK_XPATH_PATTERN, link)))
                        .findElement(By.xpath(String.format(MAIN_MENU_LINK_XPATH_PATTERN, link)));
        moveToElement(mainMenuItem);
    }

    public List<String> getListOfTextOfElements(String locator) {
        List<WebElement> webElements;
        List<String> textOfWebElements = new ArrayList<>();
        webElements = waitForElementVisible(By.xpath(locator))
                .findElements(By.xpath(locator));
        webElements.forEach(webElement -> textOfWebElements.add(webElement.getText()));
        return textOfWebElements;
    }
}
