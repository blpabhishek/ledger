package com.example.parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputParserTest {
    @Test
    void shouldBeAbleToParseTheGivenString() {
        String string = "LOAN IDIDI Dale 10000 5 4";
        InputParser inputParser = new InputParser();
        LoanCommand lc = inputParser.parse(string);

        LoanCommand expected = new LoanCommand("IDIDI","Dale",10000,5,4);

        assertEquals(expected,lc);
    }
}
