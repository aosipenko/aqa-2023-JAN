package org.prog;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.prog.pages.GooglePage;
import org.prog.pages.RozetkaPage;

public class MyFirstUnitTest {

    private static GooglePage googlePage;
    private static RozetkaPage rozetkaPage;

    @BeforeAll
    public static void setUp() {
        WebDriver driver = new ChromeDriver();
        googlePage = new GooglePage(driver);
        rozetkaPage = new RozetkaPage(driver);
    }

    @BeforeEach
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

        Assertions.assertTrue(googlePage.getSearchHeaders().contains("test"));

        rozetkaPage.loadPage();
    }

    @Test
    public void luckySearchTest() {
        googlePage.setSearchValue("aaaaaa");
        googlePage.clearSearchInput();
        googlePage.setSearchValue("test");
        googlePage.feelingLuckySearch();

        Assertions.assertTrue(googlePage.getCurrentUrl().equals("https://www.speedtest.net/"));
    }

    @AfterEach
    public void wrapUp() {
        System.out.println("======================================");
    }

    @AfterAll
    public static void tearDown() {
        googlePage.quiteDriver();
    }
}
