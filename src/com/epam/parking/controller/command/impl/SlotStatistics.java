package com.epam.parking.controller.command.impl;

import com.epam.parking.controller.command.Command;
import com.epam.parking.service.SlotService;
import com.epam.parking.service.factory.ServiceFactory;

/**
 * Stat command realization
 */
public class SlotStatistics implements Command{
    /**
     * invokes slot service and transfer to it user request to get slot statistic
     * @param request split input parameters
     * @return slot statistic info
     */
    @Override
    public String execute(String[] request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        SlotService slotService = serviceFactory.getSlotService();
        return slotService.getSlotStatistics();
    }
}
