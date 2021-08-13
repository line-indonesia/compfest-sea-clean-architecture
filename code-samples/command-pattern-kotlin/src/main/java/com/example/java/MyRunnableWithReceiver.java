package com.example.java;

import com.example.stereotype.ConcreteCommand;

@ConcreteCommand
public class MyRunnableWithReceiver implements Runnable {

    private final MyReceiver receiver;

    public MyRunnableWithReceiver(MyReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void run() {
        receiver.print();
    }
}
