package com.epam.parking.controller.command.impl;

import com.epam.parking.bean.Vehicle;
import com.epam.parking.controller.command.Command;
import com.epam.parking.service.CostService;
import com.epam.parking.service.VehicleService;
import com.epam.parking.service.exception.RegisterEntityException;
import com.epam.parking.service.factory.ServiceFactory;

/**
 * Created by Admin on 03.02.17.
 */
public class Discount implements Command {
    /**
     * provides opportunity to change vehicle discount coefficient
     * @param request split input parameters
     * @return response about discount changing
     */
    @Override
    public String execute(String[] request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        VehicleService vehicleService = serviceFactory.getVehicleService();
        CostService costService = serviceFactory.getCostService();
        Vehicle vehicle;
        try {
            vehicle = vehicleService.getVehicle(request[1]);
            costService.setDiscountCoeff(vehicle, request[2]);
        } catch (RegisterEntityException e) {
            return e.getMessage();
        }
        return "discount coefficient successfully updated";

    }
}
