package com.epam.parking.types_enum;

/**
 * provide mapping between slotType and VehicleType
 */
public class TypesMapping {
    private SlotType slotType;
    private VehicleType vehicleType;

    public TypesMapping(VehicleType vehicleType, SlotType slotType) {
        this.vehicleType = vehicleType;
        this.slotType = slotType;

    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }


    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public SlotType getSlotType() {
        return slotType;
    }

    public void setSlotType(SlotType slotType) {
        this.slotType = slotType;
    }


}
