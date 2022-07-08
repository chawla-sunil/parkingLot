package constants;

public enum BeanMapEnum {

    PARKING_LOT_SERVICE("PARKING_LOT_SERVICE"), PARKING_LOT_ACTION("PARKING_LOT_ACTION");

    private String name;

    BeanMapEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
