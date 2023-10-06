package jwp.controller.enums;

public enum RequestURL {
    USER_LIST_JSP("/user/list.jsp"),
    USER_LIST("/user/list"),
    LOGIN_JSP("/user/login.jsp"),
    LOGIN_POST("/user/login"),
    LOGIN_FAILED_JSP("/user/loginFailed.jsp"),
    LOGOUT("/user/logout"),
    SIGNUP("/user/signup"),
    UPDATE_FORM_JSP("/user/updateForm.jsp"),
    HOME("/"),
    HOME_JSP("/home.jsp");

    private String url;

    RequestURL(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

}
