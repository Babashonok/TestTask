package com.epam.parking;


import com.epam.parking.controller.command.Controller;
import com.epam.parking.view.Conversation;

/**
 * application, that emulates parking management life cycle
 * @author Aliaksei_Babak
 * @since  01.02.2017
 */
public class Main {
    /**
     * entry point of application
     * @param args non-used arguments from terminal
     */
    public static void main(String[] args) {

        createPredefinedSlots();
        Conversation.startConversation();
    }
    private static void createPredefinedSlots() {
        Controller controller = Controller.getInstance();
        controller.execute("addslot 1 regular y");
        controller.execute("addslot 2 regular n");
        controller.execute("addslot 3 regular y");
        controller.execute("addslot 4 little y");
        controller.execute("addslot 5 little n");
        controller.execute("addslot 6 little n");
    }
}
