package org.prog.steps;

import io.cucumber.java.en.Given;

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
}
