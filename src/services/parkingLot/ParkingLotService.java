package services.parkingLot;

import request.parkingLot.ParkingLotRequest;
import response.ParkingLotResponse;

public interface ParkingLotService {

    // Creating Parking Lot.
    ParkingLotResponse createParkingLot(ParkingLotRequest parkingLotRequest) throws IndexOutOfBoundsException;

    // Parking the Vehicle at a Slot.
    ParkingLotResponse park(ParkingLotRequest parkingLotRequest) throws IndexOutOfBoundsException;

    // Vacating a vehicle from the Parking Lot.
    ParkingLotResponse leave(ParkingLotRequest parkingLotRequest) throws IndexOutOfBoundsException;

    // Status of the Parking Lot.
    ParkingLotResponse status(ParkingLotRequest parkingLotRequest) throws IndexOutOfBoundsException;

    // Fetching Registration Number of Car With age.
    ParkingLotResponse regNoOfCarWithAge(ParkingLotRequest parkingLotRequest) throws IndexOutOfBoundsException;

    // Fetching Slot Number of Car With age.
    ParkingLotResponse slotNoOfCarWithAge(ParkingLotRequest parkingLotRequest) throws IndexOutOfBoundsException;

    // Fetching Slot Number of Car With Registration Number
    ParkingLotResponse slotNoOfCarWithRegNo(ParkingLotRequest parkingLotRequest) throws IndexOutOfBoundsException;
}
