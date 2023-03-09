package org.prog.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestRunFinished;
import io.cucumber.plugin.event.TestRunStarted;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.prog.steps.WebSteps;

import java.net.InetAddress;
import java.net.URL;

public class CucumberHooks implements EventListener {

    @Override
    public void setEventPublisher(EventPublisher eventPublisher) {
        eventPublisher.registerHandlerFor(TestRunStarted.class, this::setUpDriver);
        eventPublisher.registerHandlerFor(TestRunFinished.class, this::tearDown);
    }

    private void setUpDriver(TestRunStarted event) {
        try {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setCapability("enableVNC", true);
            chromeOptions.setCapability("enableVideo", true);
            if ("TSELSE3871808".equals(InetAddress.getLocalHost().getHostName())) {
//                WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
//                WebSteps.driver = driver;
            } else {
//                WebSteps.driver = new RemoteWebDriver(new URL("http://selenoid:4444/wd/hub"), chromeOptions);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void tearDown(TestRunFinished event) {
        System.out.println("All tests finished, shutting down...");
        if (WebSteps.driver != null) {
            WebSteps.driver.quit();
        }
        ;
    }
}
