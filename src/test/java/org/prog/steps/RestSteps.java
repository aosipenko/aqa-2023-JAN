package org.prog.steps;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.prog.dto.ResultsDto;
import org.prog.dto.UserDto;
import org.prog.util.DataHolder;

import static org.hamcrest.Matchers.hasItems;

public class RestSteps {

    private final static String REQUEST =
            "https://randomuser.me/api/?inc=gender,name,nat&noinfo&results=20";

    @Given("I generate a random {string}")
    public void generateRandomUser(String alias) {
        DataHolder.getInstance().put(alias, getUserName());
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
