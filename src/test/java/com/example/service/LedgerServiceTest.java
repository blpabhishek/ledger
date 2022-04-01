package com.example.service;

import com.example.domain.Ledgers;
import com.example.parser.Command;
import com.example.parser.LoanCommand;
import org.junit.jupiter.api.Test;

public class LedgerServiceTest {
    @Test
    void shouldExecuteCommandsOnLedger() {
        LedgerService ledgerService = new LedgerService(new Ledgers());
        Command cmd = new LoanCommand("IDI","Bob",1000,1,1);
        ledgerService.execute(cmd);
    }
}
