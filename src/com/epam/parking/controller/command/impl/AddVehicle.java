package com.epam.parking.controller.command.impl;

import com.epam.parking.bean.Vehicle;
import com.epam.parking.controller.command.Command;
import com.epam.parking.service.VehicleService;
import com.epam.parking.service.exception.RegisterEntityException;
import com.epam.parking.service.factory.ServiceFactory;

import java.util.InputMismatchException;

/**
 * AddVehicle command realization
 */
public class AddVehicle implements Command {

    /**
     * invokes vehicle service and transfer to it user request to add vehicle
     * @param request split input parameters
     * @return response about adding
     */
    @Override
    public String execute(String [] request) {
        Vehicle vehicle;
        try {
            vehicle = createVehicle(request);
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            VehicleService vehicleService = serviceFactory.getVehicleService();
            vehicleService.createVehicle(vehicle);
        } catch (InputMismatchException | RegisterEntityException e) {
            return e.getMessage();
        }
        return "Vehicle successfully created";
    }

    private Vehicle createVehicle(String[] request) {
        Vehicle vehicle = new Vehicle();
        vehicle.setRegNumber(request[1]);
        vehicle.setType(request[2]);
        return vehicle;
    }
}
