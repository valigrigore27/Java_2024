package org.example.Commands;

public class ExitCommand implements Command {
    @Override
    public void execute(String[] arguments) {
        System.out.println("Exiting the shell.");
        System.exit(0);
    }
}
