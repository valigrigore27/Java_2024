package org.example;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        DocumentRepositoryManager documentRepositoryManager = new DocumentRepositoryManager("C:\\Users\\Tuf\\OneDrive\\Desktop\\Programare Avansata-2024\\Lab05\\Compulsory\\mainDirectory");
        documentRepositoryManager.listSubdirectories();
        Person person = new Person("Bogdan", 1);
        Document document = new Document("1", "txt");







        //System.out.println(documentRepositoryManager.pathOfAFileOfDirectorPerson(person, document));
        //documentRepositoryManager.deleteDocument(person, document);
        //System.out.println(documentRepositoryManager.pathOfPerson(person));
        //System.out.println(documentRepositoryManager.listDocumentsByPerson(person));

        //File file = new File("C:\\Users\\Tuf\\OneDrive\\Desktop\\Programare Avansata-2024\\Lab05\\Compulsory\\mainDirectory");
        //documentRepositoryManager.addDocument(person, document, file);
    }
}