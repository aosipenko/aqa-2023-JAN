package org.prog.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RozetkaPage extends AbstractPage {

    private final static String URL = "https://rozetka.com.ua/ua/";

    private final By catalogButton = By.id("fat-menu");
    private final By dropDownCatalogContainer = By.className("menu-wrapper");
    private final By catalogMainItem = By.className("menu-categories__item");

    public RozetkaPage(WebDriver driver) {
        super(URL, driver);
    }

    public void openCatalog() {
        new WebDriverWait(driver, Duration.ofSeconds(60))
                .until(ExpectedConditions.visibilityOfElementLocated(catalogButton))
                .click();
        new WebDriverWait(driver, Duration.ofSeconds(60))
                .until(ExpectedConditions.visibilityOfElementLocated(dropDownCatalogContainer));
    }

    public void selectMainCatalogOption(String category) {
        new WebDriverWait(driver, Duration.ofSeconds(60))
                .until(ExpectedConditions.visibilityOfElementLocated(dropDownCatalogContainer));
        driver.findElements(catalogMainItem).stream()
                .filter(we -> we.getText().contains(category))
                .findFirst().get().click();
    }

    public boolean waitForPageUrl(String url) {
        return new WebDriverWait(driver, Duration.ofSeconds(120))
                .until(ExpectedConditions.urlToBe(url));
    }
}
