package com.example.java;

import com.example.stereotype.ConcreteCommand;

@ConcreteCommand
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Run on a separate thread");
    }
}
