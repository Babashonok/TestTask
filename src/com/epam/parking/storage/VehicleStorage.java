package com.epam.parking.storage;

import com.epam.parking.bean.Vehicle;

import java.util.HashMap;

/**
 * Storage for the register vehicles
 */
public class VehicleStorage {
    private static final VehicleStorage instance = new VehicleStorage();

    private VehicleStorage() {

    }
    public static VehicleStorage getInstance() {
        return instance;
    }

    private HashMap<String, Vehicle> vehicleStorage = new HashMap<>();

    public HashMap<String, Vehicle> getVehicleStorage() {
        return vehicleStorage;
    }
}
