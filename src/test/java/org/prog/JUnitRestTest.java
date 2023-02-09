package org.prog;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;
import org.prog.dto.ResultsDto;

import static org.hamcrest.Matchers.hasItems;

public class JUnitRestTest {

    private final static String REQUEST =
            "https://randomuser.me/api/?inc=gender,name,nat&noinfo&results=20";

    @Test
    public void myRestTest() {
        Response response = RestAssured
//                .given()
//                .auth()
//                .basic("", "")
                .get(REQUEST);
        response.prettyPrint();

        ValidatableResponse validatableResponse = response.then();

        validatableResponse.assertThat()
                .statusCode(200)
                .body("results.gender", hasItems("male", "female"));

        ResultsDto resultsDto = response.as(ResultsDto.class);
        resultsDto.getResults().stream()
                .forEach(user -> {
                    System.out.print(user.getName().getFirst());
                    System.out.print(" ");
                    System.out.println(user.getName().getLast());
                });
    }
}
