package org.prog.pages;

import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.InetAddress;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class WebDriverFactory {

    private final static WebDriverFactory webDriverFactory = new WebDriverFactory();
    private final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private final static List<WebDriver> activeDrivers = new ArrayList<>();

    private WebDriverFactory() {

    }

    public static WebDriverFactory getInstance() {
        return webDriverFactory;
    }

    @SneakyThrows
    public WebDriver getDriver(DriverName driverName) {
        if (driverThreadLocal.get() != null) {
            return driverThreadLocal.get();
        }
        switch (driverName) {
            case CHROME:
                return constructDriver(chromeOptions());
            case FIREFOX:
                return constructDriver(firefoxOptions());
            default:
                throw new RuntimeException("Unknow driver type");
        }
    }

    public void endSession() {
        activeDrivers.stream().forEach(d -> {
            if (d != null) {
                d.quit();
            }
        });
    }

    @SneakyThrows
    private WebDriver constructDriver(AbstractDriverOptions options) {
        if ("TSELSE3871808".equals(InetAddress.getLocalHost().getHostName())) {
            driverThreadLocal.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options));
        } else {
            driverThreadLocal.set(new RemoteWebDriver(new URL("http://selenoid:4444/wd/hub"), options));
        }
        activeDrivers.add(driverThreadLocal.get());
        return driverThreadLocal.get();
    }

    private ChromeOptions chromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("enableVNC", true);
        chromeOptions.setCapability("enableVideo", true);
        return chromeOptions;
    }

    private FirefoxOptions firefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability("enableVNC", true);
        options.setCapability("enableVideo", true);
        return options;
    }
}
