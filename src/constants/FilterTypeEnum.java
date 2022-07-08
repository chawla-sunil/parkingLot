package constants;


public enum FilterTypeEnum {

    AGE("AGE"), REG_NO("REG_NO"), NOT_SUPPORTED_OPERATION("NOT_SUPPORTED_OPERATION");

    private String name;

    FilterTypeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
