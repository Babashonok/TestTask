package com.epam.parking.service;

import com.epam.parking.bean.Slot;
import com.epam.parking.bean.SlotReservation;
import com.epam.parking.bean.Vehicle;
import com.epam.parking.service.exception.NoAvailableSlotsException;
import com.epam.parking.service.exception.RegisterEntityException;
import com.epam.parking.types_enum.SlotType;
import com.epam.parking.types_enum.VehicleType;

/**
 * describes behavior of Slot Service Entity
 */
public interface SlotService {
    /**
     * add slot to the slot storage
     * @param slot new slot to add
     * @throws RegisterEntityException if this slot cannot be added
     */
    void addSlot(Slot slot) throws RegisterEntityException;

    /**
     * bind vehicle and slot, start occupation time
     * @param vehicle that visits parking
     * @param slot available slot for current vehicle
     */
    void occupy(Vehicle vehicle, Slot slot);

    /**
     * using it Stat command
     * @param slotType that used in slot storage searching
     * @return stat information (total count of this type and available (covered/uncovered) count)
     */
    StringBuilder getInfoAboutSlotType(SlotType slotType);

    /**
     * find matching slot for occupation
     * @param vehicleType input type
     * @param isCovered input cover value
     * @return first matching slot
     * @throws NoAvailableSlotsException if no matching slots
     */
    Slot findFreeSlot(VehicleType vehicleType, String isCovered) throws NoAvailableSlotsException;

    /**
     *
     * @return whole statistic about slot storage
     */
    String getSlotStatistics();

    /**
     * return active slot reservation for passed vehicle
     * @param vehicle that left the parking
     * @return active slot reservation
     */
    SlotReservation getCurrentSlotReservation(Vehicle vehicle);

    /**
     * change slot reservation instance, when vehicle left the parking
     * @param slotReservation active slot reservation
     * @return changed slot reservation( inactive and with end time)
     */
    SlotReservation freeSlotReservation(SlotReservation slotReservation);

}
