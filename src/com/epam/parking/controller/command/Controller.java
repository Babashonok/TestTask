package com.epam.parking.controller.command;

import com.epam.parking.controller.CommandProvider;

/**
 * Implements controller layer
 */
public class Controller {
    private final CommandProvider commandProvider = new CommandProvider();
    private final static Controller instance = new Controller();

    public static Controller getInstance() {
        return instance;
    }

    private Controller(){
    }

    /**
     * split input String and give it to the command provider
     * @param request input String
     * @return response from executed command
     */
    public String execute(String request) {
        String [] splitRequest = request.split(" +");
        String commandName = splitRequest[0].toUpperCase();
        return commandProvider.getCommand(commandName).execute(splitRequest);
    }
}
