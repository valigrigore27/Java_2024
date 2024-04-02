package org.example.Commands;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.example.DocumentRepositoryManager;

import java.io.File;
import java.io.IOException;

public class ExportCommand implements Command {
    private final DocumentRepositoryManager documentRepositoryManager;

    public ExportCommand(DocumentRepositoryManager documentRepositoryManager) {
        this.documentRepositoryManager = documentRepositoryManager;
    }

    @Override
    public void execute(String[] arguments) {
        if (arguments.length != 1) {
            System.out.println("Usage: export <outputFilePath>");
            return;
        }
        String outputFilePath = arguments[0];
        try {
            exportDocuments(outputFilePath);
            System.out.println("Export completed successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while exporting the documents: " + e.getMessage());
        }
    }

    private void exportDocuments(String outputFilePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        File outputFile = new File(outputFilePath);
        objectMapper.writeValue(outputFile, documentRepositoryManager.listSubdirectories());
    }
}
