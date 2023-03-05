package com.github.javarushcommunity.jrtb.command;


import com.google.common.collect.ImmutableMap;

public class CommandContainer {
    private final Command unknownCommand;

    private final ImmutableMap<String, Command> commandMap;


    public CommandContainer(Command unknownCommand, ImmutableMap<String, Command> commandMap) {
        this.unknownCommand = unknownCommand;
        this.commandMap = commandMap;

    }

    public Command retrieveCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }
}
