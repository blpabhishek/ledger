package com.example.service;

import com.example.commands.Command;
import com.example.commands.CommandResult;
import com.example.domain.Ledger;
import com.example.domain.Ledgers;
import com.example.domain.UnknownUserException;
import com.example.parser.Formatter;
import com.example.parser.InputParser;

import java.util.List;

public class LedgerService {
    private final Ledgers ledgers;

    public LedgerService(Ledgers ledgers) {
        this.ledgers = ledgers;
    }

    public CommandResult runCommand(Command command) throws UnknownUserException {
        Ledger ledger = ledgers.getLedger(command.getBank());
        return command.execute(ledger);
    }

    public TransactionStatus execute(String cmd) {
        TransactionStatus transactionStatus = new TransactionStatus();
        try {
            Command command = InputParser.parse(cmd);
            CommandResult result = this.runCommand(command);
            transactionStatus.setResult(result);
            return transactionStatus;
        } catch (Exception e) {
            return transactionStatus.setError(e);
        }
    }

    public static void executeCommands(LedgerService ledgerService, List<String> commands, Formatter consoleFormatter) {
        for (String cmd : commands) {
            TransactionStatus transactionStatus = ledgerService.execute(cmd);
            transactionStatus.print(consoleFormatter);
        }
    }
}
