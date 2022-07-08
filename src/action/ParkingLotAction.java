package action;

import constants.ParkingLotServicesEnum;
import models.Slot;
import request.parkingLot.ParkingLotRequest;
import services.parkingLot.ParkingLotService;
import utils.BeanMap;

import java.util.Map;
import java.util.Optional;

import static constants.BeanMapEnum.PARKING_LOT_SERVICE;
import static constants.ParkingLotServicesEnum.NOT_SUPPORTED_OPERATION;

public class ParkingLotAction {

    // OperationService being done
    public String action(String[] doEvent, Map<Integer, Slot> slotMap) throws IndexOutOfBoundsException {

        Optional<ParkingLotServicesEnum> parkingLotOptional = ParkingLotServicesEnum.getParkingLotEnum(doEvent[0].trim());
        //ParkingLotServicesEnum parkingLotOperation = parkingLotOptional.orElse(ParkingLotServicesEnum.NOT_SUPPORTED_OPERATION);
        ParkingLotServicesEnum parkingLotOperation = parkingLotOptional.isPresent() ? parkingLotOptional.get() : NOT_SUPPORTED_OPERATION;


        ParkingLotService parkingLotService = (ParkingLotService) BeanMap.getBeanMap().get(PARKING_LOT_SERVICE);

        ParkingLotRequest parkingLotRequest = new ParkingLotRequest();
        parkingLotRequest.setSlotMap(slotMap);
        parkingLotRequest.setData(doEvent);

        switch (parkingLotOperation) {

            case CREATE_PARKING_LOT: {
                return parkingLotService.createParkingLot(parkingLotRequest).getResponse();
            }
            case PARK: {
                return parkingLotService.park(parkingLotRequest).getResponse();
            }
            case LEAVE: {
                return parkingLotService.leave(parkingLotRequest).getResponse();
            }
            case STATUS: {
                return parkingLotService.status(parkingLotRequest).getResponse();
            }
            case REG_NO_OF_CARS_WITH_AGE: {
                return parkingLotService.regNoOfCarWithAge(parkingLotRequest).getResponse();
            }
            case SLOT_NO_OF_CARS_WITH_AGE: {
                return parkingLotService.slotNoOfCarWithAge(parkingLotRequest).getResponse();
            }
            case SLOT_NO_OF_CARS_FOR_REG_NO: {
                return parkingLotService.slotNoOfCarWithRegNo(parkingLotRequest).getResponse();
            }
            default: {
                return ParkingLotServicesEnum.NOT_SUPPORTED_OPERATION.getName();
            }
        }
    }
}
