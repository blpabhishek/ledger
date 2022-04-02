package com.example.domain;

import com.example.commands.CommandResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LedgerTest {
    @Test
    void ledgerShouldRecordTheTransaction() {
        Ledger ledger = new Ledger("MBI");
        ledger.addLoan("name", new Loan(200, 2, 2));

        assertEquals(1, ledger.count());
    }

    @Test
    void ledgerShouldGiveTheStatusForTheGivenUser() throws UnknownUserException {
        Ledger ledger = new Ledger("IDI");
        ledger.addLoan("name", new Loan(2000, 2, 2));
        CommandResult commandResult = ledger.getBalance("name", 8);

        CommandResult expectedCommandResult = new CommandResult("IDI", 696, 16);

        assertEquals(expectedCommandResult, commandResult);
    }

    @Test
    void shouldThrowExceptionForUnknownUserBalance() {
        Ledger ledger = new Ledger("IDI");
        assertThrows(UnknownUserException.class,
                () -> ledger.getBalance("name", 8));

    }

    @Test
    void shouldAcceptLumSumPaymentForAnExistingUser() throws UnknownUserException {
        Ledger ledger = new Ledger("IDI");
        ledger.addLoan("name", new Loan(1200, 1, 0));
        CommandResult commandResult = ledger.payment("name", 1000, 2);

        CommandResult expectedCommandResult = new CommandResult("IDI", 1200, 0);
        assertEquals(expectedCommandResult, commandResult);
    }

    @Test
    void shouldThrowExceptionForUnknownUserPayment() throws UnknownUserException {
        Ledger ledger = new Ledger("IDI");
        assertThrows(UnknownUserException.class, () -> {
            ledger.payment("name", 1000, 2);
        });
    }
}
