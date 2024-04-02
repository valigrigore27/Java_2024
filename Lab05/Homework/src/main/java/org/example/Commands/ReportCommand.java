package org.example.Commands;

import java.awt.*;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.example.DocumentRepositoryManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportCommand implements Command {
    private final DocumentRepositoryManager documentRepositoryManager;

    public ReportCommand(DocumentRepositoryManager documentRepositoryManager) {
        this.documentRepositoryManager = documentRepositoryManager;
    }

    @Override
    public void execute(String[] arguments) {
        if (arguments.length != 1) {
            System.out.println("Usage: report <outputFilePath>");
            return;
        }
        String outputFilePath = arguments[0];
        try {
            generateReport(outputFilePath);
            openReport(outputFilePath);
        } catch (IOException | TemplateException e) {
            System.out.println("An error occurred while generating or opening the report: " + e.getMessage());
        }
    }

    private void generateReport(String outputFilePath) throws IOException, TemplateException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_31);
        configuration.setDirectoryForTemplateLoading(new File("C:\\Users\\Tuf\\OneDrive\\Desktop\\Programare-Avansata-2024\\Lab05\\Homework\\mainDirectory"));
        Template template = configuration.getTemplate("report.ftl");

        List<String> subdirectories = documentRepositoryManager.listSubdirectories();

        Map<String, Object> data = new HashMap<>();
        data.put("subdirectories", subdirectories);

        try (Writer writer = new FileWriter(outputFilePath)) {
            template.process(data, writer);
        }
    }

    private void openReport(String outputFilePath) throws IOException {
        File file = new File(outputFilePath);
        if (!file.exists()) {
            System.out.println("The report file does not exist.");
            return;
        }
        Desktop.getDesktop().open(file);
    }
}
