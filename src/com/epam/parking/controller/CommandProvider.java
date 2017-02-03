package com.epam.parking.controller;

import com.epam.parking.controller.command.Command;
import com.epam.parking.controller.command.CommandName;
import com.epam.parking.controller.command.impl.*;

import java.util.HashMap;

/**
 * Provide access to any user command in this application
 */
public class CommandProvider {
    private final HashMap<CommandName, Command> repository = new HashMap<>();

    /**
     * create mapping between command and it command name
     */
    public CommandProvider() {
        repository.put(CommandName.ADDSLOT, new AddSlot());
        repository.put(CommandName.ADDVEHICLE, new AddVehicle());
        repository.put(CommandName.OCCUPY, new Occupy());
        repository.put(CommandName.FREESLOT, new FreeSlot());
        repository.put(CommandName.STAT, new SlotStatistics());
        repository.put(CommandName.DISCOUNT, new Discount());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
    }

    /**
     * find command on its name
     * @param name first word in the console input
     * @return invoked command
     */
    public Command getCommand(String name) {
        CommandName commandName;
        try {
            commandName = CommandName.valueOf(name.toUpperCase());
        } catch (IllegalArgumentException e) {
            return repository.get(CommandName.WRONG_REQUEST);
        }
        return repository.get(commandName);
    }
}
