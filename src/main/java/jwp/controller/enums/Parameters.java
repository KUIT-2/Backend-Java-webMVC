package jwp.controller.enums;

public enum Parameters {
    USER_ID("userId"),
    PASSWORD("password"),
    NAME("name"),
    EMAIL("email");

    private String value;

    Parameters(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}
