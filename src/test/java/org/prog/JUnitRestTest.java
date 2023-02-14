package org.prog;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;
import org.prog.dto.ResultsDto;
import org.prog.dto.UserDto;

import java.util.List;
import java.util.Random;

import static org.hamcrest.Matchers.hasItems;

public class JUnitRestTest {

    private final static String REQUEST = "https://randomuser.me/api/?inc=gender,name,nat&noinfo&results=20";

    @Test
    public void myRestTest() {
        Response response = RestAssured.get(REQUEST);
        ValidatableResponse validatableResponse = response.then();

        validatableResponse.assertThat().statusCode(200).body("results.gender", hasItems("male", "female"));

        ResultsDto resultsDto = response.as(ResultsDto.class);
//        resultsDto.getResults().stream()
//                .forEach(user -> {
//                    System.out.print(user.getName().getFirst());
//                    System.out.print(" ");
//                    System.out.println(user.getName().getLast());
//                });
        Random random = new Random();
        List<UserDto> users = resultsDto.getResults();
        UserDto randomUser = users.get(random.nextInt(users.size()));
        System.out.println(
                randomUser.getName().getFirst() + " " + randomUser.getName().getLast());
    }
}
