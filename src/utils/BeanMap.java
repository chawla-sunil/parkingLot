package utils;

import action.ParkingLotAction;
import constants.BeanMapEnum;
import services.parkingLot.ParkingLotServiceImpl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static constants.BeanMapEnum.PARKING_LOT_ACTION;
import static constants.BeanMapEnum.PARKING_LOT_SERVICE;

public class BeanMap {

    private static Map<BeanMapEnum, Object> beanMap;

    static {

        beanMap = Map.of(PARKING_LOT_SERVICE, new ParkingLotServiceImpl(), PARKING_LOT_ACTION, new ParkingLotAction());
    }

    public static Map<BeanMapEnum, Object> getBeanMap() {
        return beanMap;
    }
}
