package com.epam.parking.storage;

import com.epam.parking.types_enum.SlotType;
import com.epam.parking.types_enum.TypesMapping;
import com.epam.parking.types_enum.VehicleType;

import java.util.ArrayList;

/**
 * Storage of the typeMapping units
 */
public class TypesMappingList {
    private static final TypesMappingList instance = new TypesMappingList();

    private ArrayList<TypesMapping> typeMappingList = new ArrayList<>();

    {
        getTypeMappingList().add(new TypesMapping(VehicleType.MOTORCYCLE, SlotType.LITTLE));
        getTypeMappingList().add(new TypesMapping(VehicleType.CAR, SlotType.REGULAR));
    }


    public  ArrayList<TypesMapping> getTypeMappingList() {
        return typeMappingList;
    }


    private TypesMappingList() {
    }

    public static TypesMappingList getInstance() {
        return instance;
    }

}
