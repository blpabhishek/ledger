package com.example.service;

import com.example.domain.Ledger;
import com.example.domain.Ledgers;
import com.example.domain.Status;
import com.example.domain.UnknownUserException;
import com.example.parser.Command;

public class LedgerService {
    private final Ledgers ledgers;

    public LedgerService(Ledgers ledgers) {
        this.ledgers = ledgers;
    }

    public Status execute(Command cmd) throws UnknownUserException {
        Ledger ledger = ledgers.getLedger(cmd.getBank());
        return cmd.execute(ledger);
    }
}
