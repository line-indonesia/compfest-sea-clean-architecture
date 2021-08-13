package com.example.baeldung;

import com.example.stereotype.Client;

@Client
public class Main {

    public static void main(String[] args) {
        TextFileOperation operation1 = new OpenFileOperation(new TextFile("a.txt"));
        var result1 = operation1.execute();
        System.out.println("Result 1 " + result1);

        TextFileOperation operation2 = new SaveFileOperation(new TextFile("b.txt"));
        var result2 = operation2.execute();
        System.out.println("Result 2 " + result2);
    }
}
