package org.example;

import org.example.Commands.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DocumentManagementWithClasses {
    private final DocumentRepositoryManager documentRepositoryManager;
    private final Scanner scanner;
    private final Map<String, Command> commandMap;

    public DocumentManagementWithClasses(DocumentRepositoryManager documentRepositoryManager) {
        this.documentRepositoryManager = documentRepositoryManager;
        this.scanner = new Scanner(System.in);

        this.commandMap = new HashMap<>();
        commandMap.put("help", new HelpCommand());
        commandMap.put("list", new ListCommand(documentRepositoryManager));
        commandMap.put("add", new AddCommand(documentRepositoryManager));
        commandMap.put("delete", new DeleteCommand(documentRepositoryManager));
        commandMap.put("view", new ViewCommand());
        commandMap.put("report", new ReportCommand(documentRepositoryManager));
        commandMap.put("export", new ExportCommand(documentRepositoryManager));
        commandMap.put("exit", new ExitCommand());
    }

    public void start() {
        System.out.println("Document Management Shell");
        System.out.println("Type 'help' for a list of available commands.");

        boolean running = true;
        while (running) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            String[] parts = input.split("\\s+");
            String commandName = parts[0];
            String[] arguments = Arrays.copyOfRange(parts, 1, parts.length);

            Command command = commandMap.get(commandName);
            if (command != null) {
                try {
                    command.execute(arguments);
                } catch (IOException e) {
                    System.out.println("An error occurred: " + e.getMessage());
                }
            } else {
                System.out.println("Unknown command. Type 'help' for a list of available commands.");
            }
        }

        scanner.close();
    }
}

