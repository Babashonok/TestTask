package com.epam.parking.bean;

import com.epam.parking.types_enum.VehicleType;

import java.io.Serializable;
import java.util.InputMismatchException;

/**
 * Bean Class for Vehicles
 */
public class Vehicle implements Serializable {

    private String regNumber;
    private VehicleType type;
    private double discountCoefficient = 1 ;

    public Vehicle() {
    }

    @Override
    public boolean equals(Object obj) {
        if (this ==  obj) return true;
        if ( obj == null || getClass() !=  obj.getClass()) return false;
        Vehicle vehicle = (Vehicle)  obj;

        return regNumber.equals(vehicle.regNumber);
    }

    @Override
    public int hashCode() {
        return regNumber.hashCode();
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(String type) {
        try {
            this.type = VehicleType.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InputMismatchException("wrong Vehicle Type input");
        }
    }

    public double getDiscountCoefficient() {
        return discountCoefficient;
    }

    public void setDiscountCoefficient(double discountCoefficient) {
        this.discountCoefficient = discountCoefficient;
    }
}
