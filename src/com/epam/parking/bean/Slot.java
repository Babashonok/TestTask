package com.epam.parking.bean;

import com.epam.parking.types_enum.SlotType;

import java.io.Serializable;
import java.util.InputMismatchException;

/**
 * Bean Class for Slots
 */
public class Slot implements Serializable {

    private int number;
    private SlotType type;
    private boolean isCovered;
    private boolean isOccupied;
    {
        isOccupied = false;
    }
    public Slot() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Slot slot = (Slot) o;

        if (number != slot.number) return false;
        if (isCovered != slot.isCovered) return false;
        return type == slot.type;
    }

    @Override
    public int hashCode() {
        int result = number;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (isCovered ? 1 : 0);
        return result;
    }

    public boolean isCovered() {
        return isCovered;
    }

    public void setCovered(String covered) {
        if (covered.equalsIgnoreCase("Y")) {
            isCovered = true;
        } else if (covered.equalsIgnoreCase("N")) {
            isCovered = false;
        } else {
            throw new InputMismatchException("wrong Covered parameter input");
        }
    }

    public SlotType getType() {
        return type;
    }

    public void setType(String type) {
        try {
            this.type = SlotType.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InputMismatchException("wrong Slot Type input");
        }

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(String number) {
        try {
            if (number.startsWith("-") || number.startsWith("0")) {
                throw new InputMismatchException("try to input positive unique number");
            }
            this.number = Integer.valueOf(number);
        } catch (NumberFormatException e) {
            throw new InputMismatchException("invalid input number");
        }
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}
