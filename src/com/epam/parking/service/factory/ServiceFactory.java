package com.epam.parking.service.factory;

import com.epam.parking.service.CostService;
import com.epam.parking.service.SlotService;
import com.epam.parking.service.VehicleService;
import com.epam.parking.service.impl.CostServiceImpl;
import com.epam.parking.service.impl.SlotServiceImpl;
import com.epam.parking.service.impl.VehicleServiceImpl;

/**
 * Created by Aliaksei_Babak on 2/1/2017.
 */
public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final CostService costService = new CostServiceImpl();
    private final SlotService slotService = new SlotServiceImpl();
    private final VehicleService vehicleService = new VehicleServiceImpl();
    private ServiceFactory(){
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public VehicleService getVehicleService() {
        return vehicleService;
    }

    public SlotService getSlotService() {
        return slotService;
    }

    public CostService getCostService() {
        return costService;
    }
}
