package com.example.service;

import com.example.domain.Ledgers;
import com.example.commands.CommandResult;
import com.example.domain.UnknownUserException;
import com.example.commands.Command;
import com.example.commands.LoanCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LedgerServiceTest {
    @Test
    void shouldExecuteCommandsOnLedger() throws UnknownUserException {
        LedgerService ledgerService = new LedgerService(new Ledgers());
        Command cmd = new LoanCommand("IDI", "Bob", 1000, 1, 1);
        CommandResult commandResult = ledgerService.execute(cmd);

        CommandResult expectedCommandResult = new CommandResult("IDI", 0, 12);
        assertEquals(expectedCommandResult, commandResult);
    }
}
