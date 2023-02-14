package org.prog.cucumber;

import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestRunFinished;
import io.cucumber.plugin.event.TestRunStarted;
import org.openqa.selenium.chrome.ChromeDriver;
import org.prog.steps.WebSteps;

public class CucumberHooks implements EventListener {

    @Override
    public void setEventPublisher(EventPublisher eventPublisher) {
        eventPublisher.registerHandlerFor(TestRunStarted.class, this::setUpDriver);
        eventPublisher.registerHandlerFor(TestRunFinished.class, this::tearDown);
    }

    private void setUpDriver(TestRunStarted event) {
//        WebSteps.driver = new ChromeDriver();
    }

    private void tearDown(TestRunFinished event) {
        System.out.println("All tests finished, shutting down...");
//        WebSteps.driver.quit();
    }
}
