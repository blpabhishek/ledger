package com.example.parser;

import com.example.commands.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputParserTest {
    @Test
    void shouldBeAbleToParseTheGivenString() throws InvalidCommandException {
        String string = "LOAN IDIDI Dale 10000 5 4";
        InputParser inputParser = new InputParser();
        Command lc = inputParser.parse(string);

        LoanCommand expected = new LoanCommand("IDIDI", "Dale", 10000, 5, 4);

        assertEquals(expected, lc);
    }

    @Test
    void shouldBeAbleToParseTheGivenBalanceCommand() throws InvalidCommandException {
        String string = "BALANCE IDIDI Dale 5";
        InputParser inputParser = new InputParser();
        Command lc = inputParser.parse(string);

        Command expected = new BalanceCommand("IDIDI", "Dale", 5);

        assertEquals(expected, lc);
    }

    @Test
    void shouldBeAbleToParsePaymentCommand() throws InvalidCommandException {
        String string = "PAYMENT IDIDI Dale 1000 5";
        InputParser inputParser = new InputParser();
        Command lc = inputParser.parse(string);

        Command expected = new PaymentCommand("IDIDI", "Dale", 1000,5);

        assertEquals(expected, lc);
    }

    @Test
    void shouldThrowInvalidCommandExceptionOnInvalidCommands() {
        String string = "PAY";
        InputParser inputParser = new InputParser();

        assertThrows(InvalidCommandException.class,()->inputParser.parse(string));

    }
}
