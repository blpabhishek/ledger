package com.example.commands;

import com.example.domain.Ledger;
import com.example.domain.Loan;
import com.example.domain.UnknownUserException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BalanceCommandTest {

    @Test
    void shouldFetchTheUsersBalance() throws UnknownUserException {
        BalanceCommand balanceCommand = new BalanceCommand("IDI", "Bob", 0);
        Ledger ledger = new Ledger("IDI");
        ledger.addLoan("Bob", new Loan(200, 1, 1));
        CommandResult commandResult = balanceCommand.execute(ledger);

        BalanceCommandResult expectedCommandResult = new BalanceCommandResult("IDI", "Bob", "0", "12");
        assertEquals(expectedCommandResult, commandResult);
    }

    @Test
    void shouldThrowExceptionForInvalidUser() {
        BalanceCommand balanceCommand = new BalanceCommand("IDI", "Bob", 1);
        Ledger ledger = new Ledger("IDI");

        assertThrows(UnknownUserException.class, () -> balanceCommand.execute(ledger));
    }

    @Test
    void shouldThrowInvalidExceptionForWrongCommandParsing() {
        assertThrows(InvalidCommandException.class, () -> BalanceCommand.toBalanceCommand(new String[]{"1", "2"}));
    }
}