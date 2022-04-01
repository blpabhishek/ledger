package com.example.service;

import com.example.domain.Ledgers;
import com.example.parser.Command;

public class LedgerService {
    private Ledgers ledgers;

    public LedgerService(Ledgers ledgers) {
        this.ledgers = ledgers;
    }


    public void execute(Command cmd) {
//        cmd.execute();
    }
}
