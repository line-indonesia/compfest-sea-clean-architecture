package com.example.headfirst;

import com.example.stereotype.ConcreteCommand;

@ConcreteCommand
public class LightOnCommand implements LightCommand {
    private final Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
