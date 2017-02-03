package com.epam.parking.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Bean Class for Slot Reservations
 */
public class SlotReservation implements Serializable {

    private Vehicle vehicle;
    private Slot slot;
    private long startTime;
    private long endTime;
    private boolean isActive;
    {
        this.isActive = true;
    }

    public SlotReservation() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SlotReservation that = (SlotReservation) o;

        if (startTime != that.startTime) return false;
        if (endTime != that.endTime) return false;
        if (isActive != that.isActive) return false;
        if (vehicle != null ? !vehicle.equals(that.vehicle) : that.vehicle != null) return false;
        return slot != null ? slot.equals(that.slot) : that.slot == null;

    }

    @Override
    public int hashCode() {
        int result = vehicle != null ? vehicle.hashCode() : 0;
        result = 31 * result + (slot != null ? slot.hashCode() : 0);
        result = 31 * result + (int) (startTime ^ (startTime >>> 32));
        result = 31 * result + (int) (endTime ^ (endTime >>> 32));
        result = 31 * result + (isActive ? 1 : 0);
        return result;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }
    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }


    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
