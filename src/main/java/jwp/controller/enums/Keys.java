package jwp.controller.enums;

public enum Keys {
    USER_SESSION_KEY("user"),
    USER_LIST_SESSION_KEY("users");


    private String value;
    Keys(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }



}
