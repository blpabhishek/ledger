package com.example.service;

import com.example.commands.*;
import com.example.domain.Ledgers;
import com.example.domain.UnknownUserException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LedgerServiceTest {
    @Test
    void shouldExecuteCommandsOnLedger() {
        LedgerService ledgerService = new LedgerService(new Ledgers());
        String command = "LOAN IDI Bob 1000 1 1";
        TransactionStatus actual = ledgerService.execute(command);

        TransactionStatus transactionStatus = new TransactionStatus();
        transactionStatus.setResult(new CommandResult(CommandType.LOAN));

        assertEquals(transactionStatus, actual);
    }

    @Test
    void shouldRecordErrorWhileExecutingCommand() {
        LedgerService ledgerService = new LedgerService(new Ledgers());
        String command = "BALANCE IDI Bob 1000 1 1";
        TransactionStatus actual = ledgerService.execute(command);

        TransactionStatus transactionStatus = new TransactionStatus();
        transactionStatus.setError(new UnknownUserException("Bob"));

        assertEquals(transactionStatus, actual);
    }

    @Test
    void shouldRecordUnknownCommandWhileExecutingCommand() {
        LedgerService ledgerService = new LedgerService(new Ledgers());
        String command = "BAL IDI Bob 1000 1 1";
        TransactionStatus actual = ledgerService.execute(command);

        TransactionStatus transactionStatus = new TransactionStatus();
        transactionStatus.setError(new InvalidCommandException("BAL IDI Bob 1000 1 1"));

        assertEquals(transactionStatus, actual);
    }

    @Test
    void shouldReadTheGivenInputFileAndExecuteCommands() {
        ArrayList<String> commands = new ArrayList<>();
        commands.add("LOAN IDIDI Dale 120 1 0");
        commands.add("BALANCE IDIDI Dale 6");
        LedgerService ledgerService = new LedgerService(new Ledgers());
        LedgerService.executeCommands(ledgerService, commands, s -> assertEquals("IDIDI 60 6", s));
    }

}
