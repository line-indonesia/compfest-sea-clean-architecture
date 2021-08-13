package com.example.headfirst;

import com.example.stereotype.ConcreteCommand;

@ConcreteCommand
public class LightOffCommand implements LightCommand {
    private final Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
}
