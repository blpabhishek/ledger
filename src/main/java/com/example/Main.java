package com.example;

import com.example.commands.InvalidCommandException;
import com.example.service.LedgerService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        try {
            String filePath = args[0];
            LedgerService.executeCommands(Files.readAllLines(Path.of(filePath)), System.out::println);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Usage: Provide filePath as a command line argument");
        } catch (IOException | InvalidCommandException e) {
            System.err.println(e.getMessage());
        }
    }
}