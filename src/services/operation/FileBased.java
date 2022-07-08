package services.operation;

import action.ParkingLotAction;
import models.Slot;
import request.operation.FileBasedOperationRequest;
import request.operation.OperationRequest;
import utils.BeanMap;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import static constants.BeanMapEnum.PARKING_LOT_ACTION;

public class FileBased implements OperationService{
    @Override
    public void performOperation(OperationRequest operationRequest) {
        FileBasedOperationRequest fileBasedOperationRequest = (FileBasedOperationRequest) operationRequest;
        ParkingLotAction parkingLotAction = (ParkingLotAction) BeanMap.getBeanMap().get(PARKING_LOT_ACTION);
        Map<Integer, Slot> slotMap = fileBasedOperationRequest.getSlotMap();

        try {
            BufferedReader br = new BufferedReader(new FileReader(((FileBasedOperationRequest) operationRequest).getFilePath()));

            String str;
            while ((str = br.readLine()) != null) {
                String[] doEvent = str.split(" ");
                System.out.println(parkingLotAction.action(doEvent, slotMap));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Exception happened");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
