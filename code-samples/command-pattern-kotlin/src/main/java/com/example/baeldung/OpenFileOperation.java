package com.example.baeldung;

import com.example.stereotype.ConcreteCommand;

@ConcreteCommand
public class OpenFileOperation implements TextFileOperation {

    private final TextFile textFile;

    public OpenFileOperation(TextFile textFile) {
        this.textFile = textFile;
    }

    @Override
    public String execute() {
        return textFile.open();
    }
}
