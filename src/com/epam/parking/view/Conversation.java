package com.epam.parking.view;

import com.epam.parking.controller.command.Controller;

import java.util.Scanner;

/**
 * Emulates conversation between user and application
 */
public class Conversation {

    /**
     * Print Welcome message and list of commands
     * Start request input
     */
    public static void startConversation() {
        MessageStorage.printWelcomeMessage();
        Controller controller = Controller.getInstance();
        realTimeRequesting(controller);
        MessageStorage.printEndMessage();
    }

    /**
     * Loop method, that handles and performs user requests
     * wait "exit" , to end this loop
     * @param controller controller layer instance
     */
    private static void realTimeRequesting(Controller controller) {
        MessageStorage.askForCommandInput();
        String tempCommand = new Scanner(System.in).nextLine();
        if (!tempCommand.equalsIgnoreCase("exit")) {
            System.out.println(controller.execute(tempCommand));
            realTimeRequesting(controller);
        }
    }
}

