package org.prog;

import org.junit.jupiter.api.Test;

public class MySecondUnitTest {

    @Test
    public void myBaseTest() {
        System.out.println("Hello, JUnit!");
    }

    @Test
    void errorTest() {
        throw new RuntimeException("this is error!");
    }
}
