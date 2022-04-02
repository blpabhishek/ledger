package com.example.parser;

import com.example.commands.BalanceCommand;
import com.example.commands.Command;
import com.example.commands.LoanCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputParserTest {
    @Test
    void shouldBeAbleToParseTheGivenString() {
        String string = "LOAN IDIDI Dale 10000 5 4";
        InputParser inputParser = new InputParser();
        Command lc = inputParser.parse(string);

        LoanCommand expected = new LoanCommand("IDIDI", "Dale", 10000, 5, 4);

        assertEquals(expected, lc);
    }

    @Test
    void shouldBeAbleToParseTheGivenBalanceCommand() {
        String string = "BALANCE IDIDI Dale 5";
        InputParser inputParser = new InputParser();
        Command lc = inputParser.parse(string);

        Command expected = new BalanceCommand("IDIDI", "Dale", 5);

        assertEquals(expected, lc);
    }
}
