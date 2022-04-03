package com.example.service;

import com.example.commands.Command;
import com.example.commands.InvalidCommandException;
import com.example.commands.CommandResult;
import com.example.domain.Ledger;
import com.example.domain.Ledgers;
import com.example.parser.Formatter;
import com.example.parser.InputParser;

import java.util.List;

public class LedgerService {
    private final Ledgers ledgers;

    public LedgerService(Ledgers ledgers) {
        this.ledgers = ledgers;
    }

    public TransactionStatus execute(Command cmd) {
        Ledger ledger = ledgers.getLedger(cmd.getBank());
        TransactionStatus transactionStatus = new TransactionStatus();
        try {
            CommandResult commandResult = cmd.execute(ledger);
            return transactionStatus.setResult(commandResult);
        } catch (Exception e) {
            return transactionStatus.setError(e);
        }
    }

    public static void executeCommands(List<String> commands, Formatter consoleFormatter) throws InvalidCommandException {
        LedgerService ledgerService = new LedgerService(new Ledgers());
        for (String line : commands) {
            Command command = InputParser.parse(line);
            TransactionStatus transactionStatus = ledgerService.execute(command);
            transactionStatus.print(consoleFormatter);
        }
    }
}
