package org.example.Commands;

public class HelpCommand implements Command {
    @Override
    public void execute(String[] arguments) {
        System.out.println("Available commands:");
        System.out.println("help - Display this help message");
        System.out.println("list <personName> - List documents for a person");
        System.out.println("add <personName> <documentName> <documentFormat> <filePath> - Add a document for a person");
        System.out.println("delete <personName> <documentName> <documentFormat> - Delete a document for a person");
        System.out.println("view <personName> <documentName> <documentFormat> - View a document for a person");
        System.out.println("report <outputFilePath> - Generate and open a report of the repository in HTML format");
        System.out.println("export <outputFilePath> - Export the repository to a JSON file");
        System.out.println("exit - Exit the shell");
    }
}
