package com.epam.parking.storage;

import com.epam.parking.bean.SlotReservation;

import java.util.ArrayList;

/**
 * Storage for the slot reservations
 */
public class SlotReservationHistory {
    private ArrayList<SlotReservation> reservationHistory = new ArrayList<>();
    private static SlotReservationHistory instance = new SlotReservationHistory();
    private SlotReservationHistory() {

    }
    public static  SlotReservationHistory getInstance() {
        return instance;
    }

    public ArrayList<SlotReservation> getReservationHistory() {
        return reservationHistory;
    }
}
