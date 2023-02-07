package org.prog;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void main(String... args) {
        ChromeDriver chromeDriver = null;
        try {
            WebDriverManager.chromedriver().setup();

            chromeDriver = new ChromeDriver();
//            chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            chromeDriver.get("https://google.com/");

            WebElement googleBigLogo = chromeDriver.findElement(By.xpath("//img[@alt='Google']"));
            WebElement searchBar = chromeDriver.findElement(By.name("q"));
            searchBar.sendKeys("test search");
            searchBar.sendKeys(Keys.ENTER);

            new WebDriverWait(chromeDriver, Duration.ofSeconds(20))
                    .until(ExpectedConditions.invisibilityOf(googleBigLogo));

            new WebDriverWait(chromeDriver, Duration.ofSeconds(20))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='logo']")));

            System.out.println("done!");
        } finally {
            if (chromeDriver != null) {
                chromeDriver.quit();
            }
        }
    }
}
