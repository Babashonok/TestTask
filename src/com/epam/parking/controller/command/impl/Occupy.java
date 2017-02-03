package com.epam.parking.controller.command.impl;

import com.epam.parking.bean.Slot;
import com.epam.parking.bean.Vehicle;
import com.epam.parking.controller.command.Command;
import com.epam.parking.service.SlotService;
import com.epam.parking.service.VehicleService;
import com.epam.parking.service.exception.NoAvailableSlotsException;
import com.epam.parking.service.exception.RegisterEntityException;
import com.epam.parking.service.factory.ServiceFactory;

import java.util.InputMismatchException;

/**
 * Occupy command realization
 */
public class Occupy implements Command {

    /**
     * provide opportunity to occupy slot
     * @param request split input parameters
     * @return response about slot occupation
     *
     */
    @Override
    public String execute(String[] request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        SlotService slotService = serviceFactory.getSlotService();
        VehicleService vehicleService = serviceFactory.getVehicleService();
        Vehicle vehicle;
        Slot slot;
        try {
            vehicle = vehicleService.getVehicle(request[1]);
            slot = slotService.findFreeSlot(vehicle.getType(),request[2]);
        } catch (RegisterEntityException | NoAvailableSlotsException | InputMismatchException e) {
            return e.getMessage();
        }
        slotService.occupy(vehicle, slot);
        return "slot successfully occupied";
    }
}
