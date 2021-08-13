package com.example.headfirst;

import com.example.stereotype.Client;

@Client
public class Main {

    public static void main(String[] args) {
        Light light = new Light();
        LightCommand lightOnCommand = new LightOnCommand(light);
        lightOnCommand.execute();

        LightCommand lightOffCommand = new LightOffCommand(light);
        lightOffCommand.execute();
    }
}
