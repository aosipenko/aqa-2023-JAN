package org.prog;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.prog.dto.ResultsDto;
import org.prog.dto.UserDto;
import org.prog.pages.GooglePage;
import org.prog.pages.RozetkaPage;
import org.testng.Assert;
import org.testng.annotations.*;

import static org.hamcrest.Matchers.hasItems;

public class MyFirstUnitTest {

    private static GooglePage googlePage;
    private static RozetkaPage rozetkaPage;

    private final static String REQUEST =
            "https://randomuser.me/api/?inc=gender,name,nat&noinfo&results=20";

    @BeforeClass
    public static void setUp() {
        WebDriver driver = new ChromeDriver();
        googlePage = new GooglePage(driver);
        rozetkaPage = new RozetkaPage(driver);
    }

    @BeforeTest
    public void loadPage() {
        googlePage.loadPage();
        googlePage.acceptCookiesIfPresent();
    }

    @Test
    public void googlePageTest() {
        googlePage.setSearchValue("aaaaaa");
        googlePage.clearSearchInput();
        googlePage.setSearchValue("test");
        googlePage.performSearch();

        Assert.assertTrue(googlePage.getSearchHeaders()
                .stream().anyMatch(header -> header.contains("test")));
    }

    @Test
    public void luckySearchTest() {
        googlePage.setSearchValue("aaaaaa");
        googlePage.clearSearchInput();
        googlePage.setSearchValue("test");
        googlePage.feelingLuckySearch();

        Assert.assertTrue(googlePage.getCurrentUrl().equals("https://www.speedtest.net/"));
    }

    @Test
    public void rozetkaCategoryTest() {
        String expectedUrl = "https://rozetka.com.ua/ua/computers-notebooks/c80253/";

        rozetkaPage.loadPage();
        rozetkaPage.openCatalog();
        rozetkaPage.selectMainCatalogOption("Ноутбуки та комп’ютери");
        Assert.assertTrue(rozetkaPage.waitForPageUrl(expectedUrl));
    }

    @Test
    public void googleName() {
        String searchName = getUserName();
        googlePage.setSearchValue(searchName);
        googlePage.performSearch();

        Assert.assertTrue(googlePage.getSearchHeaders()
                .stream().anyMatch(header -> header.contains(searchName)));
    }

    @AfterTest
    public void wrapUp() {
        System.out.println("======================================");
    }

    @AfterClass
    public static void tearDown() {
        googlePage.quiteDriver();
    }

    private String getUserName() {
        Response response = RestAssured.get(REQUEST);
        ValidatableResponse validatableResponse = response.then();

        validatableResponse.assertThat()
                .statusCode(200)
                .body("results.gender", hasItems("male", "female"));

        ResultsDto resultsDto = response.as(ResultsDto.class);
        UserDto user = resultsDto.getResults().stream()
                .filter(userDto -> userDto.getGender().equals("male"))
                .findFirst().get();

        return user.getName().getFirst() + " " + user.getName().getLast();
    }
}
