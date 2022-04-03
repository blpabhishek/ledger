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
        Command cmd = new LoanCommand("IDI", "Bob", 1000, 1, 1);
        TransactionStatus actual = ledgerService.execute(cmd);

        TransactionStatus transactionStatus = new TransactionStatus();
        transactionStatus.setResult(new CommandResult(CommandType.LOAN, "IDI", "0", "12"));

        assertEquals(transactionStatus, actual);
    }

    @Test
    void shouldRecordErrorWhileExecutingCommand() {
        LedgerService ledgerService = new LedgerService(new Ledgers());
        Command cmd = new BalanceCommand("b", "n", 1);
        TransactionStatus actual = ledgerService.execute(cmd);

        TransactionStatus transactionStatus = new TransactionStatus();
        transactionStatus.setError(new UnknownUserException("n"));

        assertEquals(transactionStatus, actual);
    }

    @Test
    void shouldReadTheGivenInputFileAndExecuteCommands() throws InvalidCommandException {
        ArrayList<String> commands = new ArrayList<>();
        commands.add("LOAN IDIDI Dale 120 1 0");
        commands.add("BALANCE IDIDI Dale 6");
        LedgerService.executeCommands(commands, s -> assertEquals("IDIDI 60 6", s));
    }

}
