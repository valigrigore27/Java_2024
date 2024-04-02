package org.example;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DocumentManagementShell {
    private final DocumentRepositoryManager documentRepositoryManager;
    private final Scanner scanner;

    public DocumentManagementShell(DocumentRepositoryManager documentRepositoryManager) {
        this.documentRepositoryManager = documentRepositoryManager;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Document Management Shell");
        System.out.println("Type 'help' for a list of available commands.");

        boolean running = true;
        while (running) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            String[] parts = input.split("\\s+");
            String command = parts[0];
            String[] arguments = new String[parts.length - 1];
            System.arraycopy(parts, 1, arguments, 0, arguments.length);

            try {
                switch (command) {
                    case "help":
                        displayHelp();
                        break;
                    case "list":
                        listDocuments(arguments);
                        break;
                    case "add":
                        addDocument(arguments);
                        break;
                    case "delete":
                        deleteDocument(arguments);
                        break;
                    case "exit":
                        running = false;
                        break;
                    default:
                        System.out.println("Unknown command. Type 'help' for a list of available commands.");
                        break;
                }
            } catch (IOException e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }

        scanner.close();
    }

    private void displayHelp() {
        System.out.println("Available commands:");
        System.out.println("help - Display this help message");
        System.out.println("list <personName> - List documents for a person");
        System.out.println("add <personName> <documentName> <documentFormat> <filePath> - Add a document for a person");
        System.out.println("delete <personName> <documentName> <documentFormat> - Delete a document for a person");
        System.out.println("exit - Exit the shell");
    }

    public void listDocuments(String[] arguments) throws IOException {
        if (arguments.length != 1) {
            System.out.println("Usage: list <personName>");
            return;
        }
        String personName = arguments[0];
        Person person = new Person(personName, 0); // Folosim un ID fictiv 0
        try {
            documentRepositoryManager.listDocumentsByPerson(person).forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("An error occurred while listing documents: " + e.getMessage());
        }
    }

    public void addDocument(String[] arguments) {
        if (arguments.length != 4) {
            System.out.println("Usage: add <personName> <documentName> <documentFormat> <filePath>");
            return;
        }
        String personName = arguments[0];
        String documentName = arguments[1];
        String documentFormat = arguments[2];
        String filePath = arguments[3];
        Person person = new Person(personName, 0);
        Document document = new Document(documentName, documentFormat);
        File fileToAdd = new File(filePath);
        try {
            documentRepositoryManager.addDocument(person, document, fileToAdd);
        } catch (IOException e) {
            System.out.println("An error occurred while adding the document: " + e.getMessage());
        }
    }

    public void deleteDocument(String[] arguments) {
        if (arguments.length != 3) {
            System.out.println("Usage: delete <personName> <documentName> <documentFormat>");
            return;
        }
        String personName = arguments[0];
        String documentName = arguments[1];
        String documentFormat = arguments[2];
        Person person = new Person(personName, 0); // Folosim un ID fictiv 0
        Document document = new Document(documentName, documentFormat);
        try {
            documentRepositoryManager.deleteDocument(person, document);
        } catch (IOException e) {
            System.out.println("An error occurred while deleting the document: " + e.getMessage());
        }
    }

}
