package com.example.parser;

import com.example.commands.*;

public class InputParser {
    public Command parse(String string) throws InvalidCommandException {
        String[] arguments = string.split(" ");
        if (arguments.length < 4) {
            throw new InvalidCommandException();
        }
        String commandName = arguments[0];
        if (commandName.equals("LOAN"))
            return LoanCommand.toLoanCommand(arguments);
        if (commandName.equals("PAYMENT"))
            return PaymentCommand.toPaymentCommand(arguments);
        if (commandName.equals("BALANCE"))
            return BalanceCommand.toBalanceCommand(arguments);
        throw new InvalidCommandException();
    }

}
