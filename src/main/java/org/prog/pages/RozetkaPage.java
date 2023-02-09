package org.prog.pages;

import org.openqa.selenium.WebDriver;

public class RozetkaPage extends AbstractPage {

    private final static String URL = "https://rozetka.com.ua/ua/";

    public RozetkaPage(WebDriver driver) {
        super(URL, driver);
    }

    public void typeToSearchValue(String value) {

    }

    public void performSearch() {

    }

    public void selectCatalogOption(String category, String subCategory) {

    }
}
