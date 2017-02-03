package com.epam.parking.controller.command.impl;


import com.epam.parking.bean.SlotReservation;
import com.epam.parking.controller.command.Command;
import com.epam.parking.service.CostService;
import com.epam.parking.service.SlotService;
import com.epam.parking.service.VehicleService;
import com.epam.parking.service.exception.RegisterEntityException;
import com.epam.parking.service.factory.ServiceFactory;

/**
 * free slot command realization
 */
public class FreeSlot implements Command{
    /**
     * provide opportunity to free occupied slot
     * @param request split input parameters
     * @return response about free slot and occupation cost
     *
     */
    @Override
    public String execute(String[] request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        SlotService slotService = serviceFactory.getSlotService();
        CostService costService = serviceFactory.getCostService();
        VehicleService vehicleService = serviceFactory.getVehicleService();
        SlotReservation slotReservation;
        try {
             slotReservation = slotService.getCurrentSlotReservation(vehicleService.getVehicle(request[1]));
        } catch (RegisterEntityException e) {
            return e.getMessage();
        }
        slotReservation = slotService.freeSlotReservation(slotReservation);
        return String.valueOf(new StringBuilder().append("Vehicle successfully left the parking").append("\n")
                .append("Occupation cost = ").append(costService.getOccupationCost(slotReservation)));
    }
}
