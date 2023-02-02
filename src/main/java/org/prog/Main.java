package org.prog;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String... args) {
        ChromeDriver chromeDriver = null;
        try {
            WebDriverManager.chromedriver().setup();

            chromeDriver = new ChromeDriver();
            chromeDriver.get("https://google.com/");
            WebElement searchBar = chromeDriver.findElement(By.name("q"));
            searchBar.sendKeys("test search");
            searchBar.sendKeys(Keys.ENTER);
        } finally {
            if (chromeDriver != null) {
                chromeDriver.quit();
            }
        }
    }
}
