package org.example.Commands;

import org.example.DocumentRepositoryManager;
import org.example.Person;

import java.io.IOException;

public class ListCommand implements Command {
    private final DocumentRepositoryManager documentRepositoryManager;

    public ListCommand(DocumentRepositoryManager documentRepositoryManager) {
        this.documentRepositoryManager = documentRepositoryManager;
    }

    @Override
    public void execute(String[] arguments) throws IOException {
        if (arguments.length != 1) {
            System.out.println("Usage: list <personName>");
            return;
        }
        String personName = arguments[0];
        Person person = new Person(personName, 0);
        try {
            documentRepositoryManager.listDocumentsByPerson(person).forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("An error occurred while listing documents: " + e.getMessage());
        }
    }
}