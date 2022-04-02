package com.example.commands;

import com.example.domain.Ledger;
import com.example.domain.UnknownUserException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoanCommandTest {
    @Test
    void shouldBeAbleToCreateALoanWithLoanCommand() throws UnknownUserException {
        LoanCommand loanCommand = new LoanCommand("IDI", "Bob", 1000, 1, 1);
        Ledger ledger = new Ledger("IDI");
        CommandResult commandResult = loanCommand.execute(ledger);

        CommandResult expectedCommandResult = new CommandResult(CommandType.LOAN, "IDI", "0","12");
        assertEquals(expectedCommandResult, commandResult);
    }
}