package com.example.baeldung;

import com.example.stereotype.ConcreteCommand;

@ConcreteCommand
public class SaveFileOperation implements TextFileOperation {

    private final TextFile textFile;

    public SaveFileOperation(TextFile textFile) {
        this.textFile = textFile;
    }

    @Override
    public String execute() {
        return textFile.save();
    }
}
