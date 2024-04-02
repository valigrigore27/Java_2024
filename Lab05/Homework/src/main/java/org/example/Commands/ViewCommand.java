package org.example.Commands;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ViewCommand implements Command {
    @Override
    public void execute(String[] arguments) {
        if (arguments.length != 3) {
            System.out.println("Usage: view <personName> <documentName> <documentFormat>");
            return;
        }
        String personName = arguments[0];
        String documentName = arguments[1];
        String documentFormat = arguments[2];
        String filePath = personName + File.separator + documentName + "." + documentFormat;
        File fileToView = new File(filePath);
        if (!fileToView.exists()) {
            System.out.println("The specified document does not exist.");
            return;
        }
        try {
            Desktop.getDesktop().open(fileToView);
        } catch (IOException e) {
            System.out.println("An error occurred while opening the document: " + e.getMessage());
        }
    }
}
