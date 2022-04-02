package com.example.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

        Balance balance = ledger.accountBalance("name", 8);

        Balance expectedBalance = new Balance(696, 16);

        assertEquals(expectedBalance, balance);
    }

    @Test
    void shouldThrowExceptionForUnknownUserBalance() {
        Ledger ledger = new Ledger("IDI");
        assertThrows(UnknownUserException.class,
                () -> ledger.accountBalance("name", 8));

    }

    @Test
    void shouldAcceptLumSumPaymentForAnExistingUser() throws UnknownUserException {
        Ledger ledger = new Ledger("IDI");
        ledger.addLoan("name", new Loan(1200, 1, 0));

        assertTrue(ledger.payment("name",1000,2));

        Balance expectedBalance = new Balance(1200, 0);
        assertEquals(expectedBalance, ledger.accountBalance("name",2));
    }

    @Test
    void shouldThrowExceptionForUnknownUserPayment() throws UnknownUserException {
        Ledger ledger = new Ledger("IDI");
        assertThrows(UnknownUserException.class, () -> {
            ledger.payment("name", 1000, 2);
        });
    }
}
