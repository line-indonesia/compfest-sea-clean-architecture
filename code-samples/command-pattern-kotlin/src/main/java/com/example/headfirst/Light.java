package com.example.headfirst;

import com.example.stereotype.Receiver;

@Receiver
public class Light {
    public void on() {
        System.out.println("Turn the light on");
    }

    public void off() {
        System.out.println("Turn the light off");
    }
}
