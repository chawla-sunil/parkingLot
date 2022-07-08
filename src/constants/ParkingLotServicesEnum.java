package constants;

import java.util.Arrays;
import java.util.Optional;

public enum ParkingLotServicesEnum {

    CREATE_PARKING_LOT("Create_parking_lot"),
    PARK("park"),
    DRIVER_AGE("driver_age"),
    LEAVE("Leave"),
    STATUS("status"),
    REG_NO_OF_CARS_WITH_AGE("Vehicle_registration_number_for_driver_of_age"),
    SLOT_NO_OF_CARS_WITH_AGE("Slot_numbers_for_driver_of_age"),
    SLOT_NO_OF_CARS_FOR_REG_NO("Slot_number_for_car_with_number"),
    NOT_SUPPORTED_OPERATION("Not Supported Operation");

    private String name;

    ParkingLotServicesEnum(String name) {
        this.name = name;
    }

    public static Optional<ParkingLotServicesEnum> getParkingLotEnum(String name) {
        return Arrays.stream(ParkingLotServicesEnum.values()).filter(operation -> operation.getName().equalsIgnoreCase(name)).findFirst();
    }

    public String getName() {
        return this.name;
    }
}

