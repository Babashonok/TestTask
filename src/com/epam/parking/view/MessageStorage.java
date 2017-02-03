package com.epam.parking.view;

/**
 * Storage for different console messages
 */
 class MessageStorage {

    static void printWelcomeMessage() {
        System.out.println(new StringBuilder("Welcome to he parking management application ").append('\n')
                .append("This application provides to you several functions :").append('\n')
                .append("to execute function you should input it name and parameters divided by spaces").append('\n')
                .append("1) AddVehicle uniqueRegNumber Type(Car/Motorcycle)").append('\n')
                .append("2) AddSlot uniqueNumber Size(Little/Regular) isCovered(Y/N) ").append('\n')
                .append("3) Occupy VehicleRegNumber isCovered(Y/N) - to occupy proper parking slot").append('\n')
                .append("4) FreeSlot VehicleRegNumber - to release occupied slot ").append('\n')
                .append("5) Stat -  to find all information about slots").append('\n')
                .append("6) Discount VehicleRegNumber Coefficient(1 - no discount/ 0 - free parking) - get discount bonuses ").append('\n')
                .append("7) Exit - to end the working session").append('\n')
                .append("Try to input correct name of the command.Good Luck!"));
    }
    static void askForCommandInput() {
        System.out.print("Input : ");
    }
    static void printEndMessage() {
        System.out.println("Thanks for using our application!");
    }
}
