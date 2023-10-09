package jwp.webServer;

public enum RequestURL {
    HOME("/"),
    USER_SIGNUP("/user/signup"),
    USER_LIST("/user/list"),
    USER_LOGIN("/user/login"),
    USER_LOGOUT("/user/logout"),
    USER_UPDATE("/user/update");

    private String url;

    RequestURL(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}