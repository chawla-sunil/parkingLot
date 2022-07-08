package utils;


import constants.FilterTypeEnum;
import models.Slot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Filter {

    public static List<Slot> filterSlotsByType(Map<Integer, Slot> slotMap, FilterTypeEnum FILTERTYPE, String filterValue) {

        Stream<Map.Entry<Integer, Slot>> slotMapStream = slotMap.entrySet().stream();

        switch (FILTERTYPE) {
            case AGE: {
                return slotMapStream.filter(slotEntry-> slotEntry.getValue()!=null
                                && slotEntry.getValue().getVehicle() != null
                                && filterValue.equalsIgnoreCase(slotEntry.getValue().getVehicle().getAge()))
                        .map(Map.Entry::getValue)
                        .collect(Collectors.toList());
            }
            case REG_NO: {
                return slotMapStream.filter(slotEntry-> slotEntry.getValue()!=null
                                && slotEntry.getValue().getVehicle() != null
                                && filterValue.equalsIgnoreCase(slotEntry.getValue().getVehicle().getNumber()))
                        .map(slotEntry -> slotEntry.getValue())
                        .collect(Collectors.toList());
            }
        }

        return new ArrayList<>();
    }

    public static Optional<Slot> findVehicleSlot(Map<Integer, Slot> slotMap, String vehicleNumber) {
        return slotMap.values().stream().filter(slot -> slot != null
                && slot.getVehicle() != null
                && slot.getVehicle().getNumber().equalsIgnoreCase(vehicleNumber)).findFirst();
    }

}
