package org.prog.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class GooglePage extends AbstractPage {
    private final static String URL = "https://google.com/";

    public GooglePage(WebDriver driver) {
        super(URL, driver);
    }

    public void acceptCookiesIfPresent() {
        List<WebElement> btns = driver.findElements(By.tagName("button"));
        if (btns.size() > 1) {
            btns.get(3).click();
        } else {
            System.out.println("no cookies are displayed");
        }
    }

    public void setSearchValue(String value) {
        clearSearchInput();
        driver.findElement(By.name("q")).sendKeys(value);
    }

    public void clearSearchInput() {
        driver.findElement(By.name("q")).clear();
    }

    public void performSearch() {
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }

    public void feelingLuckySearch() {
        driver.findElements(By.name("btnI")).stream()
                .filter(WebElement::isDisplayed)
                .findFirst().ifPresent(WebElement::click);
    }

    public List<String> getSearchHeaders() {
        return driver.findElements(By.tagName("h3")).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
