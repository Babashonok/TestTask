package com.epam.parking.service.impl;

import com.epam.parking.bean.Vehicle;
import com.epam.parking.service.VehicleService;
import com.epam.parking.service.exception.RegisterEntityException;
import com.epam.parking.storage.VehicleStorage;

import java.util.InputMismatchException;

/**
 * Vehicle service interface implement
 * provide all functionality to work with vehicles
 */
public class VehicleServiceImpl implements VehicleService {

    private VehicleStorage vehicleStorage = VehicleStorage.getInstance();

    @Override
    public Vehicle getVehicle(String regNumber) throws RegisterEntityException {
        if (!vehicleStorage.getVehicleStorage().containsKey(regNumber)) {
            throw new RegisterEntityException("You should add Vehicle before using the parking");
        }
        return vehicleStorage.getVehicleStorage().get(regNumber);
    }

    @Override
    public void createVehicle(Vehicle vehicle) throws RegisterEntityException {
        if(!vehicleStorage.getVehicleStorage().containsKey(vehicle.getRegNumber())) {
            vehicleStorage.getVehicleStorage().put(vehicle.getRegNumber(), vehicle);
        } else {
            throw new RegisterEntityException("You already have the Vehicle with this unique regNumber");
        }
    }


}
