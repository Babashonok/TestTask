package com.epam.parking.service.impl;

import com.epam.parking.bean.SlotReservation;
import com.epam.parking.bean.Vehicle;
import com.epam.parking.price.Price;
import com.epam.parking.service.CostService;

import java.util.InputMismatchException;


/**
 * Cost service interface implement
 * provide all functionality to work with occupation cost
 */
public class CostServiceImpl implements CostService {
    @Override
    public double getOccupationCost(SlotReservation slotReservation) {
        Price price = Price.getInstance();
        return price.getDiscountCoeff(slotReservation.getVehicle()) * price.getCoverCoeff(slotReservation.getSlot())
                * price.getVehicleTypeCoeff(slotReservation.getVehicle())
                * price.getTimeCoeff(slotReservation.getStartTime(), slotReservation.getEndTime())
                * price.getTimeSpend(slotReservation.getStartTime(), slotReservation.getEndTime());
    }
    @Override
    public void setDiscountCoeff(Vehicle vehicle, String newValue) {
        double newCoeff;
        try {
            if (newValue.startsWith("-")) {
                throw new InputMismatchException("try to input positive discount number");
            }
            newCoeff = Double.valueOf(newValue);
        } catch (NumberFormatException e) {
            throw new InputMismatchException("invalid input number");
        }
        vehicle.setDiscountCoefficient(newCoeff);
    }
}
