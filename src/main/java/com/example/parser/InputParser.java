package com.example.parser;

public class InputParser {
    public Command parse(String string) {
        String[] strings = string.split(" ");
        if(strings[0].equals("LOAN"))
            return new LoanCommand(strings[1], strings[2], toInt(strings[3]), toInt(strings[4]), toInt(strings[5]));
        return new BalanceCommand(strings[1],strings[2],toInt(strings[3]));
    }

    private int toInt(String string) {
        return Integer.parseInt(string);
    }
}
