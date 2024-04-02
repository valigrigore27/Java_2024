package org.example;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
//        DocumentRepositoryManager documentRepositoryManager = new DocumentRepositoryManager("C:\\Users\\Tuf\\OneDrive\\Desktop\\Programare-Avansata-2024\\Lab05\\Homework\\mainDirectory");
//        DocumentManagementShell shell = new DocumentManagementShell(documentRepositoryManager);
//        shell.start();
//
        DocumentRepositoryManager documentRepositoryManager = new DocumentRepositoryManager("C:\\Users\\Tuf\\OneDrive\\Desktop\\Programare-Avansata-2024\\Lab05\\Homework\\mainDirectory");
        DocumentManagementWithClasses documentManagementWithClasses = new DocumentManagementWithClasses(documentRepositoryManager);
        documentManagementWithClasses.start();
    }
}