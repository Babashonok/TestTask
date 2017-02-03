package com.epam.parking.controller.command.impl;

import com.epam.parking.bean.Slot;
import com.epam.parking.controller.command.Command;
import com.epam.parking.service.SlotService;
import com.epam.parking.service.exception.RegisterEntityException;
import com.epam.parking.service.factory.ServiceFactory;

import java.util.InputMismatchException;

/**
 * AddSlot command realization
 */
public class AddSlot implements Command {
    /**
     * invokes slot service and transfer to it user request to add slot
     * @param request split input parameters
     * @return response about adding
     */
    @Override
    public String execute(String [] request) {
        Slot slot;
        try {
            slot = createSlot(request);
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            SlotService slotService = serviceFactory.getSlotService();
            slotService.addSlot(slot);
        } catch (InputMismatchException | RegisterEntityException e) {
            return e.getMessage();
        }
        return "Slot successfully added";
    }

    private Slot createSlot(String [] request) {
        Slot slot = new Slot();
        slot.setNumber(request[1]);
        slot.setType(request[2]);
        slot.setCovered(request[3]);
        return slot;
    }
}
