package org.prog.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.prog.dto.UserDto;
import org.prog.pages.GooglePage;
import org.prog.pages.RozetkaPage;
import org.prog.pages.locators.GooglePageSelectors;
import org.prog.util.DataHolder;
import org.testng.Assert;

public class WebSteps {
    public static WebDriver driver;
    private GooglePage googlePage = new GooglePage(driver);
    private RozetkaPage rozetkaPage = new RozetkaPage(driver);

    @Given("I load google page")
    public void openGooglePage() {
        googlePage.loadPage();
        googlePage.acceptCookiesIfPresent();
    }

    @When("I google for person {string}")
    public void searchForRandomPerson(String alias) {
        UserDto userDto = (UserDto) DataHolder.getInstance().get(alias);
        googlePage.setSearchValue(getUserName(userDto));
        googlePage.performSearch();
    }

    @Then("I can see {string} name in search results")
    public void validateSearchResults(String alias) {
        UserDto userDto = (UserDto) DataHolder.getInstance().get(alias);
        String searchValue = getUserName(userDto);
        Assert.assertTrue(googlePage.getSearchHeaders().stream()
                .anyMatch(header -> header.contains(searchValue)));
    }

    @When("I set {} value to name of {string}")
    public void searchForName(GooglePageSelectors gps, String alias) {
        UserDto userDto = (UserDto) DataHolder.getInstance().get(alias);
        String searchValue = getUserName(userDto);
        driver.findElement(gps.getLocator()).sendKeys(searchValue);
    }

    @When("I send key {} to {}")
    public void clickButton(Keys keys, GooglePageSelectors gps) {
        driver.findElement(gps.getLocator()).sendKeys(keys);
    }

    @Then("I see {string} name in {}")
    public void checkSearchResults(String alias, GooglePageSelectors gps) {
        UserDto userDto = (UserDto) DataHolder.getInstance().get(alias);
        String searchValue = getUserName(userDto);
        Assert.assertTrue(driver.findElements(gps.getLocator()).stream()
                .anyMatch(webElement -> webElement.getText().contains(searchValue)));
    }

    private String getUserName(UserDto randomUser) {
        return randomUser.getName().getFirst() +
                " " + randomUser.getName().getLast();
    }
}
