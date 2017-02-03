package com.epam.parking.service;

import com.epam.parking.bean.SlotReservation;
import com.epam.parking.bean.Vehicle;

/**
 * describes behavior of Cost Service Entity
 */
public interface CostService {
    /**
     * invoked together with free slot method from SlotService
     * @param slotReservation active slot reservation, that was ended during free slot execution
     * @return get total cost
     */
    double getOccupationCost(SlotReservation slotReservation);

    /**
     * provide opportunity to change vehicle discount coefficient
     * @param vehicle to change it discount coefficient
     * @param newValue new discount coefficient
     */
    void setDiscountCoeff(Vehicle vehicle, String newValue);

}
