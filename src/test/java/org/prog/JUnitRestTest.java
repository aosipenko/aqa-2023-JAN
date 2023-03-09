package org.prog;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.prog.dto.ResultsDto;
import org.prog.dto.UserDto;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

import static org.hamcrest.Matchers.hasItems;

public class JUnitRestTest {

    private final static String REQUEST = "https://randomuser.me/api/?inc=gender,name,nat&noinfo&results=20";

    @Test
    public void criticalTest() {
        List<UserDto> users = getUsers();
        Assert.assertEquals("female", extractUser(users).getGender());
    }

    @Test
    public void blockerTest() {
        List<UserDto> users = getUsers();
        Assert.assertEquals("female", extractUser(users).getGender());
    }

    @Test
    public void minorTestOne() {
        List<UserDto> users = getUsers();
        Assert.assertEquals("female", extractUser(users).getGender());
    }

    @Test
    public void minorTestTwo() {
        List<UserDto> users = getUsers();
        guessUserGender(users);
    }

    private List<UserDto> getUsers() {
        Response response = RestAssured.get(REQUEST);
        ValidatableResponse validatableResponse = response.then();

        validatableResponse.assertThat().statusCode(200).body("results.gender", hasItems("male", "female"));

        return response.as(ResultsDto.class).getResults();
    }

    private UserDto extractUser(List<UserDto> users) {
        Random random = new Random();
        return users.get(random.nextInt(users.size()));
    }

    private void guessUserGender(List<UserDto> users) {
        Assert.assertEquals("female", extractUser(users).getGender());
    }
}
