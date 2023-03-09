package org.prog.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OtherSteps {

    @Given("Print message {string}")
    public void printParameter(String input) {
        System.out.println(input);
    }

    @Given("Multiple params {string} go like this {string}")
    public void multipleParams(String input, String secondParam) {
        System.out.println(input);
        System.out.println(secondParam);
    }

    @Given("Int params {int}!")
    public void intParamsTest(int input) {
        System.out.println("this is int!" + input);
    }

    @Given("a parallel given")
    public void aParallelGiven() {
        System.out.println(Thread.currentThread().getId());
    }

    @When("a parallel when")
    public void aParallelWhen() {
        System.out.println(Thread.currentThread().getId());
    }

    @Then("a parallel then")
    public void aParallelThen() {
        System.out.println(Thread.currentThread().getId());
    }
}
