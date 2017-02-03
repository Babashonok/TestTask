package com.epam.parking.controller.command;

/**
 *  Defines behavior for any command input execution
 */
public interface Command {
    /**
     * handle request String and execute command according String array Value
     * @param request split input parameters
     * @return response
     */
    String execute(String [] request);
}
