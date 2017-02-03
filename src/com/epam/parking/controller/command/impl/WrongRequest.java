package com.epam.parking.controller.command.impl;

import com.epam.parking.controller.command.Command;

/**
 * Mock command for any invalid input
 */
public class WrongRequest implements Command {

    /**
     *
     * @param request split input parameters
     * @return error message after invoking
     */
    @Override
    public String execute(String[] request) {
        return "Error! Invalid command input.";
    }
}
