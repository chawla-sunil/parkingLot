package request.operation;

import models.Slot;

import java.util.Map;

public class OperationRequest {

    private Map<Integer, Slot> slotMap;

    public Map<Integer, Slot> getSlotMap() { return slotMap; }
    public void setSlotMap(Map<Integer, Slot> slotMap) { this.slotMap = slotMap; }
}

