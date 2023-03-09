package org.prog.cucumber;

import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestCaseFinished;
import io.cucumber.plugin.event.TestRunStarted;
import org.prog.pages.WebDriverFactory;
import org.prog.util.DataHolder;

public class CucumberHooks implements EventListener {

    @Override
    public void setEventPublisher(EventPublisher eventPublisher) {
        eventPublisher.registerHandlerFor(TestRunStarted.class, this::setUpHolder);
        eventPublisher.registerHandlerFor(TestCaseFinished.class, this::tearDown);
    }

    private void setUpHolder(TestRunStarted event) {

    }

    private void tearDown(TestCaseFinished event) {
        System.out.println("Test run finished, shutting down...");
        WebDriverFactory.getInstance().endSession();
    }
}
