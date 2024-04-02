package org.example.Commands;

import java.io.IOException;

public interface Command {
    void execute(String[] arguments) throws IOException;
}
