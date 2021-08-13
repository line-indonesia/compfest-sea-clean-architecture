package com.example.java;

import com.example.stereotype.Client;

@Client
public class Main {

    public static void main(String[] args) throws InterruptedException {
        // Thread is Invoker
        Thread myThread1 = new Thread(new MyRunnable());
        myThread1.start();

        MyReceiver receiver = new MyReceiver();
        Thread myThread2 = new Thread(new MyRunnableWithReceiver(receiver));
        myThread2.start();

        Thread.sleep(100);
    }
}
