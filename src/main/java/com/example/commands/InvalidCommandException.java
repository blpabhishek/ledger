package com.example.commands;

public class InvalidCommandException extends Throwable {
    public InvalidCommandException(String inputCommand) {
        super("Invalid command:" + inputCommand);
    }
}
