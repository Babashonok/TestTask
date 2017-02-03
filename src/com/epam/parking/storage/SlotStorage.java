package com.epam.parking.storage;

import com.epam.parking.bean.Slot;

import java.util.HashMap;


/**
 * Storage for the slots in the parking
 */
public class SlotStorage {
    private static final SlotStorage instance = new SlotStorage();

    private HashMap<Integer, Slot> slotStorage = new HashMap<>();


    private SlotStorage() {

    }
    public static SlotStorage getInstance() {
        return instance;
    }


    public HashMap<Integer, Slot> getSlotStorage() {
        return slotStorage;
    }
}
