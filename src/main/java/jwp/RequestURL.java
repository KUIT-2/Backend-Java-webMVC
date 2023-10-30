package jwp;

public enum RequestURL {
    USER_SIGNUP("/user/signup"),
    ROOT("/"),
    USER_LIST("/user/list"),
    USER_LOGIN("/user/login"),
    USER_LOGOUT("/user/logout"),
    USER_UPDATE("/user/update"),
    USER_UPDATE_FORM("/user/updateForm"),
    HOME("/home"),
    USER_FORM("/user/form"),
    LOGIN("login");

    private String url;
    RequestURL(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}

