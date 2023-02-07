package org.prog;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyFirstUnitTest {

    @Test
    public void myBaseTest() {
        System.out.println("Hello, JUnit!");
    }

    @Test
    void assertionTest() {
        System.out.println("Hello, another test!");
        Assertions.assertEquals("a", "b");
    }
}
