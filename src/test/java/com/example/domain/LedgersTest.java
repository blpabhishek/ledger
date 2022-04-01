package com.example.domain;

import com.example.Ledgers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LedgersTest {
    @Test
    void shouldBeAbleToFindALedgerForAGivenBank() {
        Ledgers ledgers = new Ledgers();
        Ledger mbi = ledgers.getLedger("MBI");

        Ledger expectedLedger = new Ledger("MBI");

        assertEquals(expectedLedger,mbi);
    }

    @Test
    void shouldFindTheGivenExistingBankLedger() {
        Ledgers ledgers = new Ledgers();
        Ledger mbi = ledgers.getLedger("MBI");
        ledgers.getLedger("IDI");

        Ledger expectedLedger = ledgers.getLedger("MBI");

        assertEquals(expectedLedger,mbi);
    }

}
