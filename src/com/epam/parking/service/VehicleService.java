package com.epam.parking.service;

import com.epam.parking.bean.Vehicle;
import com.epam.parking.service.exception.RegisterEntityException;

/**
 * describes behavior of Vehicle Service Entity
 */
public interface VehicleService {
    /**
     * get vehicle according regNumber or ask for adding this vehicle, if it no matches in the vehicle storage
     * @param regNumber number to find the vehicle
     * @return found vehicle
     * @throws RegisterEntityException if it no matches in the vehicle storage
     */
    Vehicle getVehicle(String regNumber) throws RegisterEntityException;

    /**
     * add vehicle to the vehicle storage
     * @param vehicle to add to the vehicle storage
     * @throws RegisterEntityException if vehicle with that regNumber already registrated
     */
    void createVehicle(Vehicle vehicle) throws RegisterEntityException;

}
