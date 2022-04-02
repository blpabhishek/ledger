package com.example.service;

import com.example.domain.Ledger;
import com.example.domain.Ledgers;
import com.example.commands.CommandResult;
import com.example.domain.UnknownUserException;
import com.example.commands.Command;

public class LedgerService {
    private final Ledgers ledgers;

    public LedgerService(Ledgers ledgers) {
        this.ledgers = ledgers;
    }

    public CommandResult execute(Command cmd) throws UnknownUserException {
        Ledger ledger = ledgers.getLedger(cmd.getBank());
        return cmd.execute(ledger);
    }
}
