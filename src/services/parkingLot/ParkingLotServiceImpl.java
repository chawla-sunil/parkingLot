package services.parkingLot;

import constants.FilterTypeEnum;
import models.Slot;
import models.Vehicle;
import request.parkingLot.ParkingLotRequest;
import response.ParkingLotResponse;
import utils.Filter;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ParkingLotServiceImpl implements ParkingLotService{
    @Override
    public ParkingLotResponse createParkingLot(ParkingLotRequest parkingLotRequest) throws IndexOutOfBoundsException {

        Map<Integer, Slot> slotMap = parkingLotRequest.getSlotMap();
        ParkingLotResponse parkingLotResponse = new ParkingLotResponse();

        if(slotMap.size()>0) {
            parkingLotResponse.setResponse("Parking lot is already created.");
            return parkingLotResponse;
        }

        String[] data = parkingLotRequest.getData();

        Integer slotCount = Integer.parseInt(data[1]);

        // Create slot map with event[1] parking slots
        for (int i = 1; i <= slotCount; i++) slotMap.put(i, null);


        parkingLotResponse.setResponse("Created parking of " + slotCount + " slots");

        return parkingLotResponse;
    }

    @Override
    public ParkingLotResponse park(ParkingLotRequest parkingLotRequest) throws IndexOutOfBoundsException {

        Map<Integer, Slot> slotMap = parkingLotRequest.getSlotMap();
        String[] data = parkingLotRequest.getData();
        String vehicleNumber = data[1];
        String driverAge = data[3];

        Optional<Slot> vehicleAlreadyParked = Filter.findVehicleSlot(slotMap, vehicleNumber);
        ParkingLotResponse parkingLotResponse = new ParkingLotResponse();

        if (vehicleAlreadyParked.isPresent()) {
            parkingLotResponse.setResponse("Vehicle already Parked on slot number:" + vehicleAlreadyParked.get().getId());

            return parkingLotResponse;
        }

        for (Integer slotId : slotMap.keySet()) {

            if (slotMap.get(slotId) == null) {

                Slot slot = new Slot();
                Vehicle vehicle = new Vehicle();

                vehicle.setNumber(vehicleNumber);
                vehicle.setAge(driverAge);

                slot.setId(slotId);
                slot.setVehicle(vehicle);
                slotMap.put(slotId, slot);

                parkingLotResponse.setResponse("Car with vehicle registration number " + vehicleNumber + " has been parked at slot number " + slotId);

                return parkingLotResponse;
            }
        }

        parkingLotResponse.setResponse("Excuse us, parking lot is full");

        return parkingLotResponse;
    }

    @Override
    public ParkingLotResponse leave(ParkingLotRequest parkingLotRequest) throws IndexOutOfBoundsException {

        Map<Integer, Slot> slotMap = parkingLotRequest.getSlotMap();

        Integer slotId = Integer.parseInt(parkingLotRequest.getData()[1]);
        ParkingLotResponse parkingLotResponse = new ParkingLotResponse();
        if(slotMap.containsKey(slotId)){
            Slot slot = slotMap.get(slotId);
            slotMap.put(slotId, null);
            parkingLotResponse.setResponse("Slot number " + slotId + " vacated, the car with vehicle registration number " + slot.getVehicle().getNumber() + " left the space, the driver of the car was of age " + slot.getVehicle().getAge());
        }else {
            parkingLotResponse.setResponse("slot number exceed the total parking count i.e "+slotMap.size());
        }

        return parkingLotResponse;
    }

    @Override
    public ParkingLotResponse status(ParkingLotRequest parkingLotRequest) throws IndexOutOfBoundsException {

        Map<Integer, Slot> slotMap = parkingLotRequest.getSlotMap();
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append("Slot No.\tRegistration No.\tAge\n");
        slotMap.forEach((slotId, slot) -> {
            if (slot != null)
                stringBuffer.append(slotId + "\t" + slot.getVehicle().getNumber() + "\t" + slot.getVehicle().getAge() + "\n");
        });

        ParkingLotResponse parkingLotResponse = new ParkingLotResponse();
        parkingLotResponse.setResponse(stringBuffer.toString());

        return parkingLotResponse;
    }


    @Override
    public ParkingLotResponse regNoOfCarWithAge(ParkingLotRequest parkingLotRequest) throws IndexOutOfBoundsException {

        Map<Integer, Slot> slotMap = parkingLotRequest.getSlotMap();
        StringBuffer stringBuffer = new StringBuffer();
        String age = parkingLotRequest.getData()[1];

        List<Slot> slotList = Filter.filterSlotsByType(slotMap, FilterTypeEnum.AGE, age);

        slotList.forEach(slot -> stringBuffer.append(slot.getVehicle().getNumber() + " "));


        ParkingLotResponse parkingLotResponse = new ParkingLotResponse();
        parkingLotResponse.setResponse(stringBuffer.toString().trim());

        return parkingLotResponse;
    }


    @Override
    public ParkingLotResponse slotNoOfCarWithAge(ParkingLotRequest parkingLotRequest) throws IndexOutOfBoundsException {

        Map<Integer, Slot> slotMap = parkingLotRequest.getSlotMap();
        StringBuffer stringBuffer = new StringBuffer();
        String age = parkingLotRequest.getData()[1];

        List<Slot> slotList = Filter.filterSlotsByType(slotMap, FilterTypeEnum.AGE, age);
        slotList.forEach(slot -> stringBuffer.append(slot.getId() + ","));
        if (!stringBuffer.isEmpty()){
            stringBuffer.deleteCharAt(stringBuffer.length()-1);
        }

        ParkingLotResponse parkingLotResponse = new ParkingLotResponse();
        parkingLotResponse.setResponse(stringBuffer.toString());

        return parkingLotResponse;
    }


    @Override
    public ParkingLotResponse slotNoOfCarWithRegNo(ParkingLotRequest parkingLotRequest) throws IndexOutOfBoundsException {
        StringBuffer stringBuffer = new StringBuffer();
        Map<Integer, Slot> slotMap = parkingLotRequest.getSlotMap();
        String regNo = parkingLotRequest.getData()[1];

        List<Slot> slotList = Filter.filterSlotsByType(slotMap, FilterTypeEnum.REG_NO, regNo);
        slotList.forEach(slot -> stringBuffer.append(slot.getId()));

        ParkingLotResponse parkingLotResponse = new ParkingLotResponse();
        parkingLotResponse.setResponse(stringBuffer.toString().length() > 0 ? stringBuffer.toString() : "Not Found");

        return parkingLotResponse;
    }
}
