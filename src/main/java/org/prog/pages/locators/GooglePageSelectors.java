package org.prog.pages.locators;

import lombok.Getter;
import org.openqa.selenium.By;

public enum GooglePageSelectors {
    SEARCH(By.name("q")),               //locator = By.name("q")
    SEARCH_HEADERS(By.tagName("h3"));   //locator = By.tagName("h3")

    @Getter
    private By locator;

    GooglePageSelectors(By locator) {
        this.locator = locator;
    }
}
