package org.example.Commands;

import org.example.Document;
import org.example.DocumentRepositoryManager;
import org.example.Person;

import java.io.IOException;

public class DeleteCommand implements Command {
    private final DocumentRepositoryManager documentRepositoryManager;

    public DeleteCommand(DocumentRepositoryManager documentRepositoryManager) {
        this.documentRepositoryManager = documentRepositoryManager;
    }

    @Override
    public void execute(String[] arguments) {
        if (arguments.length != 3) {
            System.out.println("Usage: delete <personName> <documentName> <documentFormat>");
            return;
        }
        String personName = arguments[0];
        String documentName = arguments[1];
        String documentFormat = arguments[2];
        Person person = new Person(personName, 0);
        Document document = new Document(documentName, documentFormat);
        try {
            documentRepositoryManager.deleteDocument(person, document);
        } catch (IOException e) {
            System.out.println("An error occurred while deleting the document: " + e.getMessage());
        }
    }
}
