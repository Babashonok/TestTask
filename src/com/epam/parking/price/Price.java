package com.epam.parking.price;

import com.epam.parking.bean.Slot;
import com.epam.parking.bean.Vehicle;
import java.util.concurrent.TimeUnit;


/**
 * Describes occupation cost coefficients
 */
public class Price {

    private static final Price instance = new Price();

    /**
     * should be reworked, when new vehicle type added
     * @param vehicle under execution
     * @return car type cost coefficient
     */
    public double getVehicleTypeCoeff(Vehicle vehicle){
        switch (vehicle.getType()) {
            case CAR:
                return 1;
            case MOTORCYCLE:
                return 0.7;
        }
        throw new IllegalArgumentException("Error! Vehicle has unrecognized type");
    }

    /**
     *
     * @param slot under execution
     * @return slot cover cost coefficient
     */
    public double getCoverCoeff(Slot slot) {
        return slot.isOccupied() ? 1.2 : 1;
    }

    /**
     *
     * @param startTime begin of the slot occupation
     * @param endTime end of the slot occupation
     * @return time spent coefficient according the task
     */
    public double getTimeCoeff(long startTime, long endTime) {
        if (endTime - startTime <= TimeUnit.HOURS.toMillis(4)) {
            return 1.5;
        } else if (endTime - startTime <= TimeUnit.HOURS.toMillis(5)) {
            return 1.2;
        }
        return 1;
    }

    /**
     * NOTE : if program will be executed in the real time situations, change return option
     * @param startTime begin of the slot occupation
     * @param endTime end of the slot occupation
     * @return total time spend (in millis)
     */
    public double getTimeSpend(long startTime, long endTime) {
       // return TimeUnit.MILLISECONDS.toHours(endTime - startTime);
        return endTime - startTime;
    }

    private Price() {
    }

    public static Price getInstance() {
        return instance;
    }

    public double getDiscountCoeff(Vehicle vehicle) {
        return vehicle.getDiscountCoefficient();
    }

}
