package org.prog.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.prog.dto.ResultsDto;
import org.prog.dto.UserDto;
import org.prog.pages.GooglePage;
import org.prog.pages.RozetkaPage;

import static org.hamcrest.Matchers.hasItems;

public class WebSteps {

    private final static String REQUEST =
            "https://randomuser.me/api/?inc=gender,name,nat&noinfo&results=20";

    public static WebDriver driver;
    private GooglePage googlePage = new GooglePage(driver);
    private RozetkaPage rozetkaPage = new RozetkaPage(driver);

    private UserDto randomUser;

    @Given("I generate a random Person")
    public void generateRandomUser() {
        randomUser = getUserName();
    }

    @Given("I load google page")
    public void openGooglePage() {
        googlePage.loadPage();
        googlePage.acceptCookiesIfPresent();
    }

    @When("I google for random Person")
    public void searchForRandomPerson() {
        String searchValue = randomUser.getName().getFirst() +
                " " + randomUser.getName().getLast();
        googlePage.setSearchValue(searchValue);
        googlePage.performSearch();
    }

    @Then("I can see random Persons name in search results")
    public void validateSearchResults() {
        String searchValue = randomUser.getName().getFirst() +
                " " + randomUser.getName().getLast();
        Assertions.assertTrue(googlePage.getSearchHeaders().stream()
                .anyMatch(header -> header.contains(searchValue)));
    }

    private UserDto getUserName() {
        Response response = RestAssured.get(REQUEST);
        ValidatableResponse validatableResponse = response.then();

        validatableResponse.assertThat()
                .statusCode(200)
                .body("results.gender", hasItems("male", "female"));

        ResultsDto resultsDto = response.as(ResultsDto.class);
        return resultsDto.getResults().stream()
                .filter(userDto -> userDto.getGender().equals("male"))
                .findFirst().get();
    }
}
