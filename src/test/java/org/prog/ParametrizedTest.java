package org.prog;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ParametrizedTest {

    @ParameterizedTest
    @MethodSource("provideStringsForIsBlank")
    public void testParams(String s) {
        System.out.println(s);
        Assertions.assertEquals("test", s);
    }

    private static Stream<Arguments> provideStringsForIsBlank() {
        return Stream.of(
                Arguments.of("test"),
                Arguments.of("test"),
                Arguments.of("this test will fail")
        );
    }
}
