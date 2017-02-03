package com.epam.parking.service.impl;

import com.epam.parking.bean.Slot;
import com.epam.parking.bean.SlotReservation;
import com.epam.parking.bean.Vehicle;
import com.epam.parking.service.exception.NoAvailableSlotsException;
import com.epam.parking.service.exception.RegisterEntityException;
import com.epam.parking.types_enum.SlotType;
import com.epam.parking.types_enum.TypesMapping;
import com.epam.parking.types_enum.VehicleType;
import com.epam.parking.service.SlotService;
import com.epam.parking.storage.SlotReservationHistory;
import com.epam.parking.storage.SlotStorage;
import com.epam.parking.storage.TypesMappingList;

import java.util.InputMismatchException;

/**
 * Slot service interface implement
 * provide all functionality to work with slots
 */
public class SlotServiceImpl implements SlotService {

    private SlotReservationHistory slotReservationHistory = SlotReservationHistory.getInstance();
    private SlotStorage slotStorage = SlotStorage.getInstance();
    private TypesMappingList typesMappingList = TypesMappingList.getInstance();


    @Override
    public void addSlot(Slot slot) throws RegisterEntityException {
        if (!slotStorage.getSlotStorage().containsKey(slot.getNumber())) {
            slotStorage.getSlotStorage().put(slot.getNumber(), slot);
        } else {
            throw new RegisterEntityException("You already have the Slot with this unique identification Number");
        }
    }

    @Override
    public void occupy(Vehicle vehicle, Slot slot) {

        SlotReservation slotReservation = new SlotReservation();
        slot.setOccupied(true);
        slotReservation.setVehicle(vehicle);
        slotReservation.setSlot(slot);
        slotReservation.setStartTime(System.currentTimeMillis());
        slotReservationHistory.getReservationHistory().add(slotReservation);


    }

    @Override
    public StringBuilder getInfoAboutSlotType(SlotType slotType) {
        int [] statValues = {0, 0, 0};
        for (Slot slot : slotStorage.getSlotStorage().values()) {
            if(slot.getType() == slotType && !slot.isOccupied() && slot.isCovered()) {
                statValues[0]++;
                statValues[1]++;
            } else if (slot.getType()== slotType && !slot.isOccupied() && !slot.isCovered()) {
                statValues[0]++;
                statValues[2]++;
            } else if (slot.getType()== slotType) {
                statValues[0]++;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("total ").append(slotType).append(" slots = ")
                .append(statValues[0]).append("\n").append("available ").append(slotType).append(" covered slots = ")
                .append(statValues[1]).append("\n").append("available ").append(slotType).append(" uncovered slots = ")
                .append(statValues[2]).append("\n");
    }

    @Override
    public Slot findFreeSlot(VehicleType vehicleType, String isCovered) throws NoAvailableSlotsException {
        for (Slot temp : slotStorage.getSlotStorage().values()) {
            for (TypesMapping mapping : typesMappingList.getTypeMappingList())
                if (mapping.getVehicleType() == vehicleType && temp.getType() == mapping.getSlotType()
                   && temp.isCovered() == getConvertIsCovered(isCovered) && !temp.isOccupied()) {
                    return temp;
            }
        }
        throw new NoAvailableSlotsException("There are no available slots of this type");
    }

    private boolean getConvertIsCovered(String isCovered) {
        if (isCovered.equalsIgnoreCase("y")) {
            return true;
        }
        if (isCovered.equalsIgnoreCase("n")) {
            return false;
        }
        throw new InputMismatchException("try to input valid isCovered values");
    }

    @Override
    public String getSlotStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("total slots = ").append(slotStorage.getSlotStorage().size()).append("\n");
        for (SlotType slotType : SlotType.values()) {
            stringBuilder.append(getInfoAboutSlotType(slotType));
        }
        return String.valueOf(stringBuilder);
    }

    @Override
    public SlotReservation getCurrentSlotReservation(Vehicle vehicle) {
        SlotReservationHistory slotReservationHistory = SlotReservationHistory.getInstance();
        for (SlotReservation temp : slotReservationHistory.getReservationHistory()) {
            if (temp.getVehicle().equals(vehicle) && temp.isActive()) {
                return temp;
            }
        }
        return null;
    }

    @Override
    public SlotReservation freeSlotReservation(SlotReservation slotReservation) {
        slotReservation.setEndTime(System.currentTimeMillis());
        slotReservation.setActive(false);
        slotReservation.getSlot().setOccupied(false);
        return slotReservation;
    }
}
