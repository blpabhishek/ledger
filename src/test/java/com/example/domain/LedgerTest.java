package com.example.domain;

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
        Status status = ledger.getBalance("name", 8);

        Status expectedStatus = new Status("IDI",696, 16);

        assertEquals(expectedStatus, status);
    }

    @Test
    void shouldThrowExceptionForUnknownUserBalance() {
        Ledger ledger = new Ledger("IDI");
        assertThrows(UnknownUserException.class,
                () -> ledger.getBalance("name", 8));

    }
}
