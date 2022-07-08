package request.parkingLot;

import models.Slot;

import java.util.Map;

public class ParkingLotRequest {

    private Map<Integer, Slot> slotMap;
    private String[] data;

    public Map<Integer, Slot> getSlotMap() { return slotMap; }
    public void setSlotMap(Map<Integer, Slot> slotMap) { this.slotMap = slotMap; }

    public String[] getData() { return data; }
    public void setData(String[] data) { this.data = data; }


}
