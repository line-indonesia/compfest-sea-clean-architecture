package com.example.baeldung;

import com.example.stereotype.Invoker;

import java.util.ArrayList;
import java.util.List;

@Invoker
public class TextFileOperationExecutor {

    private final List<TextFileOperation> operationList = new ArrayList<>();

    public String executeOperation(TextFileOperation textFileOperation) {
        operationList.add(textFileOperation);
        return textFileOperation.execute();
    }
}
