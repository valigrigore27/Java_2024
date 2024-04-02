package org.example.Commands;

import org.example.Document;
import org.example.DocumentRepositoryManager;
import org.example.Person;

import java.io.File;
import java.io.IOException;

public class AddCommand implements Command {
    private final DocumentRepositoryManager documentRepositoryManager;

    public AddCommand(DocumentRepositoryManager documentRepositoryManager) {
        this.documentRepositoryManager = documentRepositoryManager;
    }

    @Override
    public void execute(String[] arguments) {
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
}